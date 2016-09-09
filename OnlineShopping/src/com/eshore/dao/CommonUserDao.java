package com.eshore.dao;

import com.eshore.pojo.CommonUsers;

public interface CommonUserDao {
	//添加用户
	public int addUser(CommonUsers commonUser) throws Exception;
	//根据用户Ip查询用户
	public CommonUsers queryByIp(String ip) throws Exception;
	//查询刚刚加入的用户，由于uid是自增的，即查询uid最大的
	public CommonUsers latestAdded() throws Exception;
	//根据用户Ip修改用户权限
	public int updateByIp(String ip) throws Exception;
}
