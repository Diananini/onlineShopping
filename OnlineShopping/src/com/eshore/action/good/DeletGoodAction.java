package com.eshore.action.good;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;

public class DeletGoodAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取商品的ID
		int gid = Integer.valueOf(request
				.getParameter("gid"));
		try{
			if (DAOFactory.getGoodDAOInstance().
					deleteGood(gid) == 1) {//删除商品
				request.setAttribute("status", "已删除商品");
			} else {//删除失败
				request.setAttribute("status", "删除商品操作失败，请重试");
			}
		}catch(Exception e){
			if(e.getMessage().equals("the kind of the deleted good is unknown")){
				request.setAttribute("status", "所删除商品的所属分类不明！！更新分类信息失败！！");
				return "goods/deleteGood.jsp";
			}
			e.printStackTrace();
		}
		return "goods?action=showKinds";
	}
}
