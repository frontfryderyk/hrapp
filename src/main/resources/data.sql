-- Najpierw typy użytkowników
INSERT INTO user_type (id, type) VALUES (1, 'ADMIN');
INSERT INTO user_type (id, type) VALUES (2, 'EMPLOYEE');

-- Potem użytkownicy
INSERT INTO users (username, email, password, salt, user_type_id, rating)
VALUES ('admin', 'admin@example.com', 'admin123', 'salt', 1, 5.0);

-- Na końcu projekty
INSERT INTO projects (name, description, start_date, end_date)
VALUES
    ('Projekt 1', 'Opis projektu 1', '2024-01-01', '2024-12-31'),
    ('Projekt 2', 'Opis projektu 2', '2024-02-01', '2024-11-30'),
    ('Projekt 3', 'Opis projektu 3', '2024-03-01', '2024-10-31');