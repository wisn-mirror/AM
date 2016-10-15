package com.wisn.dbm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wisn.utils.LogUtils;

public class DbExecute {
	private static final int executeInsertState = 1;
	private static final int executeQueryState = 2;
	private static final int executeBatchState = 3;

	public void executeBatch(String sql, String[] data) {
		PooledDBA pooledDBA = null;
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			pooledDBA = PooledDBA.getInstance();
			connection = pooledDBA.getConnection();
			prepareStatement = connection
					.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
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
		} finally {
			pooledDBA.close(null, prepareStatement, connection);
		}
	}

	/**
	 * 
	 * @param sqls
	 */
	public void executeBatch(String[] sqls) {
		execute(executeBatchState, sqls, null, null);
	}

	/**
	 * 
	 * @param sql
	 * @param resultSetCallBack
	 */
	public void executeQuery(String sql, ResultSetCallBack resultSetCallBack) {
		execute(executeQueryState, null, sql, resultSetCallBack);
	}

	/**
	 * 
	 * @param sql
	 * @param resultSetCallBack
	 */
	public void executePrepareQuery(String sql,
			ResultSetCallBack resultSetCallBack, String... parameters) {
		PooledDBA pooledDBA = null;
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet executeQuery = null;
		try {
			pooledDBA = PooledDBA.getInstance();
			connection = pooledDBA.getConnection();
			prepareStatement = connection
					.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			for (int i = 0; i < parameters.length; i++) {
				prepareStatement.setString((i+1), parameters[i]);
			}
			executeQuery = prepareStatement.executeQuery();
			if (resultSetCallBack != null) {
				resultSetCallBack.executeResult(executeQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.e(e.toString());
		} finally {
			pooledDBA.close(executeQuery, prepareStatement, connection);
		}
	}

	/**
	 * 
	 * @param sql
	 * @param resultSetCallBack
	 */
	public void executeInsert(String sql, ResultSetCallBack resultSetCallBack) {
		execute(executeInsertState, null, sql, resultSetCallBack);
	}

	private void execute(int type, String[] sqls, String sql,
			ResultSetCallBack resultSetCallBack) {
		PooledDBA pooledDBA = null;
		Connection connection = null;
		Statement prepareStatement = null;
		ResultSet executeQuery = null;
		try {
			pooledDBA = PooledDBA.getInstance();
			connection = pooledDBA.getConnection();
			prepareStatement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			switch (type) {
			case executeInsertState:
				int executeUpdate = prepareStatement.executeUpdate(sql);
				if (resultSetCallBack != null) {
					resultSetCallBack.executeRowCount(executeUpdate);
					resultSetCallBack.executeGeneratedKeys(prepareStatement
							.getGeneratedKeys());
				}
				break;
			case executeQueryState:
				executeQuery = prepareStatement.executeQuery(sql);
				if (resultSetCallBack != null) {
					resultSetCallBack.executeResult(executeQuery);
				}
				break;
			case executeBatchState:
				for (int i = 0; i < sqls.length; i++) {
					prepareStatement.addBatch(sqls[i]);
				}
				prepareStatement.executeBatch();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.e(e.toString());
		} finally {
			pooledDBA.close(executeQuery, prepareStatement, connection);
		}
	}

}
