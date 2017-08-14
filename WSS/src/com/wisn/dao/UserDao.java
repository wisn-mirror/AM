package com.wisn.dao;

import com.wisn.bean.DeviceInformation;
import com.wisn.bean.User;
import com.wisn.dbm.DbExecute;
import com.wisn.dbm.ResultSetCallBack;

import java.sql.ResultSet;

public class UserDao {
    public DeviceInformation  addUser(DeviceInformation deviceInformation){
        DbExecute db=new DbExecute();
        db.executeInsertOrUpdate("INSERT  into test(contents) VALUE (43243) ", new  ResultSetCallBack() {

            @Override
            public void executeRowCount(int id) {
            }

            @Override
            public void executeResult(ResultSet resultSet) {
                try{
                    boolean exist = resultSet.next();

                }catch(Exception e ){
                    e.printStackTrace();
                }
            }

            @Override
            public void executeGeneratedKeys(ResultSet resultSet) {
            }
        });
        return deviceInformation;
    }

    public User  getUser(String username,String password){
        DbExecute db=new DbExecute();
        final User user=new  User();

        return user;
    }

}
