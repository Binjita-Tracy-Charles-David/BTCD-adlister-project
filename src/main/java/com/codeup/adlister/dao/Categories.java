package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface Categories {

    List<Category> all() throws SQLException;

    void insert(Category category);
}



