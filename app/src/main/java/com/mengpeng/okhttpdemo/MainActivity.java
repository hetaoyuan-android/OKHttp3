package com.mengpeng.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mengpeng.okhttpdemo.okhttp.OKHttpCallBack;
import com.mengpeng.okhttpdemo.okhttp.OKHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private TextView tv_msg;
    private TextView tv_dataSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_msg = (TextView) findViewById(R.id.msg);
        tv_dataSize = (TextView) findViewById(R.id.dataSize);


        //不需要异步，已经处理过了，
//        OKHttpUtils.newBuilder().url("http://118.178.241.236/Api/Headhunter/mySpecialist")
//                .post()
//                .addParam("id", "1")
//                .build()
//                .enqueue(new OKHttpCallBack<UserInfoBean>() {
//                    @Override
//                    public void onSuccess(UserInfoBean userInfoBean) {
//                        String msg = userInfoBean.getMsg().toString();
//                        int size = userInfoBean.getData().size();
//                        tv_msg.setText(msg);
//                        tv_dataSize.setText(size+"");
//                    }
//
//                    @Override
//                    public void onError(int code) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//
//                    }
//                });

        OKHttpUtils.newBuilder().url("http://172.16.2.144:8080/untitled_war_exploded/HelloWorld")
                .get()
                .build()
                .enqueue(new OKHttpCallBack<UserInfoBean>() {
                    @Override
                    public void onSuccess(UserInfoBean o) {
                        super.onSuccess(o);
                        if (o.isResule()) {
                            tv_msg.setText(o.getMsg());
                            tv_dataSize.setText(o.getData().getDescirbe());
                        }

                    }

                    @Override
                    public void onError(int code) {
                        super.onError(code);
                    }

                    @Override
                    public void onFailure(Call call, IOException e) {
                        super.onFailure(call, e);
                    }
                });
    }
}
