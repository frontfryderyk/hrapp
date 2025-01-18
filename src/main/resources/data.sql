INSERT INTO user_type (id, type) VALUES (1, 'ADMIN');
INSERT INTO user_type (id, type) VALUES (1, 'EMPLOYEE');


INSERT INTO users (username, password, salt, user_type_id, rating)
VALUES ('admin', 'admin123', 'salt',1 , 5.0)


INSERT INTO projects (name, description) VALUES
                                             ('Projekt A', 'Opis projektu A'),
    ('Projekt B', 'Opis projektu B')
    ('Projekt C', 'Opis projektu C');