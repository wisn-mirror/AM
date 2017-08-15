package com.wisn.serviceimpl;

import com.wisn.bean.DeviceInformation;
import com.wisn.dao.UserDao;
import com.wisn.service.DeviceUserInfoService;

public class DeviceInfoServiceImpl  implements DeviceUserInfoService {

	@Override
	public DeviceInformation checkDeviceInformation(
			String userName,String  password) {
		UserDao userDao=new UserDao();
		return userDao.getUser(userName,password);
	}

	@Override
	public DeviceInformation addDeviceInformation(
			DeviceInformation deviceInformation) {
		//Todo 检查是否存在 不存在再插入
		UserDao userDao=new UserDao();
		DeviceInformation user = userDao.getUser(deviceInformation.getUserName(), null);
		if(user.getId()!=0){
			return null;
		}
		return userDao.addUser(deviceInformation);

	}

	 
 

	 

}
