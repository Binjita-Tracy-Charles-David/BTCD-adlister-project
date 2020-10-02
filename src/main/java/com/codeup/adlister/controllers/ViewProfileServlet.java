package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        } else {
            //set attributes to display user-accessible pages on navbar
            request.getSession().setAttribute("profile", "/profile");
            request.getSession().setAttribute("viewProfile", "View Profile");
            request.getSession().setAttribute("create", "/ads/create");
            request.getSession().setAttribute("createAd", "Create Ad");
        }



        //Show user's ads on their profile page
        try {
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }


}
