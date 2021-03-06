package com.codeup.adlister.dao;

import com.codeup.adlister.config.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;


public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    public User getUserById(long id) throws SQLException {
        String UserQuery = "SELECT * FROM users where id=?";
        PreparedStatement stmt3 = connection.prepareStatement(UserQuery);
        stmt3.setLong(1, id);
        ResultSet rs = stmt3.executeQuery();
        return new User(
                rs.getString("id"),
                rs.getString("username"),
                rs.getString("email")
        );

    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    @Override
    public void update (User user) throws SQLException {
        String updateQuery = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
        PreparedStatement stmt2 = connection.prepareStatement(updateQuery);
        stmt2.setString(1, user.getUsername());
        stmt2.setString(2, user.getEmail());
        stmt2.setString(3, user.getPassword());
        stmt2.setLong(4,user.getId());

        stmt2.executeUpdate();

    }


    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }
}
