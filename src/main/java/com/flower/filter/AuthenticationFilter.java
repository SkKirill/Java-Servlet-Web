package com.flower.filter;

import com.flower.entity.Profile;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.var;

import java.io.IOException;

@WebFilter("/flower/*")
public class AuthenticationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        var session = req.getSession();
        Profile profile = (Profile) session.getAttribute("profile");
        if (profile == null) {
            res.sendRedirect(req.getContextPath() + "/login?authentication=false");
            return;
        }
        chain.doFilter(req, res);
    }
}