package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Result;
import com.itheima.pojo.UserBorrow;
import com.itheima.service.BookService;
import com.itheima.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    //顯示用戶借書記錄
    @GetMapping("/{id}")
    public Result recordList(@PathVariable Integer id) {
        List<UserBorrow> recordList = userService.recordList(id);
        return Result.success(recordList);
    }

    //修改借書記錄(還書),更改book狀態
    @PutMapping
    public Result update(@RequestBody UserBorrow userBorrow) {
        bookService.updateStatus(userBorrow);
        return Result.success();
    }
}
