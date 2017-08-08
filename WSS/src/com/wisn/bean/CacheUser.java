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

}
