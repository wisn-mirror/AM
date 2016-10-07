package com.wisn.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wisn.dbm.DbExecute;
import com.wisn.dbm.PooledDBA;
import com.wisn.dbm.ResultSetCallBack;
/**
 * 测试连接池
 * @author Wisn_
 *
 */
public class testJDBC {
	public static void main(String[] args) {
		try {
			/*PooledDBA  a= 	PooledDBA.getInstance();
			System.out.println(System.currentTimeMillis());
			for(int i=0;i<55;i++){
				Connection connection = a.getConnection();
				 System.out.println(connection);
			}
			System.out.println(System.currentTimeMillis());*/
			DbExecute  db=new  DbExecute();
			 db.find("select * from test ",new  ResultSetCallBack() {
				
				@Override
				public void executeResult(ResultSet resultSet) {
					// TODO Auto-generated method stub
					try {
						while(resultSet.next()){
							System.out.println(resultSet.getString("content"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
