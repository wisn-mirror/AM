package com.wisn.service;

import com.wisn.bean.DeviceInformation;

 

public interface DeviceInfoService {
	
	DeviceInformation  checkDeviceInformation(DeviceInformation  loginInfoParameter);
	
	DeviceInformation addDeviceInformation(DeviceInformation  loginInfoParameter);

}
