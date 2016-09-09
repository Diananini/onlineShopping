package com.eshore.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Users;

public class EditinfUserAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取用户的id值
		int uid = Integer.parseInt(String.valueOf(
				request.getSession().getAttribute("uid")));
		//获取用户的用户名
		String uname = request.getParameter("uname");
		//获取用户性别
		String gender=request.getParameter("gender");
		//获取用户phone
		String phone = request.getParameter("phone");
		try{
			//根据用户名查询用户
			Users user=DAOFactory.getUserDAOInstance().queryByName(
					String.valueOf(request.getSession().getAttribute("uname")));
			if(user.getUname().equals(uname)||
					DAOFactory.getUserDAOInstance().
					queryByName(uname).getUid()==0){//用户名未注册
				if(user.getPhone().equals(phone)||
						DAOFactory.getUserDAOInstance().
						queryByPhone(phone).getUid()==0){//电话未被注册
					if(DAOFactory.getUserDAOInstance().
							editInf(uid, uname,gender,phone)==1){//用户信息修改成功
						request.getSession().setAttribute("uname", uname);
						request.setAttribute("status", "信息修改成功！");
					}else{//用户信息修改失败
						request.setAttribute("status", "修改操作失败，请重试！");
					}
				}else{//邮箱已经被注册
					request.setAttribute("status", "电话已被注册,请换一个！");
				}
			}else{//判断用户名已经存在
				request.setAttribute("status", "用户名已存在，请换一个！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "shoppingcart?action=lookbus";
	}

}
