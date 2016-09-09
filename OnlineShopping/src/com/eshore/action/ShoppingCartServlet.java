package com.eshore.action;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.shoppingcart.DeletShoppingCartAction;
import com.eshore.action.shoppingcart.DeleteallAction;
import com.eshore.action.shoppingcart.EditShoppingCartAction;
import com.eshore.action.shoppingcart.InsertShoppingCartAction;
import com.eshore.action.shoppingcart.PaidAllAction;
import com.eshore.action.shoppingcart.PayAction;
import com.eshore.action.shoppingcart.PayGoodAction;
import com.eshore.action.shoppingcart.ShowPaidAction;
import com.eshore.action.shoppingcart.ShowShoppingcartAction;

/*@WebServlet(
	urlPatterns = { "/shoppingcart" }, 
	name = "shoppingCartServlet" 
)*/
public class ShoppingCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uids = String.valueOf(request.getSession().getAttribute("uid"));
		String action = String.valueOf(request.getParameter("action"));
		Action targetAction =null;
		String path = null;
		try{
			if (uids == null || uids.equals("null")) {
				path = "login.jsp";
			} else {
				if (action.equals("deletebus")) {//删除购物车
					targetAction = new DeletShoppingCartAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("good")) {//点击立即购买
					targetAction = new PayGoodAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("pay")) {//支付表单处理
					targetAction = new PayAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("intobus")) {//点击加入购物车时处理
					targetAction = new InsertShoppingCartAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("lookbus")) {//查看购物车 
					targetAction = new ShowShoppingcartAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("editbus")) {//修改购物车（商品数量）
					targetAction = new EditShoppingCartAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("deleteall")) {//删除购物车所有商品
					targetAction = new DeleteallAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("paid")) {//查看已支付的商品
					targetAction = new ShowPaidAction();
					path=targetAction.execute(request, response);
				}else if(action.equals("payall")){//支付所有商品
					targetAction = new PaidAllAction();
					path=targetAction.execute(request, response);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(path!=null){
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
