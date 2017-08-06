package com.wisn.utils;

import org.apache.log4j.*; 



public class LogUtils {
	public  static  boolean isDebug=true;
	private static Logger logger;
	public  static void  initConfig(){
//		logger = Logger.getLogger();
		   //如果指定logger名字，则是把日志，输出到pay-log 指定的日志文件中去
		logger = Logger.getLogger("aa");
	
	}
	public static  void d(String  content){
		if(isDebug){
			System.out.println(content);
			if(logger!=null){				
				logger.debug(content);
			}
		}
	}
	public static  void w(String  content){
		if(isDebug){
			System.out.println(content);
			//logger.warn(content);
			if(logger!=null){				
				logger.warn(content);
			}
		}
	}
	public static  void e(String  content){
		if(isDebug){
			System.err.println(content);
			if(logger!=null){				
				logger.error(content);
			}
		}
	}
	
/*	 //如果直接 className.class 日志输出到全局的 即rootLogger 指定的文件中
    Logger logger = Logger.getLogger(Test.class.getName());
   //如果指定logger名字，则是把日志，输出到pay-log 指定的日志文件中去
   Logger logger = Logger.getLogger(“pay-log”);
  MyLog4j.getSomething();
  System.out.println("================97987==============");
  logger.info("日志信息开始!");
  logger.info("日志信息结束!");
  try {
   Integer.parseInt("a");
  } catch (NumberFormatException e) {
   logger.error("解析数字出现异常",e);
   e.printStackTrace();
  }*/
}
