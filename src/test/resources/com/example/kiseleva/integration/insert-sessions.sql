INSERT INTO "user" (id, first_name, last_name, username, password, bio, role)
VALUES (1, 'John', 'Doe', 'username', 'password', 'bio', 'USER');

INSERT INTO session (user_id, status)
VALUES (1, 'open');

INSERT INTO session (user_id, status)
VALUES (1, 'closed');

INSERT INTO session (user_id, status)
VALUES (1, 'done');
