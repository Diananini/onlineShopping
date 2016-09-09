package com.eshore.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.eshore.pojo.Users;

public class UserDaoImpl implements UserDao {

	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null; // 数据库操作对象
	ResultSet rs = null;

	// 通过构造方法取得数据库连接
	public UserDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	public int addUser(Users user) throws Exception{
		String sql = "insert into users values(?,?,?,?,?,getdate())";
		int result = 0;
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setInt(1, user.getUid());//设定用户用户名
		pstmt.setString(2, user.getUname());//设定用户用户名
		pstmt.setString(3, user.getPasswd());//设定用户密码
		pstmt.setString(4, user.getGender());//设定用户性别
		pstmt.setString(5, user.getPhone());//设定用户phone
		result = pstmt.executeUpdate();//执行数据库操作
		pstmt.close();
		return result;
	}

	public Users queryByPhone(String phone) throws Exception{
		String sql = "select uid,uname,passwd,gender,lastlogin from users where phone=?";
		Users user = new Users();
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, phone);
		rs = pstmt.executeQuery();//执行数据库操作
		if (rs.next()) {
			user.setUid(rs.getInt(1));//设定用户id
			user.setUname(rs.getString(2));//设定用户用户名
			user.setPasswd(rs.getString(3));//设定用户密码
			user.setGender(rs.getString(4));//设定用户性别
			user.setPhone(phone);//设定用户phone
			user.setLastLogin(rs.getDate(5));//设定用户登录时间
		}
		rs.close();//关闭ResultSet对象
		pstmt.close();//关闭PreparedStatement对象
		return user;
	}

	public Users queryByName(String uname) throws Exception{
		String sql = "select uid,passwd,gender,phone,lastlogin from users where uname=?";
		Users user = new Users();
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, uname);
		rs = pstmt.executeQuery();//执行数据库操作
		if (rs.next()) {
			user.setUid(rs.getInt(1));//设定用户id
			user.setPasswd(rs.getString(2));//设定用户密码
			user.setGender(rs.getString(3));//设定用户性别
			user.setUname(uname);//设定用户用户名
			user.setPhone(rs.getString(4));//设定用户phone
			user.setLastLogin(rs.getDate(5));//设定用户登录时间
		}
		rs.close();//关闭ResultSet对象
		pstmt.close();//关闭PreparedStatement对象
		return user;
	}

	public int deleteUser(int uid) throws Exception{//删除指定用户
		String sql = "delete from users where uid=?";
		int result = 0;
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setInt(1, uid);
		result = pstmt.executeUpdate();//执行数据库操作
		pstmt.close();//关闭PreparedStatement对象
		return result;
	}

	//更新指定用户信息
	public int editInf(int uid, String uname, String gender,String phone) throws Exception{
		System.out.println(uid+"---"+uname+"---"+gender+"---"+phone);
		String sql="update users set uname=?,gender=?,phone=? where uid=?";
		int result=0;
		pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, uname);
		pstmt.setString(2, gender);
		pstmt.setString(3, phone);
		pstmt.setInt(4, uid);
		result=pstmt.executeUpdate();//执行数据库操作
		pstmt.close();
		return result;
	}
	//修改用户密码
	public int editPasswd(int uid, String passwd) throws Exception{
		String sql="update users set passwd=? where uid=?";
		int result=0;
		pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, passwd);
		pstmt.setInt(2, uid);
		result=pstmt.executeUpdate();//执行数据库操作
		pstmt.close();
		return result;
	}
	
	//修改用户最后登录时间
	public int editLastlogin(int uid) throws Exception{
		String sql="update users set lastlogin=getdate() where uid=?";
		int result=0;
		pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setInt(1,uid);
		result=pstmt.executeUpdate();//执行数据库操作
		pstmt.close();
		return result;
	}
}
