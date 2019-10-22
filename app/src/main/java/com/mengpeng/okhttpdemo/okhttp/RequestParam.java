package com.mengpeng.okhttpdemo.okhttp;

/**
 * 作用：接收参数param
 */

public class RequestParam {
    public String key ;
    public Object value ;

    public RequestParam(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
