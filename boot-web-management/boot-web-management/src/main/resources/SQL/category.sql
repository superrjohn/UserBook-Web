CREATE TABLE `category`
(
    `id`          int         NOT NULL AUTO_INCREMENT,
    `name`        varchar(20) NOT NULL COMMENT '分類名字\n',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime             DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='分類';

insert into category(name, create_time, update_time) value
    ('金融類', NOW(), null), ('科技類', NOW(), null), ('社會類', NOW(), null), ('心理與健康類', NOW(), null),
    ('旅遊類', NOW(), null)