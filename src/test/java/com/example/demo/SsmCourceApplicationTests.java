package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmCourceApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	
	
	
	@Resource
	private RedisTemplate redisTemplate;
	@Test
	public void ceshi() {
		System.out.println(redisTemplate);
	}
}
