package com.eshore.dao;

import java.util.List;
import java.util.Vector;

import com.eshore.pojo.Order;
import com.eshore.tag.PageObject;

public interface OrderDao {
	//新增订单
	public int addOrder(Order order)throws Exception;
	//删除单个订单
	public int deleteOrder(int order_id)throws Exception;
	//删除全部订单
	public int deleteAllOrders(int uid)throws Exception;
	//处理订单
	public int processOrder(int order_id,int status)throws Exception;
	//根据用户id和订单状态查询订单(未发货和已发货和已接收)
	public Vector<Order>queryDelivery(int uid,int status)throws Exception;
	//根据订单状态查询订单(未发货和已发货和已接收)
	public Vector<Order>queryByStatus(int status)throws Exception;
	//根据用户id查询用户所有订单
	public Vector<Order> queryByUid(int uid)throws Exception;
	//订单的分页对象
	public PageObject getPageObject(String curPage,PageObject pageObject,List<Object> listObject);

}
