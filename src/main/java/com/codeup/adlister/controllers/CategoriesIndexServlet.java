package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CategoriesIndexServlet", urlPatterns = "/categories")
public class CategoriesIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF//categories/index.jsp").forward(request, response);

        if (request.getSession().getAttribute("user") == null){
            request.getSession().setAttribute("redirect", "/categories");
            return;
        }
    }
}