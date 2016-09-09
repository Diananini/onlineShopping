package com.eshore.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.order.DeleteAllOrdersAction;
import com.eshore.action.order.DeleteOrderAction;
import com.eshore.action.order.DeliverAction;
import com.eshore.action.order.ShowAllDeliveredAction;
import com.eshore.action.order.ShowAllNotDeliveredAction;
import com.eshore.action.order.ShowAllOrdersAction;
import com.eshore.action.order.ShowAllReceivedAction;
import com.eshore.action.order.ShowDeliveredAction;
import com.eshore.action.order.ShowNotDeliveredAction;
import com.eshore.action.order.ShowReceivedAction;
import com.eshore.action.order.SuccessAction;


public class OrderServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uids = String.valueOf(request.getSession().getAttribute("uid"));
		String manager_ids = String.valueOf(request.getSession().getAttribute("manager_id"));
		String action = String.valueOf(request.getParameter("action"));
		Action targetAction =null;
		String path = null;
		try{
			if ((uids == null || uids.equals("null"))&&(manager_ids == null || manager_ids.equals("null"))) {
				path = "login.jsp";
			} else {
				if (action.equals("allOder")) {//所有订单
					targetAction = new ShowAllOrdersAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("notDelivered")) {//待发货
					targetAction = new ShowNotDeliveredAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("delivered")) {//待收货
					targetAction = new ShowDeliveredAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("received")) {//交易成功
					targetAction = new ShowReceivedAction();
					path=targetAction.execute(request, response);			
				}else if (action.equals("deleteall")) {//删除订单
					targetAction = new DeleteAllOrdersAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("deleteorder")) {//删除订单
					targetAction = new DeleteOrderAction();
					path=targetAction.execute(request, response);	
				}else if (action.equals("allNotDelivered")) {//所有待发货
					targetAction = new ShowAllNotDeliveredAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("allDelivered")) {//所有待收货
					targetAction = new ShowAllDeliveredAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("allReceived")) {//所有交易成功
					targetAction = new ShowAllReceivedAction();
					path=targetAction.execute(request, response);			
				}else if (action.equals("deliver")) {//发货
					targetAction = new DeliverAction();
					path=targetAction.execute(request, response);
				}else if (action.equals("success")) {//用户收货，交易成功
					targetAction = new SuccessAction();
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
