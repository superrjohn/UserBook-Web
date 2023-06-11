package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定義註解,記錄修改用戶修改日誌
@Retention(RetentionPolicy.RUNTIME) //運行時生效
@Target(ElementType.METHOD)//註明方法上生效
public @interface Log {
}
