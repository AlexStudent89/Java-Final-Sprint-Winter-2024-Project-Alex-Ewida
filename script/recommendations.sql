
-- recommendations
CREATE TABLE recommendations (
     id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    recommendation_text TEXT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
)

-- Insert recommendations
INSERT INTO recommendations (user_id, recommendation_text, date) VALUES
(11, 'Increase daily steps to 10,000 for better health.', '2024-03-30'),
(12, 'Drink more water and get enough sleep.', '2024-03-30'),
(13, 'Maintain a balanced diet for overall well-being.', '2024-03-30'),
(14, 'Finish the prescribed antibiotic course.', '2024-03-30'),
(15, 'Engage in regular physical activity to strengthen muscles and bones.', '2024-03-30'),
(16, 'Practice stress-reducing techniques such as meditation or deep breathing exercises.', '2024-03-30'),
(17, 'Limit intake of processed foods and sugary drinks to improve overall health.', '2024-03-30'),
(18, 'Get regular check-ups with healthcare providers to monitor health status.', '2024-03-30'),
(19, 'Prioritize mental health by taking breaks, practicing self-care, and seeking support when needed.', '2024-03-30');

--show table
SELECT * FROM recommendations
