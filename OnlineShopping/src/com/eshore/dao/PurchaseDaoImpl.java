package com.eshore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.eshore.pojo.Purchase;
import com.eshore.tag.PageObject;
import com.eshore.utils.SetPageObject;

public class PurchaseDaoImpl implements PurchaseDao{
	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null; // 数据库操作对象
	
	ResultSet rs = null;
	Vector<Purchase> busVector = new Vector<Purchase>();

	// 通过构造方法取得数据库连接
	public PurchaseDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	
	public int addPurchase(Purchase p)throws Exception{
		int result=0;
		String sql0="select count from Purchase where uid=? and gid=?";
		this.pstmt = this.conn.prepareStatement(sql0);
		this.pstmt.setInt(1, p.getUid());//设定用户id
		this.pstmt.setInt(2, p.getGid());//设定商品id
		rs = this.pstmt.executeQuery();
		int count=0;
		if (rs.next()){
			count=rs.getInt(1);
		}	
		this.pstmt.close();
		if(count!=0){
			String sql1="update Purchase set count=?,sum_price=? where uid=? and gid=?";
			this.pstmt = this.conn.prepareStatement(sql1);
			this.pstmt.setInt(1, count+p.getCount());
			this.pstmt.setFloat(2, (count+p.getCount())*p.getUnitPrice()+p.getUnitCarriage());
			this.pstmt.setInt(3, p.getUid());//设定用户id
			this.pstmt.setInt(4, p.getGid());//设定商品id
			result = this.pstmt.executeUpdate();
			this.pstmt.close();
			return result;
		}
			
		String sql="insert into Purchase values(?,?,?,?,?,?)";
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, p.getUid());//设定用户id
		this.pstmt.setInt(2, p.getGid());//设定商品id
		this.pstmt.setFloat(3, p.getUnitPrice());//设定商品单价
		this.pstmt.setFloat(4,p.getUnitCarriage());
		this.pstmt.setInt(5, p.getCount());//设定商品数目
		this.pstmt.setFloat(6, p.getSumPrice());//设定购买总金额
		result = this.pstmt.executeUpdate();
		this.pstmt.close();
		return result;
	}
	
	//重置购买物品的数目
	public int updatePurchaseCount(Purchase p)throws Exception{
		int result=0;
		String sql="update Purchase set count=? where uid=? and gid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,p.getCount());
		this.pstmt.setInt(2,p.getUid());
		this.pstmt.setInt(3,p.getGid());
		result = this.pstmt.executeUpdate();
		this.pstmt.close();
		return result;
	}
/*	public int addPurchases(String ids)throws Exception{
		int result = 0;
		String sql="select uid,gid,number from ShoppingCart where id in (?)";
		Vector<Purchase> purchaseVector=new Vector<Purchase>();
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,ids);
		
		this.pstmt.executeQuery(sql);//执行数据库操作
		while(rs.next()){
			Purchase p=new Purchase();
			p.setUid(rs.getInt(1));
			p.setGid(rs.getInt(2));
			p.setUnitPrice(DAOFactory.getGoodDAOInstance().queryGoodBySid(p.getGid()).firstElement().getPrice());
			p.setUnitCarriage(DAOFactory.getGoodDAOInstance().queryGoodBySid(p.getGid()).firstElement().getCarriage());
			p.setcount(rs.getInt(3));
			p.setSumPrice(p.getCount()*p.getUnitPrice()+p.getUnitCarriage());
			purchaseVector.add(p);
		}
		rs.close();
		this.pstmt.close();
		sql="insert into Purchase values(?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		Iterator<Purchase> it=purchaseVector.iterator();
		while(it.hasNext()){
			Purchase p=it.next();
			this.pstmt.setInt(1, p.getUid());//设定用户id
			this.pstmt.setInt(2, p.getGid());//设定商品id
			this.pstmt.setFloat(3, p.getUnitPrice());//设定商品单价
			this.pstmt.setFloat(4, p.getUnitCarriage());//设定商品运费
			this.pstmt.setInt(5, p.getCount());//设定商品数目
			this.pstmt.setFloat(6, p.getSumPrice());//设定购买总金额
			result = this.pstmt.executeUpdate();
			if(result==0)
				return result;
		}
		this.pstmt.close();
		return result;
	}*/
	public Vector<Purchase> getPurchasedGoods(String uid)throws Exception{
		String sql="select * from Purchase where uid="+uid;
		Vector<Purchase> purchaseVector=new Vector<Purchase>();
		this.pstmt = this.conn.prepareStatement(sql);
		rs = this.pstmt.executeQuery();//执行数据库操作
		while(rs.next()){
			Purchase p=new Purchase();
			p.setUid(rs.getInt(1));
			p.setGid(rs.getInt(2));
			p.setUnitPrice(rs.getFloat(3));
			p.setUnitCarriage(rs.getFloat(4));
			p.setcount(rs.getInt(5));
			p.setSumPrice(rs.getFloat(6));
			purchaseVector.add(p);
		}
		rs.close();
		this.pstmt.close();
		return purchaseVector;
		}

	
	public PageObject getPageObject(String curPage,PageObject pageObject,List<Object> listObject){
		SetPageObject setPageObject = SetPageObject.getInstance();//获取分页对象PageObject
		pageObject = setPageObject.setPageObjectData(curPage, pageObject, listObject);
		return pageObject;
	}
}
