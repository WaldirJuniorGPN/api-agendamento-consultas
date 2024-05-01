CREATE TABLE addresses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    input_date TIMESTAMP,
    update_date TIMESTAMP,
    street VARCHAR(255),
    number VARCHAR(255),
    complement VARCHAR(255),
    neighborhood VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip_code VARCHAR(255)
);

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    input_date TIMESTAMP,
    update_date TIMESTAMP,
    name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    role VARCHAR(255)
);

CREATE TABLE assistants (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    input_date TIMESTAMP,
    update_date TIMESTAMP,
    name VARCHAR(255),
    user_id BIGINT,
    address_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);