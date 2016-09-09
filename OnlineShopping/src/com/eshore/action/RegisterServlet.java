package com.eshore.action;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eshore.factory.DAOFactory;
import com.eshore.pojo.CommonUsers;
import com.eshore.pojo.Users;

/*@WebServlet(
	urlPatterns = { "/register" }, 
	name = "registerServlet" 
)*/
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求者的ip
		String ip = request.getHeader("x-forwarded-for"); 
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		ip = request.getHeader("Proxy-Client-IP"); 
		} 
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		ip = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		ip = request.getRemoteAddr(); 
		} 
		//获取页面参数，包括用户名密码邮箱
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		String gender=request.getParameter("gender");
		String phone = request.getParameter("phone");
		String path = null;
		//为用户设定属性值
		Users user = new Users();
		user.setUname(uname);
		user.setPasswd(passwd);
		user.setGender(gender);
		user.setPhone(phone);
		CommonUsers commonUser=new CommonUsers();
		commonUser.setIp(ip);
		//commonUser.setIp((String)request.getSession().getAttribute("ip"));
		commonUser.setUright(0);
		try{
			if (DAOFactory.getUserDAOInstance().
					queryByName(uname).getUid() == 0
					&&DAOFactory.getManagerDAOInstance().
						queryByName(uname).getManagerId()==0) {// 用户名可用
				if (DAOFactory.getUserDAOInstance().
						queryByPhone(phone).getUid() == 0) {// 电话可用
					if (DAOFactory.getCommonUserDAOInstance().queryByIp(commonUser.getIp()).getUright()==1){
						if(DAOFactory.getCommonUserDAOInstance().addUser(commonUser) == 1){
							user.setUid(DAOFactory.getCommonUserDAOInstance().latestAdded().getUid());
							if(DAOFactory.getUserDAOInstance().addUser(user) == 1) {
								request.getSession().setAttribute("uname", uname);
								request.getSession().setAttribute("uid",
										DAOFactory.getUserDAOInstance().queryByName(uname).getUid());
								path = "index.jsp";
								request.setAttribute("status", "恭喜您，注册成功！");
							}else {
								path = "register.jsp";
								request.setAttribute("status", "注册失败，请重试……");
							}
						}else {
							path = "register.jsp";
							request.setAttribute("status", "注册失败，请重试……");
						}
					} else {//此ip还未注册任何用户，则修改commonUser的权限，并向注册用户表Users中插入新元组
						if(DAOFactory.getCommonUserDAOInstance().updateByIp(commonUser.getIp())==1){
							user.setUid(DAOFactory.getCommonUserDAOInstance().queryByIp(commonUser.getIp()).getUid());
							if(DAOFactory.getUserDAOInstance().addUser(user) == 1) {
								request.getSession().setAttribute("uname", uname);
								request.getSession().setAttribute("uid",
										DAOFactory.getUserDAOInstance().queryByName(uname).getUid());
								path = "index.jsp";
								request.setAttribute("status", "恭喜您，注册成功！");
							}else {
								path = "register.jsp";
								request.setAttribute("status", "注册失败，请重试……");
							}
						}
					}
				} else {
					path = "register.jsp";
					request.setAttribute("status", "电话号码重复！");
				}
			}else{
				path = "register.jsp";
				request.setAttribute("status", "用户名已被注册");
			}
		}catch(Exception e){
			if(e.getMessage().equals("gender illegal")){//由于性别输入不合法而注册失败
				path = "register.jsp";
				request.setAttribute("status", "！！请输入合法的性别：男-M，女-F！！");
			}else{ 
				if(e.getMessage().equals("password is short")){//由于性别输入不合法而注册失败
					path = "register.jsp";
					request.setAttribute("status", "！！密码长度要大于5个字符！！");
			}else{
				e.printStackTrace();
			}
			}
		}
		if(path!=null)
			request.getRequestDispatcher(path).forward(request, response);
	}
}
