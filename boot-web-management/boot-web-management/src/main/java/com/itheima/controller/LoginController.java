package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("用戶登錄:{}",user);
        User u = userService.login(user);
        //用戶登錄成功
        if(u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());
            claims.put("name", u.getName());

            String jwt = JwtUtils.generateJwt(claims);//生成token令牌
            return Result.success(jwt);
        }
        //登錄失敗
      return Result.error("密碼帳號有錯");
    }
}
