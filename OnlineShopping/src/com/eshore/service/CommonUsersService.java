package com.eshore.service;

import com.eshore.dao.CommonUserDao;
import com.eshore.dao.CommonUserDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.CommonUsers;

public class CommonUsersService implements CommonUserDao {

	private DBConnection dbconn = null; // 定义数据库连接类
	private CommonUserDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public CommonUsersService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new CommonUserDaoImpl(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}
	public int addUser(CommonUsers commonUser) throws Exception {
		int result = 0;
		try {
			result = this.dao.addUser(commonUser);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	
	public CommonUsers queryByIp(String ip) throws Exception {
		CommonUsers commonUser = new CommonUsers();
		try {
			commonUser = this.dao.queryByIp(ip);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return commonUser;
	}
	
	public CommonUsers latestAdded() throws Exception{
		CommonUsers commonUser = new CommonUsers();
		try {
			commonUser = this.dao.latestAdded();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return commonUser;
	}
	
	
	public int updateByIp(String ip) throws Exception{
		int result = 0;
		try {
			result = this.dao.updateByIp(ip);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

}
