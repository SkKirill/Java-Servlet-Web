package com.flower.controller;

import com.flower.entity.Profile;
import com.flower.exception.EmptyInputDataException;
import com.flower.exception.InvalidLoginDataException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.flower.repository.ProfileRepository;
import com.flower.service.LogInService;

import java.io.IOException;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {

    private final LogInService logInService = new LogInService(new ProfileRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            Profile profile = logInService.LoginUser(login, password);
            req.getSession().setAttribute("profile", profile);
            resp.sendRedirect(req.getContextPath() + "/flower/data");
        } catch (InvalidLoginDataException | EmptyInputDataException e) {
            req.setAttribute("loginError", e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
