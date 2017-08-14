package com.wisn.core;

import com.wisn.utils.LogUtils;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Wisn 2016年9月30日 上午9:23:21
 */
public class Config {
    public static int initMaxHandleThread = 6;
    public static int initHalfHandleThread = 3;
    public static int initEveryThreadMessage = 20;
    public static String DBClassName = "com.mysql.jdbc.Driver";
    public static String DBName = "am_sys";
    public static String DBUrl = "jdbc:mysql://localhost:3306/";
    public static String DBUser = "root";
    public static String DBPassword = "123456";

    public void intConfig(ServletContext context) {
        /*
		 * ResourceBundle rb=ResourceBundle.getBundle("com.wisn.jdbc.jdbc");
		 * initMaxHandleThread=(Integer) rb.getObject("initMaxHandleThread");
		 */
        try {
            Properties pro = new Properties();
            try {
                //context.getRealPath("/META-INF/upload/temp");
                //	pro.load(new FileInputStream("config/system.properties"));
                pro.load(new FileInputStream(context.getRealPath("/WEB-INF/config_user/system.properties")));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                LogUtils.e("FileNotFoundException:" + e.toString());
            } catch (IOException e) {
                e.printStackTrace();
                LogUtils.e("IOException:" + e.toString());
            }
            initMaxHandleThread = Integer.parseInt(pro
                    .getProperty("initMaxHandleThread"));
            initHalfHandleThread = Integer.parseInt(pro
                    .getProperty("initHalfHandleThread"));
            initEveryThreadMessage = Integer.parseInt(pro
                    .getProperty("initEveryThreadMessage"));
            DBClassName = pro.getProperty("DBClassName");
            DBName = pro.getProperty("DBName");
            DBUrl = pro.getProperty("DBUrl");
            DBUser = pro.getProperty("DBUser");
            DBPassword = pro.getProperty("DBPassword");
            printInfo();
            LogUtils.d("初始化配置成功");
        } catch (NumberFormatException e) {
            initMaxHandleThread = 6;
            initHalfHandleThread = 3;
            initEveryThreadMessage = 20;
            e.printStackTrace();
            LogUtils.e("intConfig:" + e.toString());
        }
    }

    private void printInfo() {
        LogUtils.d("initMaxHandleThread:" + initMaxHandleThread);
        LogUtils.d("initHalfHandleThread:" + initHalfHandleThread);
        LogUtils.d("initEveryThreadMessage:" + initEveryThreadMessage);
        LogUtils.d("DBClassName:" + DBClassName);
        LogUtils.d("DBName:" + DBName);
        LogUtils.d("DBUrl:" + DBUrl);
        LogUtils.d("DBUser:" + DBUser);
        LogUtils.d("DBPassword:" + DBPassword);
    }

}
