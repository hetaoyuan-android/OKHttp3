package com.mengpeng.okhttpdemo.network.presenter;

import android.content.Context;
import android.util.Log;

import com.mengpeng.okhttpdemo.bean.UserInfoBean;
import com.mengpeng.okhttpdemo.network.BasePresenter;
import com.mengpeng.okhttpdemo.network.InterManage;
import com.mengpeng.okhttpdemo.network.PresentView;
import com.mengpeng.okhttpdemo.network.view.UserInfoView;

import rx.Subscriber;

public class UserInfoPresenter extends BasePresenter {
    private Context mContext;
    private UserInfoView mView;

    public UserInfoPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void bindPresentView(PresentView presentView) {
        super.bindPresentView(presentView);
        mView = (UserInfoView) presentView;
    }

    public void getUserInfo() {
        InterManage.getInstance().getUserInfo(this, new Subscriber<UserInfoBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("报错数据", e.getMessage());
            }

            @Override
            public void onNext(UserInfoBean response) {
                if (response.isResule()) {
                    mView.onSuccess(response, response.getMsg());
                }
            }
        });
    }
}
