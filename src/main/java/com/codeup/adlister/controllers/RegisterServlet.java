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
        // validate input
        boolean inputHasErrors = username.isEmpty()

                || email.isEmpty()
                || password.isEmpty()
                || (!password.equals(passwordConfirmation));

//TODO: Display error messages to user based on various input errors

        if (inputHasErrors) {
            if (!password.equals(passwordConfirmation)) {
                request.setAttribute("error", "Passwords do not match");
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else if (username.isEmpty()) {
                request.setAttribute("error", "Your username field is empty");
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else if (email.isEmpty()) {
                request.setAttribute("error", "Your email field is empty");
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else if (password.isEmpty()) {
                request.setAttribute("error", "Your password field is empty");
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        }


//TODO: duplicate email

//TODO: Ensure usernames are unique. Change your database schema to enforce
// that values in the username column of the user table are unique. Make sure
// a new account cannot be created with an existing username.
// -----------------------------------------------------------------------
// Below is the code to display an error message if the entered username is already taken


        // create and save a new user
        User user = new User(username, email, password);
        try {
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        } catch (RuntimeException e) {
            e.printStackTrace();
            request.setAttribute("error", "That username is already taken! Please pick another one.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

    }
}