package com.eshore.service;

import java.util.List;
import java.util.Vector;

import com.eshore.dao.PurchaseDao;
import com.eshore.dao.PurchaseDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.Purchase;
import com.eshore.tag.PageObject;

public class PurchaseService implements PurchaseDao{
	private DBConnection dbconn = null; // 定义数据库连接类
	private PurchaseDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public PurchaseService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new PurchaseDaoImpl(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}
	public int addPurchase(Purchase p)throws Exception{
		int result = 0;
		try {
			result = this.dao.addPurchase(p);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	
	public int updatePurchaseCount(Purchase p)throws Exception{
		int result = 0;
		try {
			result = this.dao.updatePurchaseCount(p);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	
/*	public int addPurchases(String ids)throws Exception{
		int result = 0;
		try {
			result = this.dao.addPurchases(ids);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}*/

	public Vector<Purchase> getPurchasedGoods(String uid)throws Exception{
		Vector<Purchase> purchaseVector = new Vector<Purchase>();
		try {
			purchaseVector = this.dao.getPurchasedGoods(uid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return purchaseVector;
	}

	public PageObject getPageObject(String curPage, PageObject pageObject,
			List<Object> listObject) {
		pageObject = this.dao.getPageObject(curPage, pageObject, listObject);
		return pageObject;
	}
}
