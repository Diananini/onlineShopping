package com.eshore.dao;

import com.eshore.pojo.Manager;



public interface ManagerDao {
	//修改用户密码
	public int editPasswd(int manager_id,String passwd) throws Exception;
	//根据用户名查询用户
	public Manager queryByName(String manager_name) throws Exception;
}
