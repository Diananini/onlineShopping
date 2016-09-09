package com.eshore.action;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.eshore.action.manager.EditPasswdAction;
import com.eshore.action.user.EditUserAction;
import com.eshore.action.user.EditinfUserAction;
import com.eshore.action.user.ShowUserAction;


public class ManagerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		Action targetAction =null;
		String path = null;
		if (action.equals("show")) {//查看用户列表
			targetAction = new ShowUserAction();
			try{
			path=targetAction.execute(request, response);
			}catch(Exception e){				
			}
		} else if (action.equals("edit")) {//跳转编辑用户页面
			targetAction = new EditUserAction();
			try{
				path=targetAction.execute(request, response);
				}catch(Exception e){				
				}
		} else if (action.equals("editinf")) {//修改用户信息
			targetAction = new EditinfUserAction();
			try{
				path=targetAction.execute(request, response);
				}catch(Exception e){				
				}
		} else if (action.equals("editpasswd")) {//更改密码
			targetAction = new EditPasswdAction();
			try{
				path=targetAction.execute(request, response);
				}catch(Exception e){				
				}
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
