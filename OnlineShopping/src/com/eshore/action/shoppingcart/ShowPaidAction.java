package com.eshore.action.shoppingcart;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Goods;
import com.eshore.pojo.Purchase;
import com.eshore.pojo.TempGoods;
import com.eshore.tag.PageObject;

public class ShowPaidAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Vector tempVector = new Vector();
		//获取登录用户的ID
		String uids = String.valueOf(request.getSession().getAttribute("uid"));
		int uid = Integer.parseInt(uids);
		//获取分页对象PageObject
		PageObject pageObject = PageObject.getInstance(request);
		try{
			//获取该用户已经支付的购物车列表
			Vector<Purchase> purchaseVector = DAOFactory.getPurchaseDAOInstance().
				getPurchasedGoods(uids);
			//遍历购物车列表
			for (int i = 0; i < purchaseVector.size(); i++) {
				Purchase p = new Purchase();
				p = (Purchase) purchaseVector.get(i);
				Goods good=new Goods();
				TempGoods tempGoods = new TempGoods();
				Vector<Goods> gVector=DAOFactory.getGoodDAOInstance().
					queryGoodBySid(p.getGid());//获取指定商品
				if(gVector.size()>0&&gVector!=null)
					good =(Goods)gVector.get(0); 
				//设置TempGoods对象值
				tempGoods.setGood(good);
				tempGoods.setNumber(p.getCount());
				tempVector.add(tempGoods);
			}
			String curPage = request.getParameter("curPage");//获取当前页
			pageObject = DAOFactory.getGoodDAOInstance().//向页面传送分页内容
				getPageObject(curPage, pageObject, tempVector);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("pageObject", pageObject);
		return  "shoppingcart/paidbus.jsp";
	}

}
