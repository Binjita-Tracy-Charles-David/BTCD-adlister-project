package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.UpdateServlet", urlPatterns = "/ads/update")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        Long adId = Long.valueOf(request.getParameter("id"));
        request.setAttribute("adId", adId);
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request,response);

//        updating ads with the id
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        try {
//            creating variable to updating title and description
            String title = (String) request.getParameter("title");
            String Description = (String) request.getParameter("description");
            Long userid = ((User) request.getSession().getAttribute("user")).getId();
            Long adId = Long.valueOf((String) request.getParameter("id"));

            Ad ad = new Ad(adId,userid, title, Description);

            DaoFactory.getAdsDao().update(ad);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/profile");
    }
}
