package com.eshore.pojo;

public class Manager {
	private int manager_id;
	private String manager_name;
	private String manager_pw;
	public int getManagerId(){
		return manager_id;
	}
	public void setManagerId(int id){
		this.manager_id=id;
	}
	public String getManagerName(){
		return manager_name;
	}
	public void setManagerName(String name){
		this.manager_name=name;
	}
	public String getManagerPw(){
		return manager_pw;
	}
	public void setManagerPw(String pw){
		this.manager_pw=pw;
	}

}
