package com.codeup.adlister.config;

public class Config {
    public String getUrl() {
        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    }
    public String getUser() {
        return "root";
    }
    public String getPassword() {
        return "mysql92929";
    }
}