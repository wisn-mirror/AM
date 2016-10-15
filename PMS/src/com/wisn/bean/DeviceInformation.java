package com.wisn.bean;
/**
 * 
 * @author Wisn
 * 2016年9月30日   下午4:25:12
 *
 */
public class DeviceInformation {
	private 	long  id;
	private  String userName;
	private  String passWord;
	private String device_imei;
	private String device_imsi;
	private String device_networkoperatorname;
	private String device_name;
	private String device_model; 
	private String device_macaddress;
	private String device_osname;
	private String device_manufacturer;
	private String device_osversion;
	private int device_isrooted;
	
	public DeviceInformation() {
		super();
	}
	
	public DeviceInformation(long id, String device_imei, String device_imsi,
			String device_networkoperatorname, String device_name,
			String device_model, String device_macaddress,
			String device_osname, String device_manufacturer,
			String device_osversion, int device_isrooted) {
		super();
		this.id = id;
		this.device_imei = device_imei;
		this.device_imsi = device_imsi;
		this.device_networkoperatorname = device_networkoperatorname;
		this.device_name = device_name;
		this.device_model = device_model;
		this.device_macaddress = device_macaddress;
		this.device_osname = device_osname;
		this.device_manufacturer = device_manufacturer;
		this.device_osversion = device_osversion;
		this.device_isrooted = device_isrooted;
	}
	
	public DeviceInformation(long id, String userName, String passWord,
			String device_imei, String device_imsi,
			String device_networkoperatorname, String device_name,
			String device_model, String device_macaddress,
			String device_osname, String device_manufacturer,
			String device_osversion, int device_isrooted) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.device_imei = device_imei;
		this.device_imsi = device_imsi;
		this.device_networkoperatorname = device_networkoperatorname;
		this.device_name = device_name;
		this.device_model = device_model;
		this.device_macaddress = device_macaddress;
		this.device_osname = device_osname;
		this.device_manufacturer = device_manufacturer;
		this.device_osversion = device_osversion;
		this.device_isrooted = device_isrooted;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getDevice_networkoperatorname() {
		return device_networkoperatorname;
	}
	public void setDevice_networkoperatorname(String device_networkoperatorname) {
		this.device_networkoperatorname = device_networkoperatorname;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getDevice_model() {
		return device_model;
	}
	public void setDevice_model(String device_model) {
		this.device_model = device_model;
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
	public String getDevice_manufacturer() {
		return device_manufacturer;
	}
	public void setDevice_manufacturer(String device_manufacturer) {
		this.device_manufacturer = device_manufacturer;
	}
	public String getDevice_osversion() {
		return device_osversion;
	}
	public void setDevice_osversion(String device_osversion) {
		this.device_osversion = device_osversion;
	}
	public int getDevice_isrooted() {
		return device_isrooted;
	}
	public void setDevice_isrooted(int device_isrooted) {
		this.device_isrooted = device_isrooted;
	}
	

}
