package com.wisn.service;

import com.wisn.bean.DeviceInformation;

 
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午11:11:40
 *
 */
public interface DeviceUserInfoService {
	
	DeviceInformation  checkDeviceInformation(String userName,String  password);
	
	DeviceInformation addDeviceInformation(DeviceInformation deviceInformation);

}
