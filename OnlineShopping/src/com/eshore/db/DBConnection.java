package com.eshore.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=OnlineShopping";
	private static final String USER = "diana";
	private static final String PASSWORD = "lovediana";
	private Connection conn = null;

	public DBConnection() throws Exception { // 进行数据库连接
		try {
			Class.forName(Driver); // 用反射加载数据库驱动
			this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			throw e; // 抛出异常
		}
	}

	public Connection getConnection() {
		return this.conn; // 取得数据库的连接
	}

	public void close() throws Exception { // 关闭数据库
		if (this.conn != null) {  
			try {
				this.conn.close(); // 数据库关闭
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
