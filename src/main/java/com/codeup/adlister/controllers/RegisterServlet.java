package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        String errorMessage = "sdfasdf";

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));



        if (inputHasErrors) {
            response.sendRedirect("/register");
            if (!password.equals(passwordConfirmation)) {
                errorMessage = "Passwords do not match.";
            }
            return;
        }

        // pass the value of the errorMessage variable to the view, and send the request - "variable name", value
        // forward to the messages.jsp file
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("../WEB-INF/partials/messages.jsp").forward(request, response);


        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
