package com.eshore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.eshore.pojo.Manager;

public class ManagerDaoImpl implements ManagerDao{
	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null; // 数据库操作对象
	ResultSet rs = null;

	// 通过构造方法取得数据库连接
	public ManagerDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	//修改用户密码
	public int editPasswd(int manager_id,String passwd) throws Exception{
		String sql="update Manager set manager_pw=? where manager_id=?";
		int result=0;
		pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, passwd);
		pstmt.setInt(2, manager_id);
		result=pstmt.executeUpdate();//执行数据库操作
		pstmt.close();
		return result;
	}
	//根据用户名查询用户
	public Manager queryByName(String manager_name) throws Exception{
		String sql = "select manager_id,manager_pw from Manager where manager_name=?";
		Manager manager = new Manager();
		pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setString(1, manager_name);
		rs = pstmt.executeQuery();//执行数据库操作
		if (rs.next()) {
			manager.setManagerId(rs.getInt(1));//设定管理员id
			manager.setManagerPw(rs.getString(2));//设定用户密码
			manager.setManagerName(manager_name);//设定用户用户名
		}
		rs.close();//关闭ResultSet对象
		pstmt.close();//关闭PreparedStatement对象
		return manager;
	}

}
