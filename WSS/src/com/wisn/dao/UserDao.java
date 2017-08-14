package com.wisn.dao;

import com.wisn.bean.DeviceInformation;
import com.wisn.bean.User;
import com.wisn.dbm.DbExecute;
import com.wisn.dbm.ResultSetCallBack;
import com.wisn.utils.LogUtils;

import java.sql.ResultSet;

public class UserDao {
    public DeviceInformation addUser(DeviceInformation deviceInformation) {
        DbExecute db = new DbExecute();
        db.executeInsertOrUpdate("INSERT  into user_profile(username,password,phone,email,icon,company,registertime,device_imei) VALUE ('"
                + deviceInformation.getUserName() + "','"
                + deviceInformation.getPassWord() + "','"
                + deviceInformation.getPhone() + "','"
                + deviceInformation.getEmail() + "','"
                + deviceInformation.getIcon() + "','"
                + deviceInformation.getCompany() + "','"
                + deviceInformation.getRegisterTime() + "','"
                + deviceInformation.getDevice_imei()
                + "')", new ResultSetCallBack() {

            @Override
            public void executeRowCount(int id) {
            }

            @Override
            public void executeResult(ResultSet resultSet) {
                try {
                    boolean exist = resultSet.next();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void executeGeneratedKeys(ResultSet resultSet) {
                try {
                    while(resultSet.next()){
                        deviceInformation.setId(resultSet.getLong(1));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        LogUtils.d(deviceInformation.toString());
        return deviceInformation;
    }

    public User getUser(String username, String password) {
        DbExecute db = new DbExecute();
        final User user = new User();

        return user;
    }

}
