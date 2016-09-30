package com.wisn.utils;

public class LogUtils {
	public  static  boolean isDebug=true;
	
	public static  void d(String  content){
		if(isDebug){
			System.out.println(content);
		}
	}
	public static  void w(String  content){
		if(isDebug){
			System.out.println(content);
		}
	}
	public static  void e(String  content){
		if(isDebug){
			System.err.println(content);
		}
	}
}
