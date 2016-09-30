package com.wisn.service;

import com.wisn.bean.Admin;
import com.wisn.bean.DeviceInformation;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午11:11:02
 *
 */
public interface AuthService {
	public Admin  DeviceLogin(String username,String password);
}
