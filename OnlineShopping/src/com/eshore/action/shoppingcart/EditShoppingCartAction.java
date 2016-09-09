package com.eshore.action.shoppingcart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.ShoppingCart;

public class EditShoppingCartAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取商品的ID
		int gid = Integer.parseInt(String.valueOf(request
				.getParameter("gid")));
		//获取商品的数量
		int number = Integer.parseInt(String.valueOf(request
				.getParameter("number")));
		//获取登录用户的ID
		String uids = String.valueOf(request.getSession().getAttribute("uid"));
		int uid = Integer.parseInt(uids);
		try{
			//获得指定的购物车列表
			ShoppingCart bus = DAOFactory.getShoppingCartDAOInstance().
					getGoodsId(uid, gid);
			DAOFactory.getShoppingCartDAOInstance().   //更新购物车中商品数量
					updatebus(bus.getId(), number);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "shoppingcart?action=lookbus";
	}

}
