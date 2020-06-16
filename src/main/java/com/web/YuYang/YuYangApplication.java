package com.web.YuYang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.web.YuYang.Mapper")
public class YuYangApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuYangApplication.class, args);
	}

}
