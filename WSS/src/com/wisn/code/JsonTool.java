package com.wisn.code;

import net.sf.json.JSONObject;

public class JsonTool {
	
	public  static JSONObject  JsonObject=null;
	public  static   JSONObject  getJsonObjectInstance(){
		if(JsonObject==null){
			synchronized (JsonTool.class) {
				if(JsonObject==null){
					JsonObject=new  JSONObject();
				}
			}
		}
		return JsonObject;
	}

}
