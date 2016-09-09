package com.eshore.service;


import com.eshore.dao.UserDao;
import com.eshore.dao.UserDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.Users;

public class UsersService implements UserDao {

	private DBConnection dbconn = null; // 定义数据库连接类
	private UserDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public UsersService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new UserDaoImpl(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}
	public int addUser(Users user) throws Exception {
		int result = 0;
		try {
			result = this.dao.addUser(user);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	public int deleteUser(int uid) throws Exception {
		int result = 0;
		try {
			result = this.dao.deleteUser(uid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	public int editInf(int uid, String uname, String gender,String phone) throws Exception {
		int result = 0;
		try {
			result = this.dao.editInf(uid, uname, gender,phone);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	public int editPasswd(int uid, String passwd) throws Exception {
		int result = 0;
		try {
			result = this.dao.editPasswd(uid, passwd);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	//修改用户最后登录时间
	public int editLastlogin(int uid) throws Exception{
		int result = 0;
		try {
			result = this.dao.editLastlogin(uid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	public Users queryByPhone(String phone) throws Exception {
		Users user = new Users();
		try {
			user = this.dao.queryByPhone(phone);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return user;
	}

	public Users queryByName(String uname) throws Exception {
		Users user = new Users();
		try {
			user = this.dao.queryByName(uname);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return user;
	}

}
