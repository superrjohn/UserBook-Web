package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.BookMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Book;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.UserBorrow;
import com.itheima.service.BookService;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    //查詢所有書
    @Override
    public PageBean list(Integer page, Integer pageSize, String name, Integer statusId, Integer categoryId, LocalDate createTime) {
        //1.設置分貢參數
        PageHelper.startPage(page, pageSize);
        //2.執行查詢
        List<Book> bookList = bookMapper.list(name, statusId, categoryId, createTime);
        Page<Book> p = (Page<Book>) bookList;
        //3.封裝PageBean對象
        PageBean pageBean = new PageBean(p.getTotal() ,p.getResult());
        return pageBean;

    }

    //更改書本出借狀態和用戶借書記錄
    @Transactional(rollbackFor = Exception.class)//一有異常就回滾
    @Override
    public void updateStatus(UserBorrow userBorrow) {
        userBorrow.setUpdateTime(LocalDateTime.now());
        userBorrow.setCreateTime(LocalDateTime.now());
        //更改書本出借狀態
        bookMapper.updateStatus(userBorrow);
        //新增用戶借書記錄
        userMapper.insertRecord(userBorrow);

    }
}
