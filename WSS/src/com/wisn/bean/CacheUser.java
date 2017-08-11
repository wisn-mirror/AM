package com.wisn.bean;

import java.util.ArrayList;
import java.util.List;

public class CacheUser {
    public  long id;
    public  String token;
    public  String  name;
    public  String password;
    public  List<SessionClient> sessionClientList;

    public CacheUser(long id, String token, String name, String password) {
        this.id = id;
        this.token = token;
        this.name = name;
        this.password = password;
        this.sessionClientList=new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
