package com.itheima.service;

import com.itheima.pojo.User;
import com.itheima.pojo.UserBorrow;

import java.util.List;

public interface UserService {

    //用戶登錄
    User login(User user);
    //註冊
    void register(User user);

    List<UserBorrow> recordList(Integer id);
}
