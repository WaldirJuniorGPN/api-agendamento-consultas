CREATE TABLE addresses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    input_date TIMESTAMP,
    update_date TIMESTAMP,
    street VARCHAR(255),
    number VARCHAR(255),
    complement VARCHAR(255),
    neighborhood VARCHAR(255),
    city VARCHAR(255) NOT NULL ,
    state VARCHAR(255) NOT NULL ,
    zip_code VARCHAR(255) NOT NULL
);

CREATE TABLE users (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   input_date TIMESTAMP,
   update_date TIMESTAMP,
   name VARCHAR(255) NOT NULL ,
   password VARCHAR(255) NOT NULL ,
   email VARCHAR(255) NOT NULL UNIQUE,
   role VARCHAR(255),
   cpf VARCHAR(255) NOT NULL UNIQUE,
   phone VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE assistants (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    input_date TIMESTAMP,
    update_date TIMESTAMP,
    user_id BIGINT,
    address_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);