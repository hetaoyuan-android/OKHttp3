package com.mengpeng.okhttpdemo;


/**
 * Created by 孟鹏 on 2016/11/17.
 * 作用：
 */

public class UserInfoBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"descirbe":"优化下载速度","version":"2.1.0"}
     */

    private String msg;
    private String code;
    private DataBean data;
    private boolean result;


    public boolean isResule() {
        return result;
    }

    public void setresult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResonseBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * descirbe : 优化下载速度
         * version : 2.1.0
         */

        private String descirbe;
        private String version;

        @Override
        public String toString() {
            return "DataBean{" +
                    "descirbe='" + descirbe + '\'' +
                    ", version='" + version + '\'' +
                    '}';
        }

        public String getDescirbe() {
            return descirbe;
        }

        public void setDescirbe(String descirbe) {
            this.descirbe = descirbe;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
