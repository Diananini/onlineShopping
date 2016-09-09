package com.eshore.service;

import java.util.List;
import java.util.Vector;

import com.eshore.dao.OrderDao;
import com.eshore.dao.OrderDaoImpl;
import com.eshore.db.DBConnection;
import com.eshore.pojo.Order;
import com.eshore.tag.PageObject;

public class OrderService implements OrderDao{
	private DBConnection dbconn = null; // 定义数据库连接类
	private OrderDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public OrderService() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = new OrderDaoImpl(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}
	//新增订单
	public int addOrder(Order order)throws Exception{
		int result=0;
		try {
			result = this.dao.addOrder(order);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	//删除单个订单
	public int deleteOrder(int order_id)throws Exception{
		int result=0;
		try {
			result = this.dao.deleteOrder(order_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	//删除全部订单
	public int deleteAllOrders(int uid)throws Exception{
		int result=0;
		try {
			result = this.dao.deleteAllOrders(uid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	//处理订单
	public int processOrder(int order_id,int status)throws Exception{
		int result=0;
		try {
			result = this.dao.processOrder(order_id,status);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	//根据用户id和订单状态查询订单(未发货和已发货和已接收)
	public Vector<Order>queryDelivery(int uid,int status)throws Exception{
		Vector<Order> orderVector = new Vector<Order>();
		try {
			orderVector = this.dao.queryDelivery(uid, status);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return orderVector;
	}
	public Vector<Order>queryByStatus(int status)throws Exception{
		Vector<Order> orderVector = new Vector<Order>();
		try {
			orderVector = this.dao.queryByStatus(status);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return orderVector;
	}
	//根据用户id查询用户所有订单
	public Vector<Order> queryByUid(int uid)throws Exception{
		Vector<Order> orderVector = new Vector<Order>();
		try {
			orderVector = this.dao.queryByUid(uid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return orderVector;
	}
	//订单的分页对象
	public PageObject getPageObject(String curPage,PageObject pageObject,List<Object> listObject){
		pageObject = this.dao.getPageObject(curPage, pageObject, listObject);
		return pageObject;
	}

}
