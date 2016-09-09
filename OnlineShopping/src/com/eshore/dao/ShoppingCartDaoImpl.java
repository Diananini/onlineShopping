package com.eshore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.eshore.pojo.ShoppingCart;
import com.eshore.pojo.ShoppingCartGoods;
import com.eshore.tag.PageObject;
import com.eshore.utils.SetPageObject;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null; // 数据库操作对象
	
	ResultSet rs = null;
	Vector<ShoppingCart> busVector = new Vector<ShoppingCart>();
	Vector<ShoppingCartGoods> busGoodVector = new Vector<ShoppingCartGoods>();
	// 通过构造方法取得数据库连接
	public ShoppingCartDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	//删除指定的购物车信息
	public int deleteGoods(int gid, int uid) throws Exception{
		String sql = "delete from shoppingcart where uid=? and gid=?";
		int result = 0;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		this.pstmt.setInt(2, gid);
		result = pstmt.executeUpdate();//执行数据库操作
		this.pstmt.close(); // 关闭PreparedStatement操作
		 
		return result;
	}
	//根据用户id获取所有的商品
	public Vector<ShoppingCart> getAllGoods(int uid) throws Exception{
		String sql = "select id,gid,number,add_time from shoppingcart where uid=?";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) {
			ShoppingCart bus = new ShoppingCart();
			bus.setId(rs.getInt(1));//设定购物车id
			bus.setGid(rs.getInt(2));//设定购物车中商品的ID
			bus.setUid(uid);//设定购物车中用户的id
			bus.setNumber(rs.getInt(3));//设定购物车中商品的数量
			bus.setAddTime(rs.getDate(4));//设定购物车的状态
			busVector.add(bus);
		}
		rs.close();//关闭ResultSet对象
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return busVector;
	}
	//根据用户id获取购物车中所有商品的信息
	public Vector<ShoppingCartGoods> getAllSCGoods(int uid)throws Exception{
		String sql = "select gid,kinds,gname,gphoto,types," +
				"producer,price,carriage,pdate,paddress,described," +
				"uid,number,add_time from ShoppingCartGoods where uid=?";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) {
			ShoppingCartGoods bus = new ShoppingCartGoods();
			bus.setGid(rs.getInt(1));
			bus.setKinds(rs.getString(2));//设定商品类别
			bus.setGname(rs.getString(3));//设定商品名称
			bus.setGphoto(rs.getString(4));//设定商品照片
			bus.setTypes(rs.getString(5));//设定商品型号
			bus.setProducer(rs.getString(6));//设定商品生产者
			bus.setPrice(rs.getFloat(7));//设定商品价格
			bus.setCarriage(rs.getFloat(8));//设定商品运费
			bus.setPdate(rs.getString(9));//设定商品生产日期
			bus.setPaddress(rs.getString(10));//设定商品生产地址
			bus.setDescribed(rs.getString(11));//设定商品描述
			bus.setUid(uid);//设定购物车中用户的id
			bus.setNumber(rs.getInt(13));//设定购物车中商品的数量
			bus.setAddTime(rs.getDate(14));//设定购物车的状态
			busGoodVector.add(bus);
		}
		rs.close();//关闭ResultSet对象
		this.pstmt.close();//关闭PreparedStatement对象		 
		return busGoodVector;
	}
	//根据用户id查询购物车
	public Vector<ShoppingCart> getAppointedGoods(int uid) throws Exception{
		String sql = "select id,gid,number from shoppingcart where uid=?";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) {
			ShoppingCart bus = new ShoppingCart();
			bus.setId(rs.getInt(1));//设定购物车id
			bus.setGid(rs.getInt(2));//设定购物车中商品的ID
			bus.setUid(uid);//设定购物车中用户的id
			bus.setNumber(rs.getInt(3));//设定购物车中商品的数量
			//bus.setStatus(status);//设定购物车的状态
			busVector.add(bus);
		}
		rs.close();
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return busVector;
	}

	public int addBus(int gid, int uid,int number) throws Exception{
		String sql="insert into shoppingcart(uid,gid,number,add_time) values(?,?,?,getdate())";
		int result=0;
		this.pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);//设定购物车中用户的ID
		this.pstmt.setInt(2, gid);//设定购物车中商品的ID
		this.pstmt.setInt(3, number);//设定购物车中商品的数量
		result=this.pstmt.executeUpdate();//执行数据库操作
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return result;
	}
	//修改购物车信息
	public int updatebus(int id,int number) throws Exception{
		String sql="update shoppingcart set number=? where id=?";
		int result=0;
		this.pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, number);//设定购物车中商品的数量
		this.pstmt.setInt(2, id);
		
		result=this.pstmt.executeUpdate();//执行数据库操作
		this.pstmt.close();//关闭PreparedStatement对象
		return result;
	}
	//更新购物车信息
	/*public int updateShopcarts(String ids,int status) throws Exception{
		String sql="update shoppingcart set status=? where id in (?)";
		int result=0;
		this.pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, status);
		this.pstmt.setString(2, ids);
		result=this.pstmt.executeUpdate(sql);//执行数据库操作
		this.pstmt.close();//关闭PreparedStatement对象
		return result;
	}*/
	//根据购物车状态，商品id，用户id查询购物车
	public ShoppingCart getGoodsId(int uid, int gid) throws Exception{
		String sql = "select id,number from shoppingcart where uid=? and gid=?";
		ShoppingCart bus = new ShoppingCart();
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		this.pstmt.setInt(2, gid);
		//this.pstmt.setInt(3, status);
		rs = this.pstmt.executeQuery();//执行数据库操作
		if (rs.next()) {
			bus.setId(rs.getInt(1));
			bus.setGid(gid);//设定购物车中商品的ID
			bus.setUid(uid);//设定购物车中用户的ID
			//bus.setStatus(status);//设定购物车状态
			bus.setNumber(rs.getInt(2));//设定购物车中商品的数量
		}
		rs.close();//关闭ResultSet对象
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return bus;
	}
	//删除所有的购物车信息
	public int deleteAll(int uid) throws Exception{
		String sql = "delete from shoppingcart where uid=?";
		int result = 0;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		//this.pstmt.setInt(2, status);
		result = this.pstmt.executeUpdate();//执行数据库操作
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return result;
	}
	//购物车的分页对象
	public PageObject getPageObject(String curPage,PageObject pageObject,List<Object> listObject){
		SetPageObject setPageObject = SetPageObject.getInstance();
		pageObject = setPageObject.setPageObjectData(curPage, pageObject, listObject);
		return pageObject;
	}
}
