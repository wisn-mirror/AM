package com.wisn.dao;

import com.wisn.bean.DeviceInformation;
import com.wisn.dbm.DbExecute;
import com.wisn.dbm.ResultSetCallBack;
import com.wisn.utils.LogUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    DbExecute db;

    public UserDao() {
        db = new DbExecute();
    }

    public DeviceInformation addUser(DeviceInformation deviceInformation) {

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
                    while (resultSet.next()) {
                        deviceInformation.setId(resultSet.getLong(1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        DeviceInformation info = getUser(deviceInformation.getUserName(), deviceInformation.getPassWord());
        LogUtils.d(info.toString());
        LogUtils.d(deviceInformation.toString());
        return deviceInformation;
    }

    public DeviceInformation getUser(String username, String password) {
        DeviceInformation deviceInformation = new DeviceInformation();
        String sql = "select id,username,password,phone,email,icon,company,registertime,device_imei from user_profile where username='"
                + username;
        if (password == null) {
            sql = sql + "'";
        } else {
            sql = sql + "' and password='"
                    + password + "'";
        }
        LogUtils.d(sql);
        db.executeQuery(sql,
                new ResultSetCallBack() {
                    @Override
                    public void executeResult(ResultSet resultSet) {
                        try {
                            while (resultSet.next()) {
                                deviceInformation.setId(resultSet.getInt("id"));
                                deviceInformation.setUserName(resultSet.getString("username"));
                                deviceInformation.setPassWord(resultSet.getString("password"));
                                deviceInformation.setPhone(resultSet.getString("phone"));
                                deviceInformation.setIcon(resultSet.getString("icon"));
                                deviceInformation.setCompany(resultSet.getString("company"));
                                deviceInformation.setRegisterTime(resultSet.getString("registertime"));
                                deviceInformation.setDevice_imei(resultSet.getString("device_imei"));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void executeRowCount(int id) {

                    }

                    @Override
                    public void executeGeneratedKeys(ResultSet resultSet) {

                    }
                }
        );
        return deviceInformation;
    }

}
