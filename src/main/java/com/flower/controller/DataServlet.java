package com.flower.controller;

import com.flower.entity.Profile;
import com.flower.repository.FlowerRepository;
import com.flower.service.FlowerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/flower/data")
public class DataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Profile profile = (Profile) req.getSession().getAttribute("profile");
        req.setAttribute("id", profile.getId());
        req.getServletContext().getRequestDispatcher("/data.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FlowerService flowerService = new FlowerService(new FlowerRepository());
        String id = req.getParameter("id_flower");
        if (!id.isEmpty() && flowerService.isFlowerExists(Long.valueOf(id))) {
            resp.sendRedirect(req.getContextPath()+"/flower/flower?id_flower=" + id);
        } else {
            resp.sendRedirect(req.getContextPath()+"/flower/data");
        }
    }
}
