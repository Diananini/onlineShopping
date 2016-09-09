package com.eshore.dao;

import java.util.List;
import java.util.Vector;

import com.eshore.pojo.Goods;
import com.eshore.pojo.Kinds;
import com.eshore.tag.PageObject;

public interface GoodDao {

	//添加商品
	public int addGood(Goods good) throws Exception;
	//删除指定商品
	public int deleteGood(int gid) throws Exception;
	//更新指定商品
	public int updateGood(Goods good) throws Exception;
	//根据商品的id查找商品
	public Vector<Goods> queryGoodBySid(int sid) throws Exception;
	//根据类型，输入关键字查询商品列表
	public Vector<Goods> queryAll(String keyWord, String keyClass) throws Exception;
	//分页显示商品列表
	public PageObject getPageObject(String curPage,PageObject pageObject,List<Object> listObject);
	//查询所有商品分类
	public Vector<Kinds> queryAllKinds()throws Exception;
	//删除一类商品
	public int deleteKinds(String kinds)throws Exception;
}
