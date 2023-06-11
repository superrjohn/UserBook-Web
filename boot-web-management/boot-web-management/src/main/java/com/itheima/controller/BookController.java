package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Book;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.pojo.UserBorrow;
import com.itheima.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //查詢所有書本,分頁設計
    @GetMapping
    public Result pageList(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       String name,
                       Integer statusId,
                       Integer categoryId,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate createTime) {
        log.info("分頁查詢:{},{},{},{},{},{}",page, pageSize, name, statusId, categoryId, createTime);
        PageBean pageBean = bookService.list(page, pageSize, name, statusId, categoryId, createTime);
        return Result.success(pageBean);
    }

    @Log
    //修改書本出借狀態和新增用戶借書記錄
    @PutMapping
    public Result updateStatus(@RequestBody UserBorrow userBorrow){
        log.info("借出書本資料:{}",userBorrow);
        bookService.updateStatus(userBorrow);
        return Result.success();
    }
}
