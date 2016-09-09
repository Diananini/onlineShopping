package com.eshore.action.shoppingcart;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Goods;
import com.eshore.pojo.ShoppingCart;

public class PaidAllAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取登录用户的ID
		String uids = String.valueOf(request.getSession().getAttribute("uid"));
		int uid = Integer.parseInt(uids);
		float countPrice = 0.0f;
		String shopcartId="";
		try{
			//获得该用户的购物车列表
			Vector<ShoppingCart> busVector = DAOFactory.getShoppingCartDAOInstance().
					getAppointedGoods(uid);
			for (int i = 0; i < busVector.size(); i++) {
				ShoppingCart cart = new ShoppingCart();
				cart = (ShoppingCart) busVector.get(i);
				Goods good=new Goods();
				//获得商品ID
				Vector<Goods> gVector=DAOFactory.getGoodDAOInstance().
						queryGoodBySid(cart.getGid());
				//获得所有购物车的id
				if(gVector.size()>0&&gVector!=null){
					good =(Goods)gVector.get(0);
					shopcartId+=cart.getId()+",";
				}
				//计算购物车中商品总价格
				countPrice+=cart.getNumber()*good.getPrice();
			}
			//将购物车中的id中最好的一个逗号删除
			shopcartId = shopcartId.substring(0, shopcartId.length()-1);
		}catch(Exception e){
			e.printStackTrace();
		}
		//向页面传送shopcartId参数值
		request.setAttribute("shopcartId",shopcartId);
		//向页面传送countPrice参数值
		request.setAttribute("countPrice",countPrice);
		return "shoppingcart/payall.jsp";
	}
}
