package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.UserUpdateServlet", urlPatterns = "/users/update")
public class UserUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        Long userId = Long.valueOf(request.getParameter("id"));
        request.setAttribute("userId", userId);
        request.getRequestDispatcher("/WEB-INF/users/update.jsp").forward(request, response);


//        updating users with the id
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        try {
//            creating variable to update username, email and password

            Long id = ((User) request.getSession().getAttribute("user")).getId();
            String username = (String) request.getParameter("username");
            String email = (String) request.getParameter("email");
            String password = (String) request.getParameter("password");

            User user = new User(id, username, email, password);
            DaoFactory.getUsersDao().update(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/profile");
    }
}
