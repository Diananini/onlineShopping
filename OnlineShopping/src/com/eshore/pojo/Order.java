package com.eshore.pojo;

public class Order {
	private int orderId;
	private int uid;
	private String receiver;
	private String userAddr;
	private int orderStatus;//0 未发货 1 已发货 2已接收
	private float money;
	public int getOrderId(){
		return orderId;
	}
	public void setOrderId(int orderId){
		this.orderId=orderId;
	}
	public String getReceiver(){
		return receiver;
	}
	public void setReceiver(String receiver){
		this.receiver=receiver;
	}
	public String getUserAddr(){
		return userAddr;
	}
	public void setUserAddr(String userAddr){
		this.userAddr=userAddr;
	}
	public int getOrderStatus(){
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus){
		this.orderStatus=orderStatus;
	}
	public int getUid(){
		return uid;
	}
	public void setUid(int uid){
		this.uid=uid;
	}
	public float getMoney(){
		return money;
	}
	public void setMoney(float money){
		this.money=money;
	}
}
