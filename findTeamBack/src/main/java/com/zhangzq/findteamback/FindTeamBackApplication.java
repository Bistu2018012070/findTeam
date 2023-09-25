package com.zhangzq.findteamback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.zhangzq.findteamback.mapper")
@SpringBootApplication
@EnableScheduling
public class FindTeamBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindTeamBackApplication.class, args);
    }

}
