package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕獲所有異常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("對不起,操作失敗!");
    }
}
