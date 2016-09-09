package com.eshore.action.shoppingcart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Addr;
import com.eshore.pojo.Correspond;
import com.eshore.pojo.Order;
import com.eshore.pojo.Purchase;

public class PayAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//获得参数flag标识
		String flag = request.getParameter("flag");
		//获取登录用户的ID
		String uids = String.valueOf(request.getSession().getAttribute("uid"));
		int uid = Integer.parseInt(uids);
		if(flag!=null){
			if(flag.equals("pay")){//支付全部
				/*String shopcartId = request.getParameter("shopcartId");//获得所有购物车的ID
				try{
					if (DAOFactory.getPurchaseDAOInstance().
							addPurchases(shopcartId) != 0
							&&DAOFactory.getShoppingCartDAOInstance().deleteAll(uid)==1) {
										//添加购物信息并从购物车中删除
						request.setAttribute("status", "交易成功!您可以继续选购宝贝。");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{*/
				//支付单个商品
				int gid = Integer.parseInt(String.valueOf(request
						.getParameter("gid")));//获得商品的ID
				int number = Integer.parseInt(String.valueOf(request
						.getParameter("number")));//获得购买商品的数量
				String province=request.getParameter("province");
				String city=request.getParameter("city");
				String town=request.getParameter("town");
				String addr0=province+city+town;
				
				Purchase p=new Purchase();
				p.setUid(uid);
				p.setGid(gid);
				p.setcount(number);
				p.setUnitPrice(DAOFactory.getGoodDAOInstance().queryGoodBySid(gid).firstElement().getPrice());
				p.setUnitCarriage(DAOFactory.getGoodDAOInstance().queryGoodBySid(gid).firstElement().getCarriage());
				p.setSumPrice(p.getUnitPrice()*p.getCount()+p.getUnitCarriage());
				
				Addr addr=new Addr();
				addr.setAddr(addr0);
				
				Correspond corr=new Correspond();
				corr.setAddr(addr0);
				corr.setUid(uid);
				
				String name=request.getParameter("name");
				Order order=new Order();
				order.setUid(uid);
				order.setReceiver(name);
				if(!addr0.equals("省份地级市市/县级市/县")){
					order.setUserAddr(addr0);
				}else{
					order.setUserAddr(request.getParameter("usedAddr"));
				}
				order.setMoney(p.getSumPrice());
				order.setOrderStatus(0);//设置订单状态，0代表未发货
				
				try{
					DAOFactory.getShoppingCartDAOInstance().deleteGoods(gid, uid);//若是在购物车中有，则删除
					if (DAOFactory.getPurchaseDAOInstance().addPurchase(p) == 1
							&&((!addr.equals("省份地级市市/县级市/县")&&DAOFactory.getAddrDAOInstance().addAddr(addr)==1
									&&DAOFactory.getCorrespondDAOInstance().addCorrespond(corr)==1)
									||addr.equals("省份地级市市/县级市/县"))
								&&DAOFactory.getOrderDAOInstance().addOrder(order)==1
							) {//添加已购买信息
						request.setAttribute("status", "交易成功!您可以继续选购宝贝");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return "index.jsp";
	}

}
