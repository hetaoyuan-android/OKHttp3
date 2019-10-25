package com.mengpeng.okhttpdemo.network.view;

import com.mengpeng.okhttpdemo.network.PresentView;

public interface UserInfoView extends PresentView {
    void onSuccess(Object bean, String resultMsg);
}
