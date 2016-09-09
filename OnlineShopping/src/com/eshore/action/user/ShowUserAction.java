package com.eshore.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Users;

/**
 *查看用户
 */
public class ShowUserAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			//根据用户名查询用户
			Users user = DAOFactory.getUserDAOInstance().queryByName(
					String.valueOf(request.getSession().getAttribute("uname")));
			request.setAttribute("gender", user.getGender());
			request.setAttribute("phone", user.getPhone());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "user/myinf.jsp";
	}
}
