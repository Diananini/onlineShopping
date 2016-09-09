package com.eshore.service;

import com.eshore.dao.ManagerDao;
import com.eshore.dao.ManagerDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.Manager;

public class ManagerService implements ManagerDao{
	private DBConnection dbconn = null; // 定义数据库连接类
	private ManagerDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public ManagerService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new ManagerDaoImpl(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}
	//修改用户密码
	public int editPasswd(int manager_id,String passwd) throws Exception{
		int result = 0;
		try {
			result = this.dao.editPasswd(manager_id, passwd);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	//根据用户名查询用户
	public Manager queryByName(String manager_name) throws Exception{
		Manager manager = new Manager();
		try {
			manager = this.dao.queryByName(manager_name);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return manager;
	}

}
