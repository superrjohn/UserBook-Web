CREATE TABLE `operate_log`
(
    `id`            int          NOT NULL AUTO_INCREMENT COMMENT 'id',
    `operate_user`  int          NOT NULL COMMENT '操作人ID',
    `operate_time`  datetime     NOT NULL COMMENT '操作時間',
    `class_name`    varchar(100) NOT NULL COMMENT '操作類名',
    `method_name`   varchar(100) NOT NULL COMMENT '操作方法名\n',
    `method_params` varchar(500) NOT NULL COMMENT '操作方法返回參數',
    `return_value`  varchar(500) NOT NULL,
    `cost_time`     bigint       NOT NULL COMMENT '操作耗時',
    PRIMARY KEY (`id`),
    UNIQUE KEY `operate_user` (`operate_user`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

