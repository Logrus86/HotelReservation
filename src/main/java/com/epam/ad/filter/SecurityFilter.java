package com.epam.ad.filter;

import com.epam.ad.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;


public class SecurityFilter implements Filter {

    Map<String, String> pageRoles;



    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {
        pageRoles.put("admin", "ADMIN");
        pageRoles.put("user", "ADMIN");


    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        doFilter0((HttpServletRequest) req, (HttpServletResponse) resp, chain);
    }

    private void doFilter0(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        user.getRole();



    }

}
