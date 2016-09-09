package com.eshore.service;

import java.util.List;
import java.util.Vector;

import com.eshore.dao.ShoppingCartDao;
import com.eshore.dao.ShoppingCartDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.ShoppingCart;
import com.eshore.pojo.ShoppingCartGoods;
import com.eshore.tag.PageObject;

public class ShoppingCartService implements ShoppingCartDao {

	private DBConnection dbconn = null; // 定义数据库连接类
	private ShoppingCartDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public ShoppingCartService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new ShoppingCartDaoImpl(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}
	public int deleteGoods(int gid, int uuid) throws Exception {
		int result = 0;
		try {
			result = this.dao.deleteGoods(gid, uuid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	public Vector<ShoppingCart> getAllGoods(int uuid) throws Exception {
		Vector<ShoppingCart> busVector = new Vector<ShoppingCart>();
		try {
			busVector = this.dao.getAllGoods(uuid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return busVector;
	}

	//根据用户id获取购物车中所有商品的信息
	public Vector<ShoppingCartGoods> getAllSCGoods(int uid)throws Exception{
		Vector<ShoppingCartGoods> busVector = new Vector<ShoppingCartGoods>();
		try {
			busVector = this.dao.getAllSCGoods(uid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return busVector;
	}
	public Vector<ShoppingCart> getAppointedGoods(int uuid) throws Exception {
		Vector<ShoppingCart> busVector = new Vector<ShoppingCart>();
		try {
			busVector = this.dao.getAppointedGoods(uuid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return busVector;
	}

	public ShoppingCart getGoodsId(int uuid, int gid) throws Exception {
		ShoppingCart bus = new ShoppingCart();
		try {
			bus = this.dao.getGoodsId(uuid, gid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return bus;
	}

	public int addBus(int gid, int uuid, int number) throws Exception {
		// TODO Auto-generated method stub
		int result=0;
		try {
			result = this.dao.addBus(gid, uuid, number);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	public int deleteAll(int uuid) throws Exception {
		// TODO Auto-generated method stub
		int result=0;
		try {
			result = this.dao.deleteAll(uuid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}

	public int updatebus(int id, int number) throws Exception {
		int result=0;
		try {
			result = this.dao.updatebus(id, number);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	/*public int updateShopcarts(String ids, int status) throws Exception {
		int result=0;
		try {
			result = this.dao.updateShopcarts(ids, status);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}*/
	public PageObject getPageObject(String curPage, PageObject pageObject,
			List<Object> listObject) {
		pageObject = this.dao.getPageObject(curPage, pageObject, listObject);
		return pageObject;
	}
}
