package com.wisn.pic.jdbcsql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * gson转化工具
 * @author Wisn
 *
 */
public class GoonTool {
	static Gson  gson=new  GsonBuilder().create();
	private GoonTool(){}
	public  static Gson  getInstance(){
		return gson;
	}

}
