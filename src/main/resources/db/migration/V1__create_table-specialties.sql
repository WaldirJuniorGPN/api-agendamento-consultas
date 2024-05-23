CREATE TABLE IF NOT EXISTS specialties (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT,
    input_date TIMESTAMP,
    update_date TIMESTAMP
);