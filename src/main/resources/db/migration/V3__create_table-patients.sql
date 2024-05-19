CREATE TABLE IF NOT EXISTS patients (
      id BIGINT PRIMARY KEY AUTO_INCREMENT,
      input_date TIMESTAMP,
      update_date TIMESTAMP,
      birth_date DATE,
      user_id BIGINT,
      address_id BIGINT,
      FOREIGN KEY (user_id) REFERENCES users(id),
      FOREIGN KEY (address_id) REFERENCES addresses(id)
);