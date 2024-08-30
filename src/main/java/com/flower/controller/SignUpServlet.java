package com.flower.controller;

import com.flower.entity.Profile;
import com.flower.service.SignUpService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sign_up")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign_up.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignUpService signUpService = new SignUpService();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Profile profile = signUpService.registerProfile(login, password);
        HttpSession session = req.getSession(true);
        session.setAttribute("person", profile);
        resp.sendRedirect(req.getContextPath() + "/flower/data");
    }
}
