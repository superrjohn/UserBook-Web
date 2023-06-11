package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分頁查詢的分裝類
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;//總記錄數
    private List rows;//數據列表
}
