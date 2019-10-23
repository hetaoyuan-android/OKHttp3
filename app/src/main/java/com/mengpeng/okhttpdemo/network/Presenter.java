package com.mengpeng.okhttpdemo.network;

public interface Presenter {
    //Presenter初始化
    void onCreate();

    //销毁
    void onDestroy();

    //绑定视图
    void BindPresentView(PresentView presentView);
}
