package com.mengpeng.okhttpdemo;

import java.util.List;

/**
 * Created by 孟鹏 on 2016/11/17.
 * 作用：
 */

public class UserInfoBean {

    /**
     * code : 200
     * msg : 相关数据
     * data : [{"id":"13","user_name":"1"},{"id":"12","user_name":"1"},{"id":"11","user_name":"1"},{"id":"10","user_name":"1"},{"id":"9","user_name":"1"},{"id":"8","user_name":"1"},{"id":"7","user_name":"1"},{"id":"6","user_name":"1"},{"id":"5","user_name":"1"},{"id":"4","user_name":"1"},{"id":"3","user_name":"1"},{"id":"2","user_name":"1"},{"id":"1","user_name":"1"}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 13
         * user_name : 1
         */

        private String id;
        private String user_name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
    }
}
