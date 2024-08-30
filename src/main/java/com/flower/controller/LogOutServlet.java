package com.flower.controller;

import com.flower.entity.Profile;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.var;

import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession(true);
        Profile profile = (Profile) session.getAttribute("profile");

        if (profile != null) {
            session.removeAttribute("profile");
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
