package com.eshore.dao;

import java.util.List;
import java.util.Vector;

import com.eshore.pojo.Purchase;
import com.eshore.tag.PageObject;

public interface PurchaseDao {
	//根据用户id得到已购买的物品
	public Vector<Purchase> getPurchasedGoods(String uid)throws Exception;
	//添加已购买的物品
	public int addPurchase(Purchase p)throws Exception;
	//重置购买物品的数目
	public int updatePurchaseCount(Purchase p)throws Exception;
	//添加多个购买
//	public int addPurchases(String ids)throws Exception;
	//分页显示已购买商品列表
	public PageObject getPageObject(String curPage,PageObject pageObject,List<Object> listObject);
}
