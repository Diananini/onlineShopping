package com.eshore.action.order;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Order;
import com.eshore.tag.PageObject;


public class ShowReceivedAction implements Action{
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//新建TempGoods对象
		Vector orderVector = new Vector();
		//获取登录用户的ID
		String uids = String.valueOf(request.getSession().getAttribute("uid"));
		int uid = Integer.parseInt(uids);
		PageObject pageObject = PageObject.getInstance(request);
		try{
			//获取用户的所有未支付的购物车列表
			orderVector = DAOFactory.getOrderDAOInstance().queryDelivery(uid, 2);
			String curPage = request.getParameter("curPage");//获取当前页
			pageObject = DAOFactory.getGoodDAOInstance().//向页面传送分页内容
				getPageObject(curPage, pageObject, orderVector);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("orders", orderVector);
		return "order/received.jsp";
	}

}
