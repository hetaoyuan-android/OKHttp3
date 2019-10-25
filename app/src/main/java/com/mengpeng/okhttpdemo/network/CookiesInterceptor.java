package com.mengpeng.okhttpdemo.network;

import android.content.Context;
import android.util.Log;


import com.mengpeng.okhttpdemo.MyApplication;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2016/4/12 0012.
 * cookies拦截，打印请求url
 */
public class CookiesInterceptor implements Interceptor {
    private static final String TAG = CookiesInterceptor.class.getSimpleName();
    private Context context;

    public CookiesInterceptor(Context context) {
        this.context = context;
    }

    //重写拦截方法，处理自定义的Cookies信息
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // 添加新的参数
        HttpUrl.Builder authorizedUrlBuilder = request.url()
                .newBuilder()
//                .encodedQuery("operation_id")
                .scheme(request.url().scheme())
                .host(request.url().host());
        String url = request.url().toString();


        Request compressedRequest = request.newBuilder()
                .method(request.method(), request.body())
                .url(authorizedUrlBuilder.build())
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Cookie", "wkc")
                .addHeader("Connection", "keep-alive")
                .addHeader("accessSource", "2")
                .addHeader("token", MyApplication.getToken())
                .build();

        Log.e("RetrofitUtil", "调用了 client  Token值是 = " + "Bearer " + MyApplication.getToken());

        Response response = chain.proceed(compressedRequest);
        MediaType mediaType = response.body().contentType();
        String content = response.body().string();//string()后会关闭流
        response = response.newBuilder()
                .body(ResponseBody.create(mediaType, content))
                .build();//重新builder一个Response



        //根据和服务端的约定判断token过期
        if (isTokenExpired(content)) {
            Log.d("RetrofitUtil", "自动刷新Token,然后重新请求数据");
            //同步请求方式，获取最新的Token
            String newToken = getNewToken();
            //使用新的Token，创建新的请求
            Request newRequest = chain.request()
                    .newBuilder()
                    .header("token", newToken)
                    .build();
//            PowerApplication.setToken(newToken);
            //重新请求
            return chain.proceed(newRequest);
        } else {
            return response;
        }
    }


    /**
     * 根据Response，判断Token是否失效
     */
    private static boolean isTokenExpired(String content) {
        try {
            JSONObject jsonObject = new JSONObject(content);
            if (jsonObject.getInt("httpCode") == 401) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 同步请求方式，获取最新的Token
     */
    private static String getNewToken() {
        // 通过获取token的接口，同步请求接口
        String newToken = "";
        try {
            String url = UrlConstant.BASE_URL + "olisServices/sm/login";
            OkHttpClient client = new OkHttpClient.Builder().build();
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
//            builder.addFormDataPart("loginName", PowerApplication.getLoginInfo(RepairConstantUtils.USER_SAVE_NAME));
//            builder.addFormDataPart("psw", PowerApplication.getLoginInfo(RepairConstantUtils.PASSWORD));
            Request request = new Request.Builder().url(url).post(builder.build()).build();
            Call call = client.newCall(request);
            Response response = call.execute();
            if (response.isSuccessful()) {
                //注意线程
                if (response.code() == 200) {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    newToken = jsonObject.getString("ticket");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newToken;
    }
}
