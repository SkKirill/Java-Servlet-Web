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

@WebServlet("/flower/add")
public class AddFlowerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addNewFlower(req, resp);
    }

    private void addNewFlower(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        FlowerService flowerService = new FlowerService(new FlowerRepository());
        Profile profile = (Profile) req.getSession().getAttribute("profile");

        String new_name = req.getParameter("new_name");
        String new_description = req.getParameter("new_description");
        String profileId = String.valueOf(profile.getId());
        try {
             if (!new_name.isEmpty()){
                flowerService.addNewFlower(Long.valueOf(profileId), new_name, new_description);
                resp.sendRedirect(getServletContext().getContextPath() + "/flower/data");
            } else resp.sendRedirect(getServletContext().getContextPath() + "/flower/data");
        } catch (Exception e){
            resp.sendRedirect(getServletContext().getContextPath() + "/flower/data");
        }
    }
}
