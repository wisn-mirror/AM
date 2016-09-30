package com.wisn.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import com.wisn.utils.LogUtils;

/**
 * 
 * @author Wisn 2016年9月30日 上午9:23:21
 *
 */
public class Config {
	public static int initMaxHandleThread = 6;
	public static int initHalfHandleThread = 3;
	public static int initEveryThreadMessage = 20;
	
	public void intConfig(ServletContext   context) {
		/*
		 * ResourceBundle rb=ResourceBundle.getBundle("com.wisn.jdbc.jdbc");
		 * initMaxHandleThread=(Integer) rb.getObject("initMaxHandleThread");
		 */
		try {
			Properties pro = new Properties();
			try {
				//context.getRealPath("/META-INF/upload/temp");
			//	pro.load(new FileInputStream("config/system.properties"));
				pro.load(new FileInputStream(context.getRealPath("/WEB-INF/config/system.properties")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				LogUtils.e("FileNotFoundException:"+e.toString());
			} catch (IOException e) {
				e.printStackTrace();
				LogUtils.e("IOException:"+e.toString());
			}
			initMaxHandleThread = Integer.parseInt(pro
					.getProperty("initMaxHandleThread"));
			initHalfHandleThread = Integer.parseInt(pro
					.getProperty("initHalfHandleThread"));
			initEveryThreadMessage = Integer.parseInt(pro
					.getProperty("initEveryThreadMessage"));
		} catch (NumberFormatException e) {
			initMaxHandleThread = 6;
			initHalfHandleThread = 3;
			initEveryThreadMessage = 20;
			e.printStackTrace();
			LogUtils.e("intConfig:"+e.toString());
		}
	}
	public static void main(String[] args) {
	   //new  Config().intConfig();
	}
}
