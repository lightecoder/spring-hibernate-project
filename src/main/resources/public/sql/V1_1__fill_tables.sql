INSERT INTO user_type (user_type_name)
VALUES ('admin');
INSERT INTO user_type (user_type_name)
VALUES ('client');

INSERT INTO activity (activity_name)
VALUES ('game');

INSERT INTO status (status_name)
VALUES ('new_activity');
INSERT INTO status (status_name)
VALUES ('in_progress');
INSERT INTO status (status_name)
VALUES ('pause');
INSERT INTO status (status_name)
VALUES ('finished');
INSERT INTO status (status_name)
VALUES ('stop');

INSERT INTO user (first_name, sur_name, login, password, user_type_id)
VALUES ('Ray', 'Parker', 'admin', 'admin', '1');
INSERT INTO user (first_name, sur_name, login, password, user_type_id)
VALUES ('Tom', 'Crooz', 'user', 'user', '2');

INSERT INTO user_request (user_request_name)
VALUES ('add');
INSERT INTO user_request (user_request_name)
VALUES ('remove');

INSERT INTO tracking (user_id, activity_id, status_id, user_request_id, time, time_start, time_stop, difference_time)
VALUES ('2', '1', '1', NULL, '00:00:00', '0', '0', '0');
