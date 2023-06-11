CREATE TABLE `user_borrow`
(
    `id`          int         NOT NULL AUTO_INCREMENT,
    `user_id`     int         NOT NULL COMMENT '用戶ID\n',
    `book_name`   varchar(20) NOT NULL,
    `book_id`     int         NOT NULL COMMENT '書ID',
    `status_id`   int                  DEFAULT NULL COMMENT '1是已借,2是可以借或已還\n',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime             DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 36
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用戶借書狀態';