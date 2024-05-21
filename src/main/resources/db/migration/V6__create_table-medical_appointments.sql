CREATE TABLE IF NOT EXISTS medical_appointments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    input_date TIMESTAMP,
    update_date TIMESTAMP,
    date date NOT NULL,
    start_hour VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    medical_report TEXT,
    patient_id BIGINT,
    doctor_id BIGINT,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);