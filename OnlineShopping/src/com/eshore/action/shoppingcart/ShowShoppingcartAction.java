package com.eshore.action.shoppingcart;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Goods;
import com.eshore.pojo.ShoppingCartGoods;
import com.eshore.pojo.TempGoods;
import com.eshore.tag.PageObject;

public class ShowShoppingcartAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//新建TempGoods对象
		Vector tempVector = new Vector();
		//获取登录用户的ID
		String uids = String.valueOf(request.getSession().getAttribute("uid"));
		int uid = Integer.parseInt(uids);
		float countPrice = 0.0f;
		PageObject pageObject = PageObject.getInstance(request);
		try{
			//获取用户的购物车列表
			Vector<ShoppingCartGoods> busVector = DAOFactory.getShoppingCartDAOInstance().
			getAllSCGoods(uid);
			for (int i = 0; i < busVector.size(); i++) {
				ShoppingCartGoods cartGood = new ShoppingCartGoods();
				cartGood = (ShoppingCartGoods) busVector.get(i);//获取购物车中的一个商品
				Goods good=new Goods();
				TempGoods tempGoods = new TempGoods();
				good.setGid(cartGood.getGid());
				good.setGname(cartGood.getGname());//设定商品名称
				good.setGphoto(cartGood.getGphoto());//设定商品照片
				good.setKinds(cartGood.getKinds());//设定商品类别
				good.setTypes(cartGood.getTypes());//设定商品型号
				good.setProducer(cartGood.getProducer());//设定商品生产者
				good.setPrice(cartGood.getPrice());//设定商品价格
				good.setCarriage(cartGood.getCarriage());//设定商品运费
				good.setPdate(cartGood.getPdate());//设定商品生产日期
				good.setPaddress(cartGood.getPaddress());//设定商品生产地址
				good.setDescribed(cartGood.getDescribed());//设定商品描述
				//组合TempGoods对象
				tempGoods.setGood(good);
				tempGoods.setNumber(cartGood.getNumber());
				tempVector.add(tempGoods);
				countPrice+=cartGood.getNumber()*good.getPrice();//计算价格
			}
			String curPage = request.getParameter("curPage");//获取当前页
			pageObject = DAOFactory.getGoodDAOInstance().//向页面传送分页内容
				getPageObject(curPage, pageObject, tempVector);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("goods", tempVector);
		request.setAttribute("countPrice",countPrice);
		return "shoppingcart/bus.jsp";
	}
}
