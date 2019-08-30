package com.ocms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.ocms.dao"})
public class OcmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcmsApplication.class, args);
    }

}
