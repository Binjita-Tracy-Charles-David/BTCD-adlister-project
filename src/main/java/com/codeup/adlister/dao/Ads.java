package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all() throws SQLException;
    // insert a new ad and return the new ad's id
    Long insert(Ad ad) ;

//    deleting ads from profile page
    void delete(Long id) throws SQLException;

//    updating ads
    void update(Long id) throws  SQLException;
    void update(Ad ad) throws  SQLException;


}
