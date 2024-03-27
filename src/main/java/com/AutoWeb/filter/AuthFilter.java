package com.AutoWeb.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.AutoWeb.entities.User;
//
//
//@WebFilter(urlPatterns = {
//"*.jsp", "*.html", 		
//})
//public class AuthFilter implements Filter {
//	User user = new User();
//	
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletResponse response = (HttpServletResponse) res;
//		HttpServletRequest request = (HttpServletRequest) req;
//		
//		
//		if (user.() == null && !request.getRequestURI().endsWith("/signin.html")
//				&& !request.getRequestURI().contains("/javax.faces.resource/")) {
//			response.sendRedirect(request.getContextPath() + "/login.html");
//		} else {
//			chain.doFilter(req, res);
//		}
//		
//	}
//
//	@Override
//	public void init(FilterConfig config) throws ServletException {
//	}
//
//	@Override
//	public void destroy() {
//	}
//
//}


