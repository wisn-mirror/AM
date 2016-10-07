package com.wisn.dbm;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wisn.core.Config;
 
public class PooledDBA  implements DBA{
	private ComboPooledDataSource cpds = null;
	private static String DBClassName = null;
	private static String DBName = null;
	private static String DBUrl = null;
	private static String DBUser = null;
	private static String DBPassword = null;
	
	static {
		try {
			DBClassName = Config.DBClassName;
			DBName = Config.DBName;
			DBUrl = Config.DBUrl;
			DBUser = Config.DBUser;
			DBPassword = Config.DBPassword;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected PooledDBA() {
		cpds = new ComboPooledDataSource("online");
		try {
			cpds.setDriverClass(DBClassName);
		} catch (PropertyVetoException e) {

		}
		cpds.setJdbcUrl(DBUrl + DBName);
		cpds.setUser(DBUser);
		cpds.setPassword(DBPassword);
	}

	

	public synchronized Connection getConnection() throws SQLException,
			ClassNotFoundException, InterruptedException {
		return cpds.getConnection();
	}

	public synchronized void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {

		}
	}

	public synchronized void close(Statement stat) {
		try {
			if (stat != null) {
				stat.close();
				stat = null;
			}
		} catch (SQLException e) {

		}
	}
	public synchronized void close(ResultSet rest) {
		try {
			if (rest != null) {
				rest.close();
				rest = null;
			}
		} catch (SQLException e) {

		}
	}
}