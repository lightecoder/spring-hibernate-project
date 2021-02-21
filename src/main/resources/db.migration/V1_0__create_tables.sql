CREATE TABLE user_type
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    user_type_name VARCHAR(20)
);

CREATE TABLE activity
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    activity_name VARCHAR(20)
);

CREATE TABLE status
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    status_name VARCHAR(20)
);

CREATE TABLE user
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(20),
    sur_name     VARCHAR(20),
    login        VARCHAR(20),
    password     VARCHAR(20),
    request_add boolean,
    user_type_id INT,
    FOREIGN KEY (user_type_id) REFERENCES user_type (id)
);

CREATE TABLE user_request
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    user_request_name VARCHAR(20)
);

CREATE TABLE tracking
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    user_id         INT,
    activity_id     INT,
    status_id       INT,
    user_request_id INT,
    time            VARCHAR(20),
    time_start      BIGINT(64),
    time_stop       BIGINT(64),
    difference_time BIGINT(64),
    time_switch     boolean,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (activity_id) REFERENCES activity (id),
    FOREIGN KEY (status_id) REFERENCES status (id),
    FOREIGN KEY (user_request_id) REFERENCES user_request (id)
);
