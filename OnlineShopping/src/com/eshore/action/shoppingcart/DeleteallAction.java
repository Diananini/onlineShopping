package com.eshore.action.shoppingcart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;

public class DeleteallAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取登录用户的ID
		String uids = String.valueOf(request.getSession().getAttribute("uid"));
		int uid = Integer.parseInt(uids);
		try{
			if (DAOFactory.getShoppingCartDAOInstance().
					deleteAll(uid) > 0) {//删除购物车商品
				request.setAttribute("status", "您的购物车中没有商品。");
			} else {//删除失败
				request.setAttribute("status", "删除商品操作失败，请重试。");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "shoppingcart?action=lookbus";
	}

}
