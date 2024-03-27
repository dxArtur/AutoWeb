package com.AutoWeb.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AutoWeb.entities.User;

import java.io.IOException;

@WebFilter("/adminAccess")
public class AdminAccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");    
            if (user.getIsAdmin()) {
                chain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/acessoNegado.jsp").forward(request, response);
            }
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/LoginServlet");   
        }
    }

    @Override
    public void destroy() {
    	
    }
}
