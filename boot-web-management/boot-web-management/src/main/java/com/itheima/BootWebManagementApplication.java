package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//開啟對Servlet支持
@SpringBootApplication
public class BootWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWebManagementApplication.class, args);
    }

}
