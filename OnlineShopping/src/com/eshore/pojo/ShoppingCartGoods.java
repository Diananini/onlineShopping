package com.eshore.pojo;

import java.sql.Date;

public class ShoppingCartGoods {
	private int gid;
	private String kinds;// 类型
	private String gname;// 名字
	private String gphoto;// 实物图片
	private String types;// 型号
	private String producer;// 生产商
	private String paddress;// 出产地
	private String described;// 描述
	private String pdate;// 生产日期
	private float price;// 单价
	private float carriage;// 运费
	private int uid;//用户id
	private int number;//物品的数量
	private Date add_time;
	
	public Date getAddTime() {
		return add_time;
	}
	public void setAddTime(Date add_time) {
		this.add_time = add_time;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGphoto() {
		return gphoto;
	}

	public void setGphoto(String gphoto) {
		this.gphoto = gphoto;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getDescribed() {
		return described;
	}

	public void setDescribed(String described) {
		this.described = described;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getCarriage() {
		return carriage;
	}

	public void setCarriage(float carriage) {
		this.carriage = carriage;
	}

	

}
