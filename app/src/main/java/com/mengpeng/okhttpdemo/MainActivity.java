package com.mengpeng.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mengpeng.okhttpdemo.bean.UserInfoBean;
import com.mengpeng.okhttpdemo.network.PresentView;
import com.mengpeng.okhttpdemo.network.presenter.UserInfoPresenter;
import com.mengpeng.okhttpdemo.network.view.UserInfoView;
import com.mengpeng.okhttpdemo.okhttp.OKHttpCallBack;
import com.mengpeng.okhttpdemo.okhttp.OKHttpUtils;

import java.io.IOException;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, UserInfoView {

    private TextView tv_msg;
    private TextView tv_dataSize;
    private Button btnConeect;

    private UserInfoBean mBean;
    private UserInfoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_msg = (TextView) findViewById(R.id.msg);
        tv_dataSize = (TextView) findViewById(R.id.dataSize);
        btnConeect = findViewById(R.id.btn_connect);
        initPresenter();
        btnConeect.setOnClickListener(this);

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

//        OKHttpUtils.newBuilder().url("http://172.16.2.144:8080/untitled_war_exploded/HelloWorld")
//                .get()
//                .build()
//                .enqueue(new OKHttpCallBack<UserInfoBean>() {
//                    @Override
//                    public void onSuccess(UserInfoBean o) {
//                        super.onSuccess(o);
//                        if (o.isResule()) {
//                            tv_msg.setText(o.getMsg());
//                            tv_dataSize.setText(o.getData().getDescirbe());
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(int code) {
//                        super.onError(code);
//                    }
//
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        super.onFailure(call, e);
//                    }
//                });
    }

    private void initPresenter() {
        mPresenter = new UserInfoPresenter(this);
        mPresenter.onCreate();
        mPresenter.bindPresentView((PresentView) this);
    }


    @Override
    public void onClick(View v) {
        mPresenter.getUserInfo();
    }

    @Override
    public void onSuccess(Object bean, String resultMsg) {
        mBean = (UserInfoBean) bean;
        if (mBean.isResule()) {
            tv_msg.setText(mBean.getMsg());
            tv_dataSize.setText(mBean.getData().getDescirbe());
        } else {
            Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(String result) {
        Log.e("hetao", result);
    }
}
