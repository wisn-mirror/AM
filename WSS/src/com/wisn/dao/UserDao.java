package com.wisn.dao;

import com.wisn.bean.User;
import com.wisn.dbm.DbExecute;
import com.wisn.dbm.ResultSetCallBack;

import java.sql.ResultSet;

public class UserDao {
    public User  addUser(String username,String password){
        DbExecute db=new DbExecute();
        final User user=new  User();
        db.executePrepareQuery("select * from user where  name=?  and password=? ", new  ResultSetCallBack() {

            @Override
            public void executeRowCount(int id) {
            }

            @Override
            public void executeResult(ResultSet resultSet) {
                try{
                    boolean exist = resultSet.next();
                    if(exist){
                        String  name=resultSet.getString("name");
                        String  password=resultSet.getString("password");
                        user.setName(name);
                        user.setPassword(password);
                    }
                }catch(Exception e ){
                    e.printStackTrace();
                }
            }

            @Override
            public void executeGeneratedKeys(ResultSet resultSet) {
            }
        },username,password);
        return user;
    }

    public User  getUser(String username,String password){
        DbExecute db=new DbExecute();
        final User user=new  User();
        db.executePrepareQuery("insert into ", new  ResultSetCallBack() {

            @Override
            public void executeRowCount(int id) {
            }

            @Override
            public void executeResult(ResultSet resultSet) {
                try{
                    boolean exist = resultSet.next();
                    if(exist){
                        String  name=resultSet.getString("name");
                        String  password=resultSet.getString("password");
                        user.setName(name);
                        user.setPassword(password);
                    }
                }catch(Exception e ){
                    e.printStackTrace();
                }
            }

            @Override
            public void executeGeneratedKeys(ResultSet resultSet) {
            }
        },username,password);
        return user;
    }


}
