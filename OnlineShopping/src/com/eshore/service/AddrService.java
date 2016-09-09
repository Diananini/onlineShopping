package com.eshore.service;

import com.eshore.dao.AddrDao;
import com.eshore.dao.AddrDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.Addr;

public class AddrService implements AddrDao{
	private DBConnection dbconn = null; // 定义数据库连接类
	private AddrDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public AddrService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new AddrDaoImpl(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}
	public int addAddr(Addr addr)throws Exception{
		int result = 0;
		try {
			result = this.dao.addAddr(addr);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

}
