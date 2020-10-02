package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.CategoriesIndexServlet", urlPatterns = "/categories")
public class CategoriesIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/categories/index.jsp").forward(request, response);

        if (request.getSession().getAttribute("user") == null){
            request.getSession().setAttribute("redirect", "/categories");
            return;
        }
    }
}