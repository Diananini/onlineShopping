package com.eshore.service;

import java.util.List;
import java.util.Vector;

import com.eshore.dao.GoodDao;
import com.eshore.dao.GoodDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.Goods;
import com.eshore.pojo.Kinds;
import com.eshore.tag.PageObject;

public class GoodService implements GoodDao {
	
	private DBConnection dbconn = null; // 定义数据库连接类
	private GoodDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public GoodService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new GoodDaoImpl(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}
	public int addGood(Goods good) throws Exception {
		// TODO Auto-generated method stub
		int result = 0; // 标识
		try {
			result = this.dao.addGood(good);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	public int deleteGood(int gid) throws Exception {
		int result = 0;
		try {
			result = this.dao.deleteGood(gid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	public Vector<Goods> queryAll(String keyWord, String keyClass) throws Exception {
		Vector<Goods> goodVector = new Vector<Goods>();
		try {
			goodVector = this.dao.queryAll(keyWord, keyClass);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return goodVector;
	}

	public int updateGood(Goods good) throws Exception {
		int result = 0;
		try {
			result = this.dao.updateGood(good);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	public PageObject getPageObject(String curPage, PageObject pageObject,
			List<Object> listObject) {
		pageObject = this.dao.getPageObject(curPage, pageObject, listObject);
		return pageObject;
	}
	public Vector<Goods> queryGoodBySid(int sid) throws Exception {
		Vector<Goods> goodVector = new Vector<Goods>();
		try {
			goodVector = this.dao.queryGoodBySid(sid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return goodVector;
	}
	//查询所有商品分类
	public Vector<Kinds> queryAllKinds()throws Exception{
		Vector<Kinds> kindVector = new Vector<Kinds>();
		try {
			kindVector = this.dao.queryAllKinds();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return kindVector;
	}
	public int deleteKinds(String kinds)throws Exception{
		int result = 0;
		try {
			result = this.dao.deleteKinds(kinds);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

}
