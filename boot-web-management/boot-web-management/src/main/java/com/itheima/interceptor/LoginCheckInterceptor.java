package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component//交給IOC管理,運行時執行
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目標運行前運行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //解決跨域問題(本地項目)
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:7000");
        response.setHeader("Access-Control-Allow-Headers","content-type,token");
        response.setHeader("Access-Control-Request-Method","GET,POST,PUT,DELETE,OPTIONS ");
        response.setHeader("Access-Control-Allow-Credentials","true");
        //put和delete比較特殊,要設響應頭像以下
        response.setHeader("Access-Control-Allow-Methods","PUT");




        System.out.println("preHandle目標運行前運行");
        //request轉為字串
        String url = request.getRequestURL().toString();
        log.info("url為:{}", url);
        //查看url是否為login/home,是就放行
        if (url.contains("login") || url.contains("home") || url.contains("register")) {
            log.info("登入操作或首頁:{}", url);
            return true;
        }
        //獲得token請求頭
        String jwt = request.getHeader("token");
        //查看是否有token,StringUtils.hasLength空為false
        if (!StringUtils.hasLength(jwt)) {
            log.info("token為空,未登錄");
            Result error = Result.error("NOT_LOGIN");
            //手動轉換 對象轉成JSON --->阿里巴巴fastJSON
            String noLogin = JSONObject.toJSONString(error);
            response.getWriter().write(noLogin); //將錯誤信息響應給前端
            return false;
        }
        //解析token,檢查內容
        try {
            JwtUtils.parseJWT(jwt);//不報錯就是成功
        } catch (Exception e) {
            e.printStackTrace();
            log.info("token有錯,未登錄");
            Result error = Result.error("NOT_LOGIN");
            //手動轉換 對象轉成JSON --->阿里巴巴fastJSON
            String noLogin = JSONObject.toJSONString(error);
            response.getWriter().write(noLogin); //將錯誤信息響應給前端
            return false;
        }
        //拿到token,放行
        log.info("令牌合法,放行");
        return true;
    }

    @Override//目標運行後運行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle目標運行後運行");
    }

    @Override//視圖渲染後運行,最後運行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion視圖渲染後運行,最後運行");
    }
}
