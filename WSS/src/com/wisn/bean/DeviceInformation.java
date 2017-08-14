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
	private  String registerTime;
	private String device_imei;
	private String device_imsi;
	private String device_name;
	private String device_macaddress;
	private String device_osname;
	private String device_osversion;

	public DeviceInformation() {
		super();
	}

	public DeviceInformation(long id, String userName, String passWord, String phone, String email, String registerTime, String device_imei, String device_imsi, String device_name, String device_macaddress, String device_osname, String device_osversion) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.registerTime = registerTime;
		this.device_imei = device_imei;
		this.device_imsi = device_imsi;
		this.device_name = device_name;
		this.device_macaddress = device_macaddress;
		this.device_osname = device_osname;
		this.device_osversion = device_osversion;
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

	public String getDevice_imsi() {
		return device_imsi;
	}

	public void setDevice_imsi(String device_imsi) {
		this.device_imsi = device_imsi;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getDevice_macaddress() {
		return device_macaddress;
	}

	public void setDevice_macaddress(String device_macaddress) {
		this.device_macaddress = device_macaddress;
	}

	public String getDevice_osname() {
		return device_osname;
	}

	public void setDevice_osname(String device_osname) {
		this.device_osname = device_osname;
	}

	public String getDevice_osversion() {
		return device_osversion;
	}

	public void setDevice_osversion(String device_osversion) {
		this.device_osversion = device_osversion;
	}
}
