/**
 * 
 */
package com.wisn.test;

import com.wisn.bean.Admin;
import com.wisn.dao.AdminDao;

/**
 * @author Wisn
 * 2016年10月9日   上午10:31:02
 * 
 */
public class Base {
	public  String  tag= getClass().getCanonicalName();
	public static void main(String[] args) {
		AdminDao  admin=new  AdminDao();
		Admin login = admin.login("11", "22");
		System.out.println(login.toString());
	}
}
