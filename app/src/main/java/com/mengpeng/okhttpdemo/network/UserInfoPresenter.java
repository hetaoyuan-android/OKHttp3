package com.mengpeng.okhttpdemo.network;

import android.content.Context;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 该类是具体业务presenter，如需增加另一个业务，比如Order
 * 则可以再创建一个OrderPresenter
 */
public class UserInfoPresenter extends BasePresenter {
    private Context mContext;
    private UserInfoPv mUserInfoPv;
    private UserInfo mUserInfo;

    public UserInfoPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void bindPresentView(PresentView presentView) {
        mUserInfoPv = (UserInfoPv) presentView;
    }

    //在presenter中实现业务逻辑，此处会调用前面封装好的retrofit的东西
    //将处理结果绑定到对应的PresentView实例，这样Activity和PresentView实例绑定好之后，
    //Activity->PresentView->Presenter->retrofit的关系就打通了
    public void getUserInfo(int uid) {
        super.mCompositeSubscription.add(DataManager.getInstance(mContext).getUserInfo(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfo>() {
                    @Override
                    public void onCompleted() {
                        if (mUserInfo != null) {
                            mUserInfoPv.onSuccess(mUserInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                        mUserInfoPv.onError("请求失败！");
                    }

                    @Override
                    public void onNext(UserInfo userInfo) {
                        mUserInfo = userInfo;
                    }
                }));
    }
}
