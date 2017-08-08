package com.wisn.code;

import com.wisn.core.Message;
import com.wisn.utils.LogUtils;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class JsonPars {
	/**
	 * @param <T>
	 * @param message  {"code":    ,"content":{} }
	 * @return
	 */
	public static <T> T  fromJson(String message,Class<T>  clazz)throws Exception{
		T bean=null;
		try {
			JSONObject fromObject = new  JSONObject().fromObject(message);
			JSONObject jsonObject = fromObject.getJSONObject(Type.content);
			bean = (T) fromObject.toBean(jsonObject,clazz);
		} catch (JSONException e) {
			e.printStackTrace();
			LogUtils.e("fromJson:"+e.toString());
			throw e;
		}
		return bean;
	}
	/**
	 * client  receive  str
	 * @param operation
	 * @param code
	 * @return
	 */
	public static String toJson(Object  operation,Object  reason,int  code) {
		try {
			JSONObject JsonObject=new  JSONObject();
			JsonObject.put(Type.code, code);
			if(reason!=null){
				JsonObject.put(Type.reason, reason);				
			}else{
				JsonObject.put(Type.reason, "{}");				
			}
			if(operation==null){
				JsonObject.put(Type.content,"{}");	
			}else{
				JsonObject.put(Type.content, operation);				
			}
			return JsonObject.toString();
		} catch (Exception e) {
			LogUtils.e("toJson:"+e.toString());
			return "{"+Type.code+":0,"+Type.content+":{}, "+Type.reason+":{}}";
		}
	}
	//test
	public static void main(String[] args) {
		String json = toJson(new Message(22, 55, System.currentTimeMillis(), System.currentTimeMillis(), "ahhah"),null, 3);
		System.out.println(json);
//		System.out.println(fromJson(json,Message.class).toString());
	/*	String json1 = toJson(new  DeviceInformation("ererwq","ererwq","ererwq","ererwq","ererwq","ererwq"
				,"ererwq","ererwq","ererwq","ererwq","ererwq",77
				,"ererwq","ererwq"),null, 3);
		System.out.println(json1);
		System.out.println(fromJson(json1,DeviceInformation.class).toString());*/
	}
}
