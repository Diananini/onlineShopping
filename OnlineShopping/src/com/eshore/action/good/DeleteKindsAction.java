package com.eshore.action.good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.action.Action;
import com.eshore.factory.DAOFactory;

public class DeleteKindsAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String kinds = request.getParameter("kinds");
		
		try{
			if (DAOFactory.getGoodDAOInstance().deleteKinds(kinds)==1){
				request.setAttribute("status", "已删除"+kinds+"类商品");
			} else {//删除失败
				request.setAttribute("status", "删除"+kinds+"类商品操作失败，请重试");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "goods?action=showKinds";
	}

}
