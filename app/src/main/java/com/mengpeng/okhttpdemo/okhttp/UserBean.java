package com.mengpeng.okhttpdemo.okhttp;

/**
 * Created by 孟鹏 on 2016-11-2-0002.
 * 作用：
 */

public class UserBean {
    private int age;
    private String name;
    private String sex;

    public UserBean(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
