package com.wisn.serviceimpl;

import com.wisn.bean.Admin;
import com.wisn.service.AuthService;

public class AuthServiceImpl implements  AuthService{

	@Override
	public Admin DeviceLogin(String username, String password) {
		//TODO 完善dao层的逻辑

		return new Admin(username.hashCode(),username,password);
	}

	@Override
	public Admin UserLogin(String username, String password) {
		//TODO 完善dao层的逻辑

		return new Admin(username.hashCode(),username,password);
	}

	@Override
	public Admin UserRegister(String username, String password) {
		//TODO 完善dao层的逻辑

		return new Admin(username.hashCode(),username,password);
	}

}
