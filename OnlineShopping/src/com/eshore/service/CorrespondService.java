package com.eshore.service;

import java.util.Vector;

import com.eshore.dao.CorrespondDao;
import com.eshore.dao.CorrespondDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.Correspond;

public class CorrespondService implements CorrespondDao{
	private DBConnection dbconn = null; // 定义数据库连接类
	private CorrespondDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public CorrespondService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new CorrespondDaoImpl(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}
	public int addCorrespond(Correspond corr)throws Exception{
		int result = 0;
		try {
			result = this.dao.addCorrespond(corr);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	public Vector<Correspond> queryByUid(int uid)throws Exception{
		Vector<Correspond> corrVector = new Vector<Correspond>();
		try {
			corrVector = this.dao.queryByUid(uid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return corrVector;
	}
}
