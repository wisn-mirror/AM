/**
 * 
 */
package com.wisn.test;

import com.wisn.bean.DeviceInformation;

import java.util.List;

/**
 * @author Wisn
 * 2016年10月9日   上午10:31:02
 * 
 */
public class Base {
	public  String  tag= getClass().getCanonicalName();
	public static void main(String[] args) {
		/*AdminDao  admin=new  AdminDao();
		Admin login = admin.login("11", "22");
		System.out.println(login.toString());
		(String device_id,
                    String running_state,
                    String light_state,
                    String container_temperature,
                    boolean door_state,
                    boolean oneyuan_state,
                    boolean fiftyfen_state, boolean normalsale_state, double latitude, double longitude)
                    SvmState(String device_id, String faultCode,
			List<Integer> temperature, String lightState, boolean isDoorOpen,
			boolean isLeakChange_5jiao, boolean isLeakChange_1yuan,
			boolean isSaleStop) 
		*
		*/
		
		/*List<Integer> data=new  ArrayList<Integer>();
		for(int i=0;i<10;i++){
			data.add(i);
		}
		 * SvmState  svm=new  SvmState("33333333","0x00033异常信息",data,"灯光正常",true,true,true,true,12.33,13.22);
		JSONObject JsonObject=new  JSONObject();
		JsonObject.put("svmstate", svm);*/
//		System.out.println(getTemperature(data));
	//	List<PropertiesBean>  properties=new  ArrayList<PropertiesBean>();
	  /*  String  temp=" {\"vmcstate\":[{\"name\":\"faultCode\",\"value\":\"\"},{\"name\":\"lightState\",\"value\":\"灯光正常开启\"},{\"name\":\"isDoorOpen\",\"value\":\"false\"},{\"name\":\"isLeakChange_5jiao\",\"value\":\"false\"},{\"name\":\"isLeakChange_1yuan\",\"value\":\"false\"},{\"name\":\"isSaleStop\",\"value\":\"true\"},{\"name\":\"latitude\",\"value\":\"31.18902\"},{\"name\":\"longitude\",\"value\":\"121.394643\"},{\"name\":\"temperature\",\"value\":\"5;5;5;5;5;5;5;5;5;5;5;5;12;12;12;12;12;12;12;12;12;12;12;12;12;12;12;12;12\"}]}";  
		JSONObject fromObject = new  JSONObject().fromObject(temp);
		JSONArray jsonArray = fromObject.getJSONArray("vmcstate");
		for(int i=0;i<jsonArray.size();i++){
			  JSONObject jsonObject = jsonArray.getJSONObject(i);
			  System.out.println(jsonObject.getString("name"));
			  System.out.println(jsonObject.getString("value"));
		}*/
		
//		String temp="{\"faultCode\":\"\",\"temperature\":["+i+","+i+","+i+","+i+","+i+","+i+"],\"isLeakChange_5jiao\":"+istrue+",\"isSaleStop\":"+istrue+",\"isLeakChange_1yuan\":"+istrue+",\"isDoorOpen\":"+istrue+",\"isVmcDisconnect\":"+istrue+",\"isCoinMError\":"+istrue+",\"isPaperMError\":"+istrue+",\"isMasterError\":"+istrue+",\"isVmcError\":"+istrue+"}";
//		int i=2;
//		boolean istrue=((i%2)==0);

        DeviceInformation deviceInformation=new DeviceInformation("wisn","nihao","132343241322");
//        System.out.println(  JsonPars.toJson(deviceInformation,null,200));
    }
	 
	  /**
     * 获取温度
     *
     * @return
     */
    public static String getTemperature(List<Integer> temperature) {
        StringBuilder tempStr = new StringBuilder();
        try {
            for (int i = 0; i < temperature.size(); i++) {
                if ((i + 1) == temperature.size()) {
                    tempStr.append(temperature.get(i));
                } else {
                    tempStr.append(temperature.get(i)+ ";");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempStr.toString();
    }
}
