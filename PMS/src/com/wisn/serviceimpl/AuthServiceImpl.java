package com.wisn.serviceimpl;

import com.wisn.bean.Admin;
import com.wisn.bean.DeviceInformation;
import com.wisn.dao.AdminDao;
import com.wisn.service.AuthService;

public class AuthServiceImpl implements  AuthService{

	@Override
	public Admin DeviceLogin(String username, String password) {
		return new  AdminDao().login(username,password);
	}

}
