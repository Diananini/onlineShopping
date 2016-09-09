package com.eshore.action.shoppingcart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.ShoppingCart;

public class InsertShoppingCartAction implements Action {

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
			ShoppingCart bus = DAOFactory.getShoppingCartDAOInstance().
					getGoodsId(uid, gid);
			if (bus.getId() == 0) {// 如果购物车中不存
				DAOFactory.getShoppingCartDAOInstance().addBus(gid, uid, number); // 在则加入购物车
			} else { // 否则修改未付款的商品数量
				DAOFactory.getShoppingCartDAOInstance().updatebus(bus.getId(),bus.getNumber() + number);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("status", "已将该宝贝添加到您的购物车……");
		return "goods?sid=" + gid
				+ "&action=goodslist-select";
	}
}
