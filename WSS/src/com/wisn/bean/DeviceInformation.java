package com.wisn.bean;

import java.io.Serializable;

/**
 * 
 * @author Wisn
 * 2016年9月30日   下午4:25:12
 *
 */
public class DeviceInformation implements Serializable{
	private 	long  id;
	private  String userName;
	private  String passWord;
	private  String phone;
	private  String email;
	private  String icon;
	private  String company;
	private  String registerTime;
	private String device_imei;

	public DeviceInformation() {
		super();
	}

	public DeviceInformation(String userName, String passWord, String device_imei) {
		this.userName = userName;
		this.passWord = passWord;
		this.device_imei = device_imei;
	}

	public DeviceInformation(long id, String userName, String passWord, String phone, String email, String icon, String company, String registerTime, String device_imei) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.icon = icon;
		this.company = company;
		this.registerTime = registerTime;
		this.device_imei = device_imei;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getDevice_imei() {
		return device_imei;
	}

	public void setDevice_imei(String device_imei) {
		this.device_imei = device_imei;
	}

	@Override
	public String toString() {
		return "DeviceInformation{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", passWord='" + passWord + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", icon='" + icon + '\'' +
				", company='" + company + '\'' +
				", registerTime='" + registerTime + '\'' +
				", device_imei='" + device_imei + '\'' +
				'}';
	}
}
