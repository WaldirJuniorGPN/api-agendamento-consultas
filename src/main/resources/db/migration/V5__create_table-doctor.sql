CREATE TABLE IF NOT EXISTS doctors (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    input_date TIMESTAMP,
    update_date TIMESTAMP,
    crm VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(255) NOT NULL UNIQUE,
    user_id BIGINT,
    address_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE IF NOT EXISTS schedules (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    input_date TIMESTAMP,
    update_date TIMESTAMP,
    doctor_id BIGINT,
    start_working_hours TIME,
    end_working_hours TIME,
    start_lunch_hours TIME,
    end_lunch_hours TIME,
    working_days ENUM('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY'),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);

CREATE TABLE IF NOT EXISTS doctors_specialties (
    doctor_id BIGINT,
    specialty_id BIGINT,
    PRIMARY KEY (doctor_id, specialty_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    FOREIGN KEY (specialty_id) REFERENCES specialties(id)
);

CREATE TABLE IF NOT EXISTS doctors_medical_insurances (
    doctor_id BIGINT,
    medical_insurance_id BIGINT,
    PRIMARY KEY (doctor_id, medical_insurance_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    FOREIGN KEY (medical_insurance_id) REFERENCES medical_insurances(id)
);