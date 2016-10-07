package com.wisn.dbm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DBA {
	Connection getConnection() throws SQLException,
	ClassNotFoundException, InterruptedException ;
	void close(ResultSet rest,Statement stat,Connection conn);
}
