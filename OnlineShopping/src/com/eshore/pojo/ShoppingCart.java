package com.eshore.pojo;

import java.util.Date;

public class ShoppingCart {
	
	private int id;//购物车id
	private int gid;//商品id
	private int uid;//用户id
	private int number;//物品的数量
	private Date add_time;
	
	public Date getAddTime() {
		return add_time;
	}
	public void setAddTime(Date add_time) {
		this.add_time = add_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
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
	

}
