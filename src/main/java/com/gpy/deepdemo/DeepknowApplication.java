package com.gpy.deepdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gpy.deepdemo.dao")
public class DeepknowApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeepknowApplication.class, args);
	}

}

