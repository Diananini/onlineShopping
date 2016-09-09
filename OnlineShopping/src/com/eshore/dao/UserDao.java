package com.eshore.dao;


import com.eshore.pojo.Users;

public interface UserDao {
	//添加用户
	public int addUser(Users user) throws Exception;
	//修改用户信息
	public int editInf(int uid,String uname,String gender,String phone) throws Exception;
	//修改用户密码
	public int editPasswd(int uid,String passwd) throws Exception;
	//修改用户最后登录时间
	public int editLastlogin(int uid) throws Exception;
	//根据用户id，删除用户
	public int deleteUser(int uid) throws Exception;
	//根据用户名查询用户
	public Users queryByName(String uname) throws Exception;
	//根据用户Phone查询用户
	public Users queryByPhone(String phone) throws Exception;

}
