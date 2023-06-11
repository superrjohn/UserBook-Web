CREATE TABLE `status`
(
    `id`          int         NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(20) NOT NULL COMMENT '1是已出借,2是未借出,3是已還\n',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime             DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='出借狀態';

insert into status(name, create_time, update_time)
values ('lent out',NOW(),null),('not lent',NOW(),null)
