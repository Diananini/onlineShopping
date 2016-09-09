package com.eshore.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.good.AddGoodAction;
import com.eshore.action.good.DeletGoodAction;
import com.eshore.action.good.DeleteKindsAction;
import com.eshore.action.good.ShowKindsAction;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Goods;

/**
 * 商品的Servlet类
 */
/*@WebServlet(
	urlPatterns = { "/goods" }, 
	name = "goodsServlet" 
)*/
public class GoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断action类型
		String action=request.getParameter("action");
		String path=null;
		Vector<Goods> gVector=new Vector<Goods>();
		Action targetAction =null;
		
		try{
			if(action.equals("index-select")){//查询商品列表
				String keyWord=request.getParameter("keyWord");//获取查询的输入值
				String keyClass=request.getParameter("keyClass");//获取查询类别
				gVector=DAOFactory.getGoodDAOInstance().//获得所有商品
					queryAll(keyWord, keyClass);
				request.setAttribute("goods", gVector);
				path="goods/goodslist.jsp";
			}else if(action.equals("goodslist-select")){//指定商品列表
				Goods good=new Goods();
				String sid=request.getParameter("sid");//获得商品的id
				gVector=DAOFactory.getGoodDAOInstance().//获得指定的商品对象
					queryGoodBySid(Integer.valueOf(sid));
				if(gVector.size()>0&&gVector!=null)
					good =(Goods)gVector.get(0); 
				request.setAttribute("good", good);
				path="goods/good.jsp";
			}else{
				if(action.equals("addGood")){//添加商品
					targetAction = new AddGoodAction();
					path=targetAction.execute(request, response);
				}else{
					if(action.equals("deleteGood")){//删除商品
						targetAction = new DeletGoodAction();
						path=targetAction.execute(request, response);
					}else{
						if(action.equals("showKinds")){//查看商品类
							targetAction = new ShowKindsAction();
							path=targetAction.execute(request, response);
						}else{
							if(action.equals("deleteKinds")){//删除商品类
								targetAction = new DeleteKindsAction();
								path=targetAction.execute(request, response);
							}
						}
					}
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
