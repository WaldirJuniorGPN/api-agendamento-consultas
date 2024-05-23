-- Criação de especialidades
INSERT INTO specialties (name, description, input_date) VALUES ('Cardiologia', 'Especialidade médica dedicada ao diagnóstico e tratamento de doenças do coração', CURRENT_TIMESTAMP);
INSERT INTO specialties (name, description, input_date) VALUES ('Dermatologia', 'Especialidade médica dedicada ao diagnóstico e tratamento de doenças da pele', CURRENT_TIMESTAMP);
INSERT INTO specialties (name, description, input_date) VALUES ('Endocrinologia', 'Especialidade médica dedicada ao diagnóstico e tratamento de doenças relacionadas aos hormônios', CURRENT_TIMESTAMP);
INSERT INTO specialties (name, description, input_date) VALUES ('Gastroenterologia', 'Especialidade médica dedicada ao diagnóstico e tratamento de doenças do sistema digestivo', CURRENT_TIMESTAMP);
INSERT INTO specialties (name, description, input_date) VALUES ('Neurologia', 'Especialidade médica dedicada ao diagnóstico e tratamento de doenças do sistema nervoso', CURRENT_TIMESTAMP);
INSERT INTO specialties (name, description, input_date) VALUES ('Pediatria', 'Especialidade médica dedicada ao diagnóstico e tratamento de doenças em crianças e adolescentes', CURRENT_TIMESTAMP);

-- Criação de convênios médicos
INSERT INTO medical_insurances (name, cnpj, input_date) VALUES ('Unimed', '12.345.678/0001-90', CURRENT_TIMESTAMP);
INSERT INTO medical_insurances (name, cnpj, input_date) VALUES ('Amil', '98.765.432/0001-10', CURRENT_TIMESTAMP);
INSERT INTO medical_insurances (name, cnpj, input_date) VALUES ('SulAmérica', '56.789.012/0001-34', CURRENT_TIMESTAMP);

-- Inserir médicos
INSERT INTO addresses (street, number, complement, neighborhood, city, state, zip_code, input_date)
VALUES ('Rua das Alamedas', '123', 'Apto 99', 'Jardim Botânico', 'São Paulo', 'SP', '01234-599', CURRENT_TIMESTAMP),
       ('Avenida do Sol', '456', 'Casa 2', 'Vila do Sol', 'Rio de Janeiro', 'RJ', '56789-012', CURRENT_TIMESTAMP),
       ('Praça da Lua', '789', '', 'Centro', 'Belo Horizonte', 'MG', '34567-890', CURRENT_TIMESTAMP),
       ('Rua das Flores', '123', 'Apto 45', 'Jardim das Rosas', 'São Paulo', 'SP', '01234-567', CURRENT_TIMESTAMP),
       ('Rua das Orquídeas', '123', 'Apto 45', 'Jardim Botânico', 'São Paulo', 'SP', '01234-567', CURRENT_TIMESTAMP),
       ('Avenida do Mar', '456', 'Casa 2', 'Vila do Mar', 'Rio de Janeiro', 'RJ', '56789-012', CURRENT_TIMESTAMP),
       ('Praça do Sol', '789', '', 'Centro', 'Belo Horizonte', 'MG', '34567-890', CURRENT_TIMESTAMP),
       ('Rua das Flores', '100', 'Apto 10', 'Jardim Primavera', 'São Paulo', 'SP', '01234-567', CURRENT_TIMESTAMP),
       ('Avenida do Mar', '200', 'Casa 20', 'Vila Mariana', 'Rio de Janeiro', 'RJ', '56789-012', CURRENT_TIMESTAMP),
       ('Praça do Sol', '300', '', 'Centro', 'Belo Horizonte', 'MG', '34567-890', CURRENT_TIMESTAMP),
       ('Rua das Estrelas', '400', 'Apto 40', 'Jardim Estrela', 'São Paulo', 'SP', '01234-567', CURRENT_TIMESTAMP),
       ('Avenida da Lua', '500', 'Casa 50', 'Vila Lua', 'Rio de Janeiro', 'RJ', '56789-012', CURRENT_TIMESTAMP),
       ('Praça da Terra', '600', '', 'Centro', 'Belo Horizonte', 'MG', '34567-890', CURRENT_TIMESTAMP),
       ('Rua do Universo', '700', 'Apto 70', 'Jardim Universo', 'São Paulo', 'SP', '01234-567', CURRENT_TIMESTAMP),
       ('Avenida do Cometa', '800', 'Casa 80', 'Vila Cometa', 'Rio de Janeiro', 'RJ', '56789-012', CURRENT_TIMESTAMP),
       ('Praça do Planeta', '900', '', 'Centro', 'Belo Horizonte', 'MG', '34567-890', CURRENT_TIMESTAMP);

-- Inserir usuários
INSERT INTO users (name, password, email, role, phone, input_date)
VALUES ('João Silva', 'senha123', 'joao.silva@email.com', 'ASSISTANT', '11987654321', CURRENT_TIMESTAMP),
       ('Pedro Santos', 'senha456', 'pedro.santos@email.com', 'PATIENT', '21976543210', CURRENT_TIMESTAMP),
       ('Lucas Pereira', 'senha789', 'lucas.pereira@email.com', 'DOCTOR', '31965432107', CURRENT_TIMESTAMP),
       ('Roberto Gomes', 'senha456', 'roberto.gomes@email.com', 'DOCTOR', '81976543210', CURRENT_TIMESTAMP),
       ('Bia Santos', 'senha456', 'bia.santos@email.com', 'DOCTOR', '21976543211', CURRENT_TIMESTAMP),
       ('Mateus Costa', 'senha123', 'mateus.costa@email.com', 'PATIENT', '41987654321', CURRENT_TIMESTAMP),
       ('Marcos Souza', 'senha456', 'marcos.souza@email.com', 'PATIENT', '51976543210', CURRENT_TIMESTAMP),
       ('Luis Oliveira', 'senha789', 'luis.oliveira@email.com', 'PATIENT', '61965432107', CURRENT_TIMESTAMP),
       ('Carlos Lima', 'senha123', 'carlos.lima@email.com', 'PATIENT', '71987654321', CURRENT_TIMESTAMP),
       ('Ricardo Rocha', 'senha789', 'ricardo.rocha@email.com', 'PATIENT', '91965432107', CURRENT_TIMESTAMP),
       ('Ana Silva', 'senha123', 'ana.silva@email.com', 'PATIENT', '11987654322', CURRENT_TIMESTAMP),
       ('Clara Pereira', 'senha789', 'clara.pereira@email.com', 'PATIENT', '31965432108', CURRENT_TIMESTAMP),
       ('Dani Costa', 'senha123', 'dani.costa@email.com', 'PATIENT', '41987654322', CURRENT_TIMESTAMP),
       ('Eva Souza', 'senha456', 'eva.souza@email.com', 'PATIENT', '51976543211', CURRENT_TIMESTAMP),
       ('Fernanda Oliveira', 'senha789', 'fernanda.oliveira@email.com', 'PATIENT', '61965432108', CURRENT_TIMESTAMP),
       ('Gabi Lima', 'senha123', 'gabi.lima@email.com', 'PATIENT', '71987654322', CURRENT_TIMESTAMP);

-- Inserir assistente
INSERT INTO assistants (cpf, user_id, address_id, input_date)
VALUES ('123.456.789-00', 1, 1, CURRENT_TIMESTAMP);

-- Inserir médicos
INSERT INTO doctors (crm, cpf, user_id, address_id, input_date)
VALUES ('123456-SP', '123.456.789-00', 2, 2, CURRENT_TIMESTAMP),
       ('789012-RJ', '987.654.321-00', 3, 3, CURRENT_TIMESTAMP),
       ('345678-MG', '456.789.123-00', 4, 4, CURRENT_TIMESTAMP);

-- Inserir Pacientes
INSERT INTO patients (birth_date, user_id, address_id, input_date)
VALUES ('1980-01-01', 5, 5, CURRENT_TIMESTAMP),
       ('1990-02-02', 6, 6, CURRENT_TIMESTAMP),
       ('2000-03-03', 7, 7, CURRENT_TIMESTAMP),
       ('1981-01-01', 8, 8, CURRENT_TIMESTAMP),
       ('1991-02-02', 9, 9, CURRENT_TIMESTAMP),
       ('2001-03-03', 10, 10, CURRENT_TIMESTAMP),
       ('1982-04-04', 11, 11, CURRENT_TIMESTAMP),
       ('1992-05-05', 12, 12, CURRENT_TIMESTAMP),
       ('2002-06-06', 13, 13, CURRENT_TIMESTAMP),
       ('1983-07-07', 14, 14, CURRENT_TIMESTAMP),
       ('1993-08-08', 15, 15, CURRENT_TIMESTAMP),
       ('2003-09-09', 16, 16, CURRENT_TIMESTAMP);

-- Inserir horários para o médico com id 1
INSERT INTO schedules (doctor_id, start_working_hours, end_working_hours, start_lunch_hours, end_lunch_hours, working_days)
VALUES (1, '08:00:00', '18:00:00', '12:00:00', '13:00:00', 'MONDAY'),
       (1, '08:00:00', '18:00:00', '12:00:00', '13:00:00', 'TUESDAY'),
       (1, '08:00:00', '18:00:00', '12:00:00', '13:00:00', 'WEDNESDAY'),
       (1, '08:00:00', '18:00:00', '12:00:00', '13:00:00', 'THURSDAY'),
       (1, '08:00:00', '18:00:00', '12:00:00', '13:00:00', 'FRIDAY'),
       (1, '08:00:00', '12:00:00', NULL, NULL, 'SATURDAY');

-- Inserir horários para o médico com id 2
INSERT INTO schedules (doctor_id, start_working_hours, end_working_hours, start_lunch_hours, end_lunch_hours, working_days)
VALUES (2, '09:00:00', '19:00:00', '13:00:00', '14:00:00', 'MONDAY'),
       (2, '09:00:00', '19:00:00', '13:00:00', '14:00:00', 'TUESDAY'),
       (2, '09:00:00', '19:00:00', '13:00:00', '14:00:00', 'WEDNESDAY'),
       (2, '09:00:00', '19:00:00', '13:00:00', '14:00:00', 'THURSDAY'),
       (2, '09:00:00', '19:00:00', '13:00:00', '14:00:00', 'FRIDAY'),
       (2, '09:00:00', '13:00:00', NULL, NULL, 'SATURDAY');

-- Inserir horários para o médico com id 3
INSERT INTO schedules (doctor_id, start_working_hours, end_working_hours, start_lunch_hours, end_lunch_hours, working_days)
VALUES (3, '10:00:00', '20:00:00', '14:00:00', '15:00:00', 'MONDAY'),
       (3, '10:00:00', '20:00:00', '14:00:00', '15:00:00', 'TUESDAY'),
       (3, '10:00:00', '20:00:00', '14:00:00', '15:00:00', 'WEDNESDAY'),
       (3, '10:00:00', '20:00:00', '14:00:00', '15:00:00', 'THURSDAY'),
       (3, '10:00:00', '20:00:00', '14:00:00', '15:00:00', 'FRIDAY'),
       (3, '10:00:00', '14:00:00', NULL, NULL, 'SATURDAY');

-- Inserir especialidades para o médico com id 1
INSERT INTO doctors_specialties (doctor_id, specialty_id)
VALUES (1, 1);

-- Inserir especialidades para o médico com id 2
INSERT INTO doctors_specialties (doctor_id, specialty_id)
VALUES (2, 2),
       (2, 3);

-- Inserir especialidades para o médico com id 3
INSERT INTO doctors_specialties (doctor_id, specialty_id)
VALUES (3, 4),
       (3, 5),
       (3, 6);


-- Inserir seguros médicos para o médico com id 2
INSERT INTO doctors_medical_insurances (doctor_id, medical_insurance_id)
VALUES (2, 1),
       (2, 3);

-- Inserir seguros médicos para o médico com id 3
INSERT INTO doctors_medical_insurances (doctor_id, medical_insurance_id)
VALUES (3, 1),
       (3, 2),
       (3, 3);

-- Inserir consultas médicas para o médico com id 1
INSERT INTO medical_appointments (date, start_hour, status, doctor_id, patient_id, input_date)
VALUES (CURRENT_DATE, '08:00:00', 'FINISHED', 1, 1, CURRENT_TIMESTAMP),
       (CURRENT_DATE, '09:00:00', 'CONFIRMED', 1, 2, CURRENT_TIMESTAMP),
       (CURRENT_DATE, '09:30:00', 'SCHEDULED', 1, 3, CURRENT_TIMESTAMP),
       (CURRENT_DATE, '10:30:00', 'SCHEDULED', 1, 4, CURRENT_TIMESTAMP);

-- Inserir consultas médicas para o médico com id 2
INSERT INTO medical_appointments (date, start_hour, status, doctor_id, patient_id, input_date)
VALUES (CURRENT_DATE, '10:30:00', 'CONFIRMED', 2, 5, CURRENT_TIMESTAMP),
       (CURRENT_DATE, '11:30:00', 'SCHEDULED', 2, 6, CURRENT_TIMESTAMP),
       (CURRENT_DATE, '12:00:00', 'SCHEDULED', 2, 7, CURRENT_TIMESTAMP),
       (CURRENT_DATE, '12:30:00', 'CANCELED', 2, 8, CURRENT_TIMESTAMP);

-- Inserir consultas médicas para o médico com id 3
INSERT INTO medical_appointments (date, start_hour, status, doctor_id, patient_id, input_date)
VALUES (CURRENT_DATE, '11:00:00', 'CONFIRMED', 3, 9, CURRENT_TIMESTAMP),
       (CURRENT_DATE, '12:00:00', 'CANCELED', 3, 10, CURRENT_TIMESTAMP),
       (CURRENT_DATE, '12:30:00', 'SCHEDULED', 3, 11, CURRENT_TIMESTAMP),
       (CURRENT_DATE, '13:30:00', 'SCHEDULED', 3, 12, CURRENT_TIMESTAMP);
