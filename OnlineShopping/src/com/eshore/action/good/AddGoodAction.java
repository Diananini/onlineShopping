package com.eshore.action.good;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;
import com.eshore.pojo.Goods;

public class AddGoodAction implements Action {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Goods good = new Goods();
		//获取商品名称
		good.setGname(request.getParameter("gname"));
		//获取商品种类
		good.setKinds(request.getParameter("kinds"));
		//获取商品图路径
		good.setGphoto(request.getParameter("gphoto"));
		//获取商品型号
		good.setTypes(request.getParameter("types"));
		//获取商品生产厂家
		good.setProducer(request.getParameter("producer"));
		//获取商品单价
		good.setPrice(Float.parseFloat(String.valueOf(request.getParameter("price"))));
		//获取商品邮费
		good.setCarriage(Float.parseFloat(String.valueOf(request.getParameter("carriage"))));
		//获取商品生产日期
		good.setPdate(request.getParameter("pdate"));
		//获取商品厂家地址
		good.setPaddress(request.getParameter("paddress"));
		//获取商品描述
		good.setDescribed(request.getParameter("described"));
		try{
			if (DAOFactory.getGoodDAOInstance().addGood(good)==1) {
				request.setAttribute("status", "添加商品成功！");
			} else {
				request.setAttribute("status", "添加失败，请重试！");
			}
		}catch(Exception e){
			if(e.getMessage().equals("kind can not be null")){
				request.setAttribute("status", "所添加商品的所属分类为空！！更新分类信息失败！！");
				return "goods?action=showKinds";
			}
			e.printStackTrace();
		}
		
		return "goods?action=showKinds";
	}
}
