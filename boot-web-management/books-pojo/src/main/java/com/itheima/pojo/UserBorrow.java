package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBorrow {
    private Integer id;
    private String bookName;
    private Integer userId;
    private Integer bookId;
    private Integer statusId;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
