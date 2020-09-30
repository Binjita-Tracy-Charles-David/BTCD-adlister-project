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
import java.util.function.DoubleToIntFunction;

@WebServlet(name = "controllers.DeleteServlet", urlPatterns = "/ads/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

//        deleting ads with the id
        try {
            DaoFactory.getAdsDao().delete(Long.valueOf(request.getParameter("id")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/profile");
    }


}
