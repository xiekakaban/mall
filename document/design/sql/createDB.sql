CREATE TABLE tb_administrator
(
    id VARCHAR(50) PRIMARY KEY NOT NULL,
    username VARCHAR(100) NOT NULL,
    avator VARCHAR(50) DEFAULT 'default.jpg',
    pwd VARCHAR(100) NOT NULL,
    email VARCHAR(200),
    phone VARCHAR(20),
    extern_info LONGTEXT,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
);
CREATE UNIQUE INDEX username ON tb_administrator (username);




