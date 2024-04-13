
-- Create Users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_doctor BOOLEAN NOT NULL
);

-- Insert doctors
INSERT INTO users (first_name, last_name, email, password, is_doctor) VALUES
('Alex', 'Green', 'alex.green@hotmail.com', 'password1', true),
('Dot', 'Tree', 'dot.tree@hotmail.com', 'password2', true),
('David', 'Peach', 'david.peach@hotmail.com', 'password3', true),
('Doug', 'Flower', 'doug.flower@hotmail.com', 'password4', true),
('Lirene', 'Goodkind', 'lirene.goodkind@hotmail.com', 'password5', true),
('Gale', 'Storm', 'gale.storm@hotmail.com', 'password6', true),
('Nathan', 'Pickles', 'nathan.pickles@hotmail.com', 'password7', true),
('Max', 'Steel', 'max.steel@hotmail.com', 'password8', true),
('Sarah', 'Sunny', 'sarah.sunny@hotmail.com', 'password9', true),
('Kate', 'Marsh', 'kate.marsh@hotmail.com', 'password10', true);

-- Insert patients
INSERT INTO users (first_name, last_name, email, password, is_doctor) VALUES
('Martin', 'Levy', 'martin.levy@hotmail.com', 'password11', false),
('Eugene', 'Polley', 'eugene.polley@hotmail.com', 'password12', false),
('Sarah', 'Anderson', 'sarah.anderson@hotmail.com', 'password13', false),
('Pamela', 'Anka', 'pamela.anka@hotmail.com', 'password14', false),
('Paul', 'Arnett', 'paul.arnett@hotmail.com', 'password15', false),
('Will', 'Aykroyd', 'will.aykroyd@hotmail.com', 'password16', false),
('Dan', 'Beach', 'dan.beach@hotmail.com', 'password17', false),
('Adam', 'Baruchel', 'adam.baruchel@hotmail.com', 'password18', false),
('Jay', 'Carrey', 'jay.carrey@hotmail.com', 'password19', false),
('Kim', 'Cera', 'kim.cera@hotmail.com', 'password20', false);

--Show users table
SELECT * FROM users;
