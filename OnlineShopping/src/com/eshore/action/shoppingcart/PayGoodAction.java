package com.eshore.action.shoppingcart;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Goods;

public class PayGoodAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取商品的ID
		int gid = Integer.parseInt(String.valueOf(request
				.getParameter("gid")));
		//获取商品的数量
		int number = Integer.parseInt(String.valueOf(request
				.getParameter("number")));
		try{
			Goods good=new Goods(); 
			//获得指定的商品
			Vector<Goods> gVector=DAOFactory.getGoodDAOInstance().
					queryGoodBySid(Integer.valueOf(gid));
			if(gVector.size()>0&&gVector!=null)
				good =(Goods)gVector.get(0); 
			//向页面传送参数good值
			request.setAttribute("good", good);
			//向页面传送number值
			request.setAttribute("number", number);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "shoppingcart/pay.jsp";
	}

}
