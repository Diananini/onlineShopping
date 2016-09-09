package com.eshore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.eshore.pojo.Addr;

public class AddrDaoImpl implements AddrDao{
	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null; // 数据库操作对象
	ResultSet rs = null;

	// 通过构造方法取得数据库连接
	public AddrDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	public int addAddr(Addr addr)throws Exception{
		String sql0="select user_addr from Addr where user_addr=?";
		pstmt = this.conn.prepareStatement(sql0);//获取PreparedStatement对象
		pstmt.setString(1, addr.getAddr());
		rs = pstmt.executeQuery();//执行数据库操作
		if (rs.next()) {
			return 1;
		}
		String sql="insert into Addr values(?)";
		int result = 0;
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, addr.getAddr());
		result = pstmt.executeUpdate();//执行数据库操作
		pstmt.close();
		return result;
	}

}
