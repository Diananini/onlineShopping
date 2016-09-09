package com.eshore.pojo;

public class Purchase {
	private int uid;
	private int gid;
	private float unit_price;
	private float unit_carriage;
	private int count;
	private float sum_price;
	public int getUid(){
		return uid;
	}
	public void setUid(int uid){
		this.uid=uid;
	}
	public int getGid(){
		return gid;
	}
	public void setGid(int gid){
		this.gid=gid;
	}
	public float getUnitPrice(){
		return unit_price;
	}
	public void setUnitPrice(float unit_price){
		this.unit_price=unit_price;
	}
	public float getUnitCarriage(){
		return unit_carriage;
	}
	public void setUnitCarriage(float unit_carriage){
		this.unit_carriage=unit_carriage;
	}
	public int getCount(){
		return count;
	}
	public void setcount(int count){
		this.count=count;
	}
	public float getSumPrice(){
		return sum_price;
	}
	public void setSumPrice(float sum_price){
		this.sum_price=sum_price;
	}
}
