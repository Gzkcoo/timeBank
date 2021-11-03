package com.gzk.entity;

public class Student {


    String user;
    String psw;

    public Student(String user, String psw) {
        this.user = user;
        this.psw = psw;
    }

    public Student() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
