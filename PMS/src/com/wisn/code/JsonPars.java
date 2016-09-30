package com.wisn.code;

import net.sf.json.JSONObject;

import com.wisn.bean.DeviceInformation;
import com.wisn.core.OperationMessage;

public class JsonPars {
	/**
	 * @param <T>
	 * @param message  {"code":    ,"content":{} }
	 * @return
	 */
	public static <T> T  FromJson(String message,Class<T>  clazz){
		JSONObject fromObject = new  JSONObject().fromObject(message);
		JSONObject jsonObject = fromObject.getJSONObject(Type.content);
		T bean = (T) fromObject.toBean(jsonObject,clazz);
		return bean;
	}
	/**
	 * client  receive  str
	 * @param operation
	 * @param code
	 * @return
	 */
	public static String toJson(Object  operation,Object  reason,int  code){
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
			e.printStackTrace();
			return "{"+Type.code+":0,"+Type.content+":{}, "+Type.reason+":{}}";
		}
	}
	//test
	public static void main(String[] args) {
		String json = toJson(new  OperationMessage(22, 55, System.currentTimeMillis(), System.currentTimeMillis(), "ahhah"),null, 3);
		System.out.println(json);
		System.out.println(FromJson(json,OperationMessage.class).toString());
		String json1 = toJson(new  DeviceInformation("ererwq","ererwq","ererwq","ererwq","ererwq","ererwq"
				,"ererwq","ererwq","ererwq","ererwq","ererwq",77
				,"ererwq","ererwq"),null, 3);
		System.out.println(json1);
		System.out.println(FromJson(json1,DeviceInformation.class).toString());
	}
}
