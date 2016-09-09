package com.eshore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.eshore.pojo.Correspond;

public class CorrespondDaoImpl implements CorrespondDao{
	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null; // 数据库操作对象
	Vector<Correspond> corrVector=new Vector<Correspond>();
	ResultSet rs = null;

	// 通过构造方法取得数据库连接
	public CorrespondDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	public int addCorrespond(Correspond corr)throws Exception{
		String sql0="select user_addr from Correspond where user_addr=?";
		pstmt = this.conn.prepareStatement(sql0);//获取PreparedStatement对象
		pstmt.setString(1, corr.getAddr());
		rs = pstmt.executeQuery();//执行数据库操作
		if (rs.next()) {
			return 1;
		}
		
		String sql="insert into Correspond values(?,?)";
		int result = 0;
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, corr.getAddr());//设定用户地址
		pstmt.setInt(2, corr.getUid());//设定用户用户名
		result = pstmt.executeUpdate();//执行数据库操作
		pstmt.close();
		return result;
	}
	public Vector<Correspond> queryByUid(int uid)throws Exception{
		String sql="select user_addr,uid from Correspond where uid=?";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) {
			Correspond corr = new Correspond();
			corr.setAddr(rs.getString(1));//设定购物车id
			corr.setUid(rs.getInt(2));//设定购物车中商品的ID
			
			corrVector.add(corr);
		}
		rs.close();//关闭ResultSet对象
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return corrVector;
	}

}
