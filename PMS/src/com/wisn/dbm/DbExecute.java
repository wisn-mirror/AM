package com.wisn.dbm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wisn.utils.LogUtils;

public class DbExecute {

	public void executeBatch(String sql, String[] data) {
		PooledDBA pooledDBA=null;
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		try {
			  pooledDBA = PooledDBA.getInstance();
			 connection = pooledDBA.getConnection();
			 prepareStatement = connection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			for (int i = 0; i < data.length; i++) {
				prepareStatement.setString((i + 1), data[i]);
				prepareStatement.addBatch();
				if (i % 500 == 0) {
					// 为了防止内存溢出每500条执行一次
					prepareStatement.executeBatch();
					// 清除内存中执行过的语句
					prepareStatement.clearBatch();
				}
			}
			prepareStatement.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.e(e.toString());
		}finally{
			pooledDBA.close(null, prepareStatement, connection);
		}
	}
	/**
	 * 
	 * @param sql
	 */
	public void executeBatch(String[] sql) {
		PooledDBA pooledDBA=null;
		Connection connection=null;
		Statement prepareStatement=null;
		try {
			  pooledDBA = PooledDBA.getInstance();
			 connection = pooledDBA.getConnection();
			 prepareStatement = connection.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			for (int i = 0; i < sql.length; i++) {
				prepareStatement.addBatch(sql[i]);
			}
			prepareStatement.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.e(e.toString());
		}finally{
			pooledDBA.close(null, prepareStatement, connection);
		}
	}
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public void find(String  sql,ResultSetCallBack  resultSetCallBack) {
		PooledDBA pooledDBA=null;
		Connection connection=null;
		Statement prepareStatement=null;
		ResultSet executeQuery=null;
		try {
			  pooledDBA = PooledDBA.getInstance();
			 connection = pooledDBA.getConnection();
			 prepareStatement = connection.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			 executeQuery = prepareStatement.executeQuery(sql);
			 if(resultSetCallBack!=null){
				 resultSetCallBack.executeResult(executeQuery);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.e(e.toString());
		}finally{
			pooledDBA.close(executeQuery, prepareStatement, connection);
		}
		 
	}

}
