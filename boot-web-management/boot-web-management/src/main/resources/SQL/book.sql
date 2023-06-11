create database if not exists books;

use books;

show create table book;

CREATE TABLE `book`
(
    `id`          int         NOT NULL AUTO_INCREMENT COMMENT '書本id',
    `name`        varchar(50) NOT NULL COMMENT '書本名字',
    `image`       varchar(50)          DEFAULT NULL COMMENT '圖片',
    `status_id`   int         NOT NULL COMMENT '1是已借,2是可以借或已還\n\n\n',
    `category_id` int         NOT NULL DEFAULT '1' COMMENT '分類',
    `create_time` datetime    NOT NULL COMMENT '創建時間\n',
    `update_time` datetime             DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='書本資料';

insert into book (name, image, status_id, category_id, create_time, update_time) value
    ('財務管理', null, 2, 1, now(), null), ('投資學', null, 2, 1, now(), null),
    ('日常科技介紹', null, 2,2, now(), null), ('汽車科技', null, 2, 2, now(), null), ('今日民生', null, 2, 3, now(), null),
    ('公共行政與市民', null, 2,3, now(), null), ('壓力與健康', null, 2, 4, now(), null), ('冥想入門', null, 2, 4, now(), null),
    ('歐洲旅遊介紹', null, 2, 5, now(), null), ('日本旅遊介紹', null, 2, 5, now(), null)
