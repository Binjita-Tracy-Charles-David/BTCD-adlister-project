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

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            request.getSession().setAttribute("redirect", "/ads/create");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //TODO: Display error to user if ad title field is empty
        String title = request.getParameter("title");

        if (title.isEmpty()){
            request.setAttribute("error", "You cannot leave the title field empty!");
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
        }

        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        if(!title.isEmpty()){
            DaoFactory.getAdsDao().insert(ad);
        }
        response.sendRedirect("/ads");
    }
}
