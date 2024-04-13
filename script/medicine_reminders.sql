
-- medicine reminders
CREATE TABLE medicine_reminders (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    medicine_name VARCHAR(100) NOT NULL,
    dosage VARCHAR(50) NOT NULL,
    schedule VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insert medicine reminders
INSERT INTO medicine_reminders (user_id, medicine_name, dosage, schedule, start_date, end_date) VALUES
(11, 'Simvastatin', '1 tablet', 'At bedtime', '2024-03-29', '2024-04-05'),
(12, 'Paracetamol', '1 tablet', 'Once daily', '2024-03-29', '2024-04-05'),
(13, 'Ibuprofen', '2 tablets', 'Twice daily', '2024-03-29', '2024-04-05'),
(14, 'Diazepam', '1 tablet', 'As needed for anxiety', '2024-03-29', '2024-04-05'),
(15, 'Loratadine', '1 tablet', 'Once daily', '2024-03-29', '2024-04-05'),
(16, 'Omeprazole', '1 capsule', 'Once daily before breakfast', '2024-03-29', '2024-04-05'),
(17, 'Aspirin', '1 tablet', 'Every 6 hours', '2024-03-29', '2024-04-05'),
(18, 'Levothyroxine', '1 tablet', 'On an empty stomach before breakfast', '2024-03-29', '2024-04-05'),
(19, 'Metformin', '2 tablets', 'Twice daily with meals', '2024-03-29', '2024-04-05'),
(20, 'Amoxicillin', '1 capsule', 'Every 8 hours', '2024-03-29', '2024-04-05');

--show table
SELECT * FROM medicine_reminders;
