CREATE TABLE patients (
      id BIGINT PRIMARY KEY AUTO_INCREMENT,
      input_date TIMESTAMP,
      update_date TIMESTAMP,
      user_id BIGINT,
      address_id BIGINT,
      FOREIGN KEY (user_id) REFERENCES users(id),
      FOREIGN KEY (address_id) REFERENCES addresses(id)
);