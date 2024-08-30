package com.flower.controller;

import com.flower.entity.Flower;
import com.flower.repository.FlowerRepository;
import com.flower.service.FlowerService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/flower/flower")
public class RefractFlowerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        FlowerService flowerService = new FlowerService(new FlowerRepository());
        String id_flower = req.getParameter("id_flower");
        try {
            Flower flower = flowerService.getFlowerData(Long.valueOf(id_flower));
            req.setAttribute("name", flower.getName());
            req.setAttribute("description", flower.getName());
            req.getServletContext().getRequestDispatcher("/user.jsp").forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, NumberFormatException {
        FlowerService flowerService = new FlowerService(new FlowerRepository());
        String action = req.getParameter("action");
        try {
            String id_flower = req.getParameter("id_flower");
            String name = req.getParameter("name");
            String description = req.getParameter("description");

            if (action != null) {
                if (action.equals("change")) {
                    flowerService.changeFlowerData(Long.valueOf(id_flower), name, description);
                    resp.sendRedirect(req.getContextPath() + "/flower/data");
                } else if (action.equals("delete")) {
                    flowerService.deleteFlowerData(Long.valueOf(id_flower));
                    resp.sendRedirect(req.getContextPath() + "/flower/data");
                }
            }
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
