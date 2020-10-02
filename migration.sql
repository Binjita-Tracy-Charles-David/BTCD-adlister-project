USE adlister_db;

DROP TABLE IF EXISTS ads_categories;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;


#TODO: Ensure usernames are unique. Change your database schema to enforce
# that values in the username column of the user table are unique. Make sure
# a new account cannot be created with an existing username.
# -------------------------------------------------------------------------
# It may be a good idea to add 'UNIQUE' requirement to 'email' as well,
# as this is standard practice on most of the internet

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
    name VARCHAR(240) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads_categories (
    ads_id INT UNSIGNED NOT NULL,
    cat_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ads_id) REFERENCES ads(id),
    FOREIGN KEY (cat_id) REFERENCES categories(id)
);

INSERT INTO categories (name) VALUES
('gaming'),
('outdoors'),
('computers'),
('phones'),
('jobs'),
('services'),
('cars'),
('furniture'),
('clothing'),
('other');