package com.eshore.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.eshore.pojo.Goods;
import com.eshore.pojo.Kinds;
import com.eshore.tag.PageObject;
import com.eshore.utils.SetPageObject;

public class GoodDaoImpl implements GoodDao {

	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null; // 数据库操作对象
	ResultSet rs = null;
	// 通过构造方法取得数据库连接
	public GoodDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	//向数据库中插入商品数据
	public int addGood(Goods good) throws Exception{
		String sql = "{call spUpdateGoodsAndKinds (?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int result=0;
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, 1);
		cstmt.setInt(2, 0);
		cstmt.setString(3, good.getKinds());//设定商品类别
		cstmt.setString(4, good.getGname());//设定商品名称
		cstmt.setString(5, good.getGphoto());//设定商品照片
		cstmt.setString(6, good.getTypes());//设定商品型号
		cstmt.setString(7, good.getProducer());//设定商品生产者
		cstmt.setFloat(8, good.getPrice());//设定商品价格
		cstmt.setFloat(9, good.getCarriage());//设定商品运费
		cstmt.setString(10, good.getPdate());//设定商品生产日期
		cstmt.setString(11, good.getPaddress());//设定商品生产地址
		cstmt.setString(12, good.getDescribed());
		cstmt.registerOutParameter(13, java.sql.Types.INTEGER);  
		cstmt.execute();  
		result=cstmt.getInt(13);
		cstmt.close();
		return result;
	}

	public int deleteGood(int gid) throws Exception{
		String sql = "{call spUpdateGoodsAndKinds (?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int result=0; 
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, 0);
		cstmt.setInt(2, gid);
		cstmt.setString(3, "");//设定商品类别
		cstmt.setString(4, "");//设定商品名称
		cstmt.setString(5, "");//设定商品照片
		cstmt.setString(6, "");//设定商品型号
		cstmt.setString(7, "");//设定商品生产者
		cstmt.setFloat(8, 0);//设定商品价格
		cstmt.setFloat(9, 0);//设定商品运费
		cstmt.setString(10, "");//设定商品生产日期
		cstmt.setString(11, "");//设定商品生产地址
		cstmt.setString(12, "");
		cstmt.registerOutParameter(13, java.sql.Types.INTEGER);  
		cstmt.execute();  
		result=cstmt.getInt(13);
		cstmt.close();

		return result;
	}

	public Vector<Goods> queryAll(String keyWord, String keyClass) throws Exception{
		Vector<Goods> goodVector = new Vector<Goods>();
		String sql = "select gid,gname,gphoto,kinds,types,producer,"
				+ "price,carriage,pdate,paddress,described from goods ";
		if(keyClass!=null&&!"".equals(keyClass)){
			if("1".equals(keyClass)){//商品名称查询
				sql = "select gid,gname,gphoto,kinds,types,producer,"
					+ "price,carriage,pdate,paddress,described from goods where gname like '%"
					 +keyWord+"%' ";
			}else if("2".equals(keyClass)){//按照商品种类查询
				sql = "select gid,gname,gphoto,kinds,types,producer,"
					+ "price,carriage,pdate,paddress,described from goods where kinds like '%"
					 +keyWord+"%' ";
			}
		}
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) { 
			Goods good = new Goods();
			good.setGid(rs.getInt(1));
			good.setGname(rs.getString(2));//设定商品名称
			good.setGphoto(rs.getString(3));//设定商品照片
			good.setKinds(rs.getString(4));//设定商品类别
			good.setTypes(rs.getString(5));//设定商品型号
			good.setProducer(rs.getString(6));//设定商品生产者
			good.setPrice(rs.getFloat(7));//设定商品价格
			good.setCarriage(rs.getFloat(8));//设定商品运费
			good.setPdate(rs.getString(9));//设定商品生产日期
			good.setPaddress(rs.getString(10));//设定商品生产地址
			good.setDescribed(rs.getString(11));//设定商品描述
			goodVector.add(good);
		}
		rs.close();
		this.pstmt.close();
		return goodVector;
	}

	public int updateGood(Goods good) throws Exception{
		String sql = "update goods set gname=?,gphoto=?,kinds=?,types=?,producer=?,"
				+ "price=?,carriage=?,pdate=?,paddress=?,described=? where gid=?";
		int result = 0;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, good.getGname());//设定商品名称
		this.pstmt.setString(2, good.getGphoto());//设定商品照片
		this.pstmt.setString(3, good.getKinds());//设定商品类别
		this.pstmt.setString(4, good.getTypes());//设定商品型号
		this.pstmt.setString(5, good.getProducer());//设定商品生产者
		this.pstmt.setFloat(6, good.getPrice());//设定商品价格
		this.pstmt.setFloat(7, good.getCarriage());//设定商品运费
		this.pstmt.setString(8, good.getPdate());//设定商品生产日期
		this.pstmt.setString(9, good.getPaddress());//设定商品生产地址
		this.pstmt.setString(10, good.getDescribed());//设定商品描述
		this.pstmt.setInt(11, good.getGid());
		result = this.pstmt.executeUpdate();
		this.pstmt.close();
		return result;
	}
    
	public PageObject getPageObject(String curPage,PageObject pageObject,List<Object> listObject){
		SetPageObject setPageObject = SetPageObject.getInstance();//获取分页对象PageObject
		pageObject = setPageObject.setPageObjectData(curPage, pageObject, listObject);
		return pageObject;
	}
	//根据商品id查询指定商品
	public Vector<Goods> queryGoodBySid(int sid) throws Exception {
		Vector<Goods> goodVector = new Vector<Goods>();
		String sql = "select gid,gname,gphoto,kinds,types,producer,"
				+ "price,carriage,pdate,paddress,described from goods where gid="+sid;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) { 
			Goods good = new Goods();
			good.setGid(rs.getInt(1));//设定商品ID
			good.setGname(rs.getString(2));//设定商品名称
			good.setGphoto(rs.getString(3));//设定商品照片
			good.setKinds(rs.getString(4));//设定商品类别
			good.setTypes(rs.getString(5));//设定商品型号
			good.setProducer(rs.getString(6));//设定商品生产者
			good.setPrice(rs.getFloat(7));//设定商品价格
			good.setCarriage(rs.getFloat(8));//设定商品运费
			good.setPdate(rs.getString(9));//设定商品生产日期
			good.setPaddress(rs.getString(10));//设定商品生产地址
			good.setDescribed(rs.getString(11));//设定商品描述
			goodVector.add(good);
		}
		rs.close();
		this.pstmt.close();
		return goodVector;
	}
	//查询所有商品分类
	public Vector<Kinds> queryAllKinds()throws Exception{
		Vector<Kinds> kindVector = new Vector<Kinds>();
		String sql = "select * from Kinds ";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) { 
			Kinds kind = new Kinds();
			kind.setKinds(rs.getString(1));
			kind.setCounts(rs.getInt(2));
			kindVector.add(kind);
		}
		rs.close();
		this.pstmt.close();
		return kindVector;
	}
	//删除一类商品
	public int deleteKinds(String kinds)throws Exception{
		String sql = "begin transaction DeleteKindsTransaction "
						+"delete from Goods where kinds=? "
						+"if @@Error<>0 begin " 
							+"rollback transaction DeleteKindsTransaction "
							+"return end "
						+"delete from Kinds where kinds=? "
						+"if @@Error<>0 " 
							+"rollback transaction DeleteKindsTransaction "
						+"else commit transaction DeleteKindsTransaction";
		int result = 0;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setString(1, kinds);
		this.pstmt.setString(2, kinds);
		result = this.pstmt.executeUpdate();//执行数据库操作
		this.pstmt.close();
		return result;
	}
}
