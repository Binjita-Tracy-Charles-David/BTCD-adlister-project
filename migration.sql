USE adlister_db;
DROP TABLE IF EXISTS ads_categories;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
# TODO: Create a categories table and implement all the backend logic necessary to tie a category to an ad. This should be a many to many relationship (an ad can have many categories, and a category can have many ads associated with it).
# In addition, allow users to search through ads by category.
CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(240) NOT NULL UNIQUE,
                       email VARCHAR(240) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id)
);
CREATE TABLE ads (
                     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                     user_id INT UNSIGNED NOT NULL,
                     title VARCHAR(240) NOT NULL,
                     description TEXT NOT NULL,
                     PRIMARY KEY (id),
                     FOREIGN KEY (user_id) REFERENCES users(id)
                         ON DELETE CASCADE
);
CREATE TABLE categories (
                            id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                            cat_name VARCHAR(240) NOT NULL,
                            PRIMARY KEY (id)
);
CREATE TABLE ads_categories (
                                ads_id INT UNSIGNED NOT NULL,
                                cat_id INT UNSIGNED NOT NULL,
                                FOREIGN KEY (ads_id) REFERENCES ads(id),
                                FOREIGN KEY (cat_id) REFERENCES categories(id)
);


