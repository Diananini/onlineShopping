package com.eshore.pojo;

public class CommonUsers {
	private int uid;//用户id
	private String ip;//用户ip
	private int uright;//用户权限
	
	public void setUid(int uid){
		this.uid=uid;
	}
	public int getUid(){
		return uid;
	}
	public void setIp(String ip){
		this.ip=ip;
	}
	public String getIp(){
		return ip;
	}
	public void setUright(int uright){
		this.uright=uright;
	}
	public int getUright(){
		return uright;
	}
}
