package com.wisn.service;

import com.wisn.bean.DeviceInformation;

 
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午11:11:40
 *
 */
public interface DeviceInfoService {
	
	DeviceInformation  checkDeviceInformation(DeviceInformation  loginInfoParameter);
	
	DeviceInformation addDeviceInformation(DeviceInformation  loginInfoParameter);

}
