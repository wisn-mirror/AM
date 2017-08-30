package com.wisn.pic.jdbcsql;

import java.sql.*;
import java.util.Properties;


public class JDUtil {
	private static String url="";
	private static String pwd="";
	private static String name="";
	private static String driver="";
	static{
		
		Properties  pro=new  Properties();
		try {
			//pro.load(new FileInputStream("src/com/wisn/jdbc/jdbc.properties"));
			//pro.load(JDUtil.class.getResourceAsStream("com/wisn/jdbcsql/jdbc.properties"));
			pro.load(JDUtil.class.getClassLoader().getResourceAsStream("com/wisn/jdbcsql/jdbc.properties"));
			url=pro.getProperty("url");
			pwd=pro.getProperty("password");
			name=pro.getProperty("loginname");
			driver=pro.getProperty("classDriver");
			System.out.println("===="+name);
		} catch (Exception e1) {
			e1.printStackTrace();
		}  
	//	ResourceBundle  rb=ResourceBundle.getBundle("com.wisn.jdbc.jdbc");
//		url=rb.getString("url");
//		pwd=rb.getString("password");
//		name=rb.getString("loginname");
//		driver=rb.getString("classDriver");
		try {
			Class.forName(driver);
			System.out.println("ok");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private JDUtil(){}
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public  static  Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,name,pwd);
		
	}
	/**
	 * 释放资源
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void release(Connection  conn,Statement  stmt,ResultSet  rs){
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
				stmt=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
