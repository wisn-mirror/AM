package com.wisn.service;

import com.wisn.bean.Admin;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午11:11:02
 *
 */
public interface AuthService {
	Admin  DeviceLogin(String username, String password);
	Admin  UserLogin(String username, String password);
	Admin  UserRegister(String username, String password);
}
