package com.eshore.action.order;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.tag.PageObject;


public class ShowAllDeliveredAction implements Action{
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//新建TempGoods对象
		Vector orderVector = new Vector();

		PageObject pageObject = PageObject.getInstance(request);
		try{
			//获取用户的所有已发货订单
			orderVector = DAOFactory.getOrderDAOInstance().queryByStatus(1);
			String curPage = request.getParameter("curPage");//获取当前页
			pageObject = DAOFactory.getGoodDAOInstance().//向页面传送分页内容
				getPageObject(curPage, pageObject, orderVector);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("orders", orderVector);
		return "order/allDelivered.jsp";
	}

}
