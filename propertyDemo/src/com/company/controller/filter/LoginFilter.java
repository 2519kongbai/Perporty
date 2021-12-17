package com.company.controller.filter;

import com.company.comm.Const;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/building")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        if(session.getAttribute(Const.CURRENT_USER) != null) {
            chain.doFilter(request, response);
        }else{
            request.getRequestDispatcher("/index.html").forward(request,response);
        }
    }
}
