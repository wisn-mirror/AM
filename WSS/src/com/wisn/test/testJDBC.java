package com.wisn.test;

import com.wisn.dbm.DbExecute;
import com.wisn.dbm.ResultSetCallBack;

import java.sql.ResultSet;
import java.sql.SQLException;
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
			 db.executeQuery("select * from test ",new  ResultSetCallBack() {

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

				@Override
				public void executeRowCount(int id) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void executeGeneratedKeys(ResultSet resultSet) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			 db.executeInsert("insert into test(content) values('hdhdh') ",new  ResultSetCallBack() {

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

				@Override
				public void executeRowCount(int id) {
					// TODO Auto-generated method stub
					System.out.println( id);
				}

				@Override
				public void executeGeneratedKeys(ResultSet resultSet) {
					// TODO Auto-generated method stub
					try {
						while(resultSet.next()){
							System.out.println(resultSet.getString(1));
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
