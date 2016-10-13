package com.wisn.dbm;

import java.sql.ResultSet;

public interface ResultSetCallBack {
	/**
	 * 获取执行的结果集
	 * @param resultSet
	 */
	 void executeResult(ResultSet  resultSet);
	 /**
	  * 获取更新了多少行
	  * @param id
	  */
	 void executeRowCount (int  id);
	 /**
	  * 获取主键
	  * @param resultSet
	  */
	 void executeGeneratedKeys(ResultSet  resultSet);

}
