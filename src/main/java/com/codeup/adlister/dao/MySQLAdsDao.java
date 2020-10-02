package com.codeup.adlister.dao;

import com.codeup.adlister.config.Config;
import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() throws SQLException {
        List<Ad> ads = new ArrayList<>();
//        creating and executing
        Statement statement = connection.createStatement();
//        handling result sets
        ResultSet rs = statement.executeQuery("SELECT * FROM ads");
        while (rs.next()) { //return the next results(loop)
            Ad ad = new Ad(rs.getLong("id"),rs.getLong("user_id"), rs.getString("title")
                    ,rs.getString("description"));
            ads.add(ad);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
           if(rs.next()){
            System.out.println("Inserted a new Ads! New id: " + rs.getLong(1));
        }
        return ad.getId();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    //    for deleting the ads from profile page
    public void delete (Long id) throws SQLException {
        String deleteQuery = "DELETE FROM ads WHERE id = ?";
        PreparedStatement stmt1 = connection.prepareStatement(deleteQuery);
        stmt1.setLong(1, id);
        stmt1.execute();
    }


    // for updating the ads from the profile page
    public void update(Ad ad) throws SQLException {
        String updateQuery = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        PreparedStatement stmt2 = connection.prepareStatement(updateQuery);
        stmt2.setString(1, ad.getTitle());
        stmt2.setString(2, ad.getDescription());
        stmt2.setLong(3,ad.getId());
        stmt2.executeUpdate();

    }

//    for viewing the ads into indiviual links
    public void getAdById(Ad ad) throws SQLException {
        String updateQuery = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
    }


    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"));

    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
    @Override
    public void update(Long id) throws SQLException {

    }



}
