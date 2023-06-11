package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component//交給IOC管理
@Aspect//切面類
public class LogAspect {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.itheima.anno.Log)")//以註解方式配備切入點方法
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //操作人ID,當前登錄員工的ID,獲最請求頭的JWT令牌,解析令牌
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");//Claims類為Object,所以要強轉
        //操作時間
        LocalDateTime operateTime = LocalDateTime.now();
        //操作類名
        String className = joinPoint.getTarget().getClass().getName();
        //操作方法名
        String methodName = joinPoint.getSignature().getName();
        //操作方法參數
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        //開始調用原始方法時間
        long begin = System.currentTimeMillis();
        //調用原始目標方法運行
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        //方法返回值
        String returnValue = JSONObject.toJSONString(result);
        //操作時間
        long costTime = end - begin;
        //記錄操作日志
        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP記錄日志:{}", operateLog);

        return result;

    }
}
