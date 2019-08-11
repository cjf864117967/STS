package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.chenjifeng")
@MapperScan("com.chenjifeng.mapper")
public class SsmCourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsmCourceApplication.class, args);
	}

}
