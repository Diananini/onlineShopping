package com.eshore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.eshore.pojo.CommonUsers;

public class CommonUserDaoImpl implements CommonUserDao{
	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null; // 数据库操作对象
	ResultSet rs = null;

	// 通过构造方法取得数据库连接
	public CommonUserDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	//添加用户
	public int addUser(CommonUsers commonUser) throws Exception{
		String sql = "insert into CommonUsers(ip,uright) values(?,?)";
		int result = 0;
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, commonUser.getIp());//设定用户ip
		pstmt.setInt(2, commonUser.getUright());//设定用户权限
		
		result = pstmt.executeUpdate();//执行数据库操作
		pstmt.close();
		return result;
	}
	//根据用户Ip查询用户
	public CommonUsers queryByIp(String ip) throws Exception{
		String sql = "select uid,ip,uright from CommonUsers where ip=?";
		CommonUsers commonUser = new CommonUsers();
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, ip);
		rs = pstmt.executeQuery();//执行数据库操作
		if (rs.next()) {
			commonUser.setUid(rs.getInt(1));//设定用户id
			commonUser.setIp(ip);//设定用户ip
			commonUser.setUright(rs.getInt(3));//设定用户权限
		}
		rs.close();//关闭ResultSet对象
		pstmt.close();//关闭PreparedStatement对象
		return commonUser;
	}
	
	public CommonUsers latestAdded() throws Exception{
		String sql = "select max(uid) from CommonUsers";
		CommonUsers commonUser = new CommonUsers();
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		rs = pstmt.executeQuery();//执行数据库操作
		if (rs.next()) {
			commonUser.setUid(rs.getInt(1));//设定用户id
		}
		rs.close();//关闭ResultSet对象
		pstmt.close();//关闭PreparedStatement对象
		return commonUser;
	}
	
	//根据用户Ip修改用户权限
	public int updateByIp(String ip) throws Exception{
		String sql="update CommonUsers set uright=1 where ip=?";
		int result = 0;
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, ip);//设定用户ip
		
		result = pstmt.executeUpdate();//执行数据库操作
		pstmt.close();
		return result;
	}

}
