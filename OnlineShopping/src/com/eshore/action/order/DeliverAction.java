package com.eshore.action.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;

public class DeliverAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String order_ids = String.valueOf(request.getParameter("orderId"));
		int order_id = Integer.parseInt(order_ids);
		try{
			if (DAOFactory.getOrderDAOInstance().
					processOrder(order_id, 1) == 1) {
				request.setAttribute("status", "已发货");
			} else {//操作失败
				request.setAttribute("status", "发货失败，请重试");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "order?action=allNotDelivered";
	}
}
