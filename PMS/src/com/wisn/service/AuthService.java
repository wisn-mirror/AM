package com.wisn.service;

import com.wisn.bean.Admin;
import com.wisn.bean.DeviceInformation;

public interface AuthService {
	public Admin  DeviceLogin(String username,String password);
}
