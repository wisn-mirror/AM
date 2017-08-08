package com.wisn.bean;

public class User {
    public  long id;
    public  String token;
    public  String  name;
    public  String password;

    public User() {
    }

    public User(long id, String token, String name) {
        this.id = id;
        this.token = token;
        this.name = name;
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
