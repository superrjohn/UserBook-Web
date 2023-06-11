package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String image;
    private Integer statusId;
    private Integer categoryId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
