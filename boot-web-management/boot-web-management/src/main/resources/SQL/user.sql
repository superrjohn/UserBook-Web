CREATE TABLE `user`
(
    `id`          int         NOT NULL AUTO_INCREMENT,
    `username`    varchar(20) NOT NULL COMMENT '帳號名字',
    `password`    varchar(20) NOT NULL DEFAULT '123456' COMMENT '密碼',
    `name`        varchar(20) NOT NULL COMMENT '用戶名字',
    `create_time` datetime             DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime             DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 16
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用戶';

insert into user(username, password, name, create_time, update_time)
VALUES ('john', '123456', '湯姆', NOW(), null),
       ('peter', '123456', '彼得', NOW(), null),
       ('lucy', '123456', '露西', NOW(), null),
       ('sam', '123456', '山姆', NOW(), null),
       ('abcd123', '123456', 'abcd', NOW(), null)