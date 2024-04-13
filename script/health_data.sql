
--Health data
CREATE TABLE health_data (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    weight DECIMAL(5,2) NOT NULL,
    height DECIMAL(5,2) NOT NULL,
    steps INT NOT NULL,
    heart_rate INT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
)
-- Insert health data for doctors
INSERT INTO health_data (user_id, weight, height, steps, heart_rate, date) VALUES
(1, 70.5, 175.0, 8000, 70, '2024-03-30'),
(2, 65.2, 168.0, 9000, 72, '2024-03-30'),
(3, 80.0, 180.0, 7500, 68, '2024-03-30'),
(4, 72.3, 172.0, 10000, 75, '2024-03-30'),
(5, 78.9, 178.0, 7000, 65, '2024-03-30'),
(6, 68.7, 170.0, 8500, 74, '2024-03-30'),
(7, 75.4, 183.0, 9500, 78, '2024-03-30'),
(8, 73.1, 176.0, 8200, 70, '2024-03-30'),
(9, 79.8, 181.0, 7200, 67, '2024-03-30'),
(10, 67.5, 169.0, 8800, 73, '2024-03-30');

-- Insert health data for patients
INSERT INTO health_data (user_id, weight, height, steps, heart_rate, date) VALUES
(11, 85.2, 180.0, 6000, 78, '2024-03-30'),
(12, 72.9, 175.0, 8500, 72, '2024-03-30'),
(13, 68.4, 170.0, 7000, 75, '2024-03-30'),
(14, 76.7, 178.0, 9500, 80, '2024-03-30'),
(15, 79.5, 182.0, 7200, 68, '2024-03-30'),
(16, 66.8, 167.0, 8200, 73, '2024-03-30'),
(17, 74.3, 175.0, 8800, 76, '2024-03-30'),
(18, 71.6, 172.0, 7600, 70, '2024-03-30'),
(19, 77.9, 180.0, 9200, 79, '2024-03-30'),
(20, 82.1, 185.0, 6400, 77, '2024-03-30');

--Show health data table
SELECT * FROM health_data;
