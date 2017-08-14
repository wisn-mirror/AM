package com.wisn.serviceimpl;

import com.wisn.bean.DeviceInformation;
import com.wisn.dao.UserDao;
import com.wisn.service.DeviceUserInfoService;

public class DeviceInfoServiceImpl  implements DeviceUserInfoService {

	@Override
	public DeviceInformation checkDeviceInformation(
			DeviceInformation deviceInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceInformation addDeviceInformation(
			DeviceInformation deviceInformation) {
		UserDao userDao=new UserDao();
		return userDao.addUser(deviceInformation);
	}

	 
 

	 

}
