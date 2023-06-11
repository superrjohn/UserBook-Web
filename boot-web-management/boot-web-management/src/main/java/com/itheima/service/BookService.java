package com.itheima.service;

import com.itheima.pojo.Book;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.UserBorrow;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    //查詢所有書本
    PageBean list(Integer page, Integer pageSize, String name, Integer statusId, Integer categoryId, LocalDate createTime);

    //修改書本出借狀態和新增用戶借書記錄
    void updateStatus(UserBorrow userBorrow);


}
