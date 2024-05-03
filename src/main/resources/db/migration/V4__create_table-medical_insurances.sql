CREATE TABLE medical_insurances (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    input_date TIMESTAMP,
    update_date TIMESTAMP,
    name VARCHAR(255) NOT NULL ,
    cnpj VARCHAR(255) NOT NULL UNIQUE
);