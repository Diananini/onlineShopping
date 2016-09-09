package com.eshore.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/*@WebFilter(
		description = "登录过滤", 
		filterName = "loginFilter", 
		urlPatterns = { "/user/*","/shoppingcart/*" }
	)*/
public class LoginFilter implements Filter {

	private static Logger log = Logger.getLogger("LoginFilter");
	private String filterName="";//过滤器名称
	public void destroy() {
		log.debug("请求销毁");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		log.debug("请求被"+filterName+"过滤");
		String uname =(String) request.getSession().getAttribute("uname");
		System.out.println("过滤器name:"+uname);
		//请求过滤，如果用户为空，返回登录页面
		if (uname == null) {
			request.setAttribute("status", "请先登录");
			request.getRequestDispatcher("/login.jsp")
			.forward(request, response);
		} else {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//通过filterConfig获得初始化中过滤器名称
		filterName = filterConfig.getFilterName();
		log.debug("获得过滤名称");
	}

}
