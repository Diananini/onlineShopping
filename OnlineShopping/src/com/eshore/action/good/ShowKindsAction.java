package com.eshore.action.good;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Goods;
import com.eshore.pojo.Kinds;
import com.eshore.pojo.ShoppingCartGoods;
import com.eshore.pojo.TempGoods;
import com.eshore.tag.PageObject;

public class ShowKindsAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//新建TempGoods对象
		Vector tempVector = new Vector();
		
		PageObject pageObject = PageObject.getInstance(request);
		try{
			//获取用户的购物车列表
			Vector<Kinds> kindVector = DAOFactory.getGoodDAOInstance().queryAllKinds();
			tempVector=kindVector;
			String curPage = request.getParameter("curPage");//获取当前页
			pageObject = DAOFactory.getGoodDAOInstance().//向页面传送分页内容
				getPageObject(curPage, pageObject, tempVector);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("kinds", tempVector);
		return "goods/kinds.jsp";
	}
}
