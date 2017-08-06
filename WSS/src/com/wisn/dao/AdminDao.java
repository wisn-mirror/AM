/**
 * 
 */
package com.wisn.dao;

import java.sql.ResultSet;

import com.wisn.bean.Admin;
import com.wisn.dbm.DbExecute;
import com.wisn.dbm.ResultSetCallBack;

/**
 * @author Wisn
 * 2016年10月15日   下午3:57:03
 * 
 */
public class  AdminDao {

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public Admin login(String username, String password) {
		DbExecute  db=new DbExecute();
		final Admin  admin=new  Admin();
		db.executePrepareQuery("select * from admin where  name=?  and password=? ", new  ResultSetCallBack() {
			
			@Override
			public void executeRowCount(int id) {
			}
			
			@Override
			public void executeResult(ResultSet resultSet) {
				try{
					boolean exist = resultSet.next();
					if(exist){
						String  name=resultSet.getString("name");
						String  password=resultSet.getString("password");
						System.out.println();
						admin.setName(name);
						admin.setPassword(password);
					}
				}catch(Exception e ){
					e.printStackTrace();
				}
			}
			
			@Override
			public void executeGeneratedKeys(ResultSet resultSet) {
			}
		},username,password);
		return admin;
	}
	 
	
}
