package com.eshore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.eshore.pojo.Order;
import com.eshore.tag.PageObject;
import com.eshore.utils.SetPageObject;


public class OrderDaoImpl implements OrderDao{
	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null; // 数据库操作对象
	
	ResultSet rs = null;
	Vector<Order> orderVector = new Vector<Order>();

	// 通过构造方法取得数据库连接
	public OrderDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	//新增订单
	public int addOrder(Order order)throws Exception{
		String sql="insert into Orders(uid,user_addr,receiver,order_status,order_money) values(?,?,?,?,?)";
		int result=0;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, order.getUid());
		this.pstmt.setString(2, order.getUserAddr());
		this.pstmt.setString(3, order.getReceiver());
		this.pstmt.setInt(4, order.getOrderStatus());
		this.pstmt.setFloat(5, order.getMoney());
		result = this.pstmt.executeUpdate();//执行数据库操作
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return result;
	}
	//删除单个订单
	public int deleteOrder(int order_id)throws Exception{
		String sql = "delete from orders where order_id=?";
		int result = 0;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, order_id);
		result = pstmt.executeUpdate();//执行数据库操作
		this.pstmt.close(); // 关闭PreparedStatement操作
		 
		return result;
	}
	//删除全部订单
	public int deleteAllOrders(int uid)throws Exception{
		String sql = "delete from orders where uid=?";
		int result = 0;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		result = this.pstmt.executeUpdate();//执行数据库操作
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return result;
	}
	//处理订单
	public int processOrder(int order_id,int status)throws Exception{
		String sql="update Orders set order_status=? where order_id=?";
		int result=0;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, status);
		this.pstmt.setInt(2, order_id);
		result = this.pstmt.executeUpdate();//执行数据库操作
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return result;
	}
	//根据用户id和订单状态查询订单(未发货和已发货和已接收)
	public Vector<Order>queryDelivery(int uid,int status)throws Exception{
		String sql = "select order_id,uid,user_addr,receiver,order_status,order_money from Orders where uid=? and order_status=?";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		this.pstmt.setInt(2, status);
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) {
			Order order = new Order();
			order.setOrderId(rs.getInt(1));//设定id
			order.setUid(rs.getInt(2));//设定用户ID
			order.setUserAddr(rs.getString(3));
			order.setReceiver(rs.getString(4));
			order.setOrderStatus(rs.getInt(5));
			order.setMoney(rs.getFloat(6));
			orderVector.add(order);
		}
		rs.close();//关闭ResultSet对象
		this.pstmt.close();//关闭PreparedStatement对象
		return orderVector;
	}
	//根据订单状态查询订单(未发货和已发货和已接收)
	public Vector<Order>queryByStatus(int status)throws Exception{
		String sql = "select order_id,uid,user_addr,receiver,order_status,order_money from Orders where order_status=?";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, status);
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) {
			Order order = new Order();
			order.setOrderId(rs.getInt(1));//设定id
			order.setUid(rs.getInt(2));//设定用户ID
			order.setUserAddr(rs.getString(3));
			order.setReceiver(rs.getString(4));
			order.setOrderStatus(rs.getInt(5));
			order.setMoney(rs.getFloat(6));
			orderVector.add(order);
		}
		rs.close();//关闭ResultSet对象
		this.pstmt.close();//关闭PreparedStatement对象
		return orderVector;
	}
	//根据用户id查询用户所有订单
	public Vector<Order> queryByUid(int uid)throws Exception{
		String sql = "select order_id,uid,user_addr,receiver,order_status,order_money from Orders where uid=?";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) {
			Order order = new Order();
			order.setOrderId(rs.getInt(1));//设定id
			order.setUid(rs.getInt(2));//设定用户ID
			order.setUserAddr(rs.getString(3));
			order.setReceiver(rs.getString(4));
			order.setOrderStatus(rs.getInt(5));
			order.setMoney(rs.getFloat(6));
			orderVector.add(order);
		}
		rs.close();//关闭ResultSet对象
		this.pstmt.close();//关闭PreparedStatement对象
		return orderVector;
	}
	//购物车的分页对象
	public PageObject getPageObject(String curPage,PageObject pageObject,List<Object> listObject){
		SetPageObject setPageObject = SetPageObject.getInstance();
		pageObject = setPageObject.setPageObjectData(curPage, pageObject, listObject);
		return pageObject;
	}

}
