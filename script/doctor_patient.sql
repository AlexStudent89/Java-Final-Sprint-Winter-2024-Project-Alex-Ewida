
-- Create doctor_patient table
CREATE TABLE doctor_patient (
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    PRIMARY KEY (doctor_id, patient_id),
    FOREIGN KEY (doctor_id) REFERENCES users(id),
    FOREIGN KEY (patient_id) REFERENCES users(id)
);

-- Insert doctor-patient relationships
INSERT INTO doctor_patient (doctor_id, patient_id) VALUES
(1, 11),
(2, 12),
(3, 13),
(4, 14),
(5, 15),
(6, 16),
(7, 17),
(8, 18),
(9, 19),
(10, 20);

--Show doctor_patient table
SELECT * FROM doctor_patient;
