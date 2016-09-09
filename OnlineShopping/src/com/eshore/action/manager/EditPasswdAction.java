package com.eshore.action.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Manager;

public class EditPasswdAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取用户的id值
		int manager_id = Integer.parseInt(String.valueOf(
				request.getSession().getAttribute("manager_id")));
		//获取旧密码
		String oldPasswd = request.getParameter("oldPasswd");
		//获取新密码
		String passwd = request.getParameter("passwd1");
		String confirdPasswd = request.getParameter("passwd2");
		try{
			//根据用户名查询用户
			Manager manager =DAOFactory.getManagerDAOInstance().
				queryByName(String.valueOf(
						request.getSession().getAttribute("manager_name")));
			//判断输入的旧密码跟原来的旧密码是否一致，
			//如果一致进行修改
			if(manager.getManagerPw().equals(oldPasswd)){
				if(isValidPassword(passwd,confirdPasswd)){//验证密码
					request.setAttribute("status", "密码为空或者密码不一致！");
				}
				if(DAOFactory.getManagerDAOInstance().
						editPasswd(manager_id, passwd)==1){//密码修改成功
					request.setAttribute("status", "密码修改成功！");
				}else{//密码修改失败
					request.setAttribute("status", "密码修改操作失败，请重试！");
				}
			}else{//输入密码错误
				request.setAttribute("status", "原密码错误，你不能修改密码！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "order?action=allNotDelivered";
	}
	//验证密码，如果密码为空且长度小于6并且跟确认密码不统一
	//返回true
	public boolean isValidPassword(String passwd,String confirdPasswd){
		return passwd==null||confirdPasswd==null
		||passwd.length()<6||confirdPasswd.length()<6
		||!passwd.equals(confirdPasswd);
	}
}
