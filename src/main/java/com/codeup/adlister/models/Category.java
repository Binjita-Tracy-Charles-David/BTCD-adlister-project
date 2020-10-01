package com.codeup.adlister.models;

public class Category {
    private int id;
    private String name;

    public Category(String category){}

    public Category(int id, String cat_name) {
        this.id = id;
        this.name = cat_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCat_name() {
        return name;
    }

    public void setCat_name(String cat_name) {
        this.name = cat_name;
    }
}