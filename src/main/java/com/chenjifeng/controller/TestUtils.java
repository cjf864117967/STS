package com.chenjifeng.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.chenjifeng.bean.User;
import com.chenjifeng.utils.SqlMain;
import com.chenjifeng.utils.StringUtil1;
import com.chenjifeng.utils.TestStringUtils;

@Controller
public class TestUtils {
	@Resource
	private RedisTemplate redisTemplate;
	//JDK系列化方式
	@RequestMapping("/testJDK")
	public String testJDK() throws UnsupportedEncodingException {
		ListOperations opsForList = redisTemplate.opsForList();
		long open = System.currentTimeMillis();//记录开始时间
		User user =  new User();//实例化对象
		int count = 0 ;
		for (int i = 0; i < 100000; i++) {//进行十万条数据的生成以及保存到redis中
			user.setUid(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setUphone("13"+TestStringUtils.getRandomString(9));
			user.setUemail(StringUtil1.email()+"@qq.com");
			user.setSex(StringUtil1.sex());
			user.setUdate(StringUtil1.date());
			count++;
			opsForList.leftPush("jdk", user);//将数据保存到redis中
		}
		long end = System.currentTimeMillis();
		System.out.println("JDK系列化方式");
		System.out.println("保存数量为"+count);
		System.out.println("所耗时间为:"+(end-open));//输出所耗时间
		return "list";
		
	}
	
	
	
	
	@RequestMapping("/testJSON")
	public String testJSON() throws UnsupportedEncodingException {
		//JSON系列化方式
		BoundListOperations boundListOps = redisTemplate.boundListOps("jdk");
		long open = System.currentTimeMillis();//记录开始时间
		User user =  new User();//实例化对象
		int count = 0 ;
		for (int i = 0; i < 100000; i++) {//进行十万条数据的生成以及保存到redis中
			user.setUid(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setUphone("13"+TestStringUtils.getRandomString(9));
			user.setUemail(StringUtil1.email()+"@qq.com");
			user.setSex(StringUtil1.sex());
			user.setUdate(StringUtil1.date());
			count++;
			Object json = JSON.toJSON(user);
			boundListOps.leftPush(json);//将数据保存到redis中
		}
		long end = System.currentTimeMillis();//记录结束时间
		System.out.println("JSON系列化方式");
		System.out.println("保存数量为"+count);
		System.out.println("所耗时间为:"+(end-open));//输出所耗时间
		return "list";
		
	}
	
	@RequestMapping("/testHash")
	public String testHash() throws UnsupportedEncodingException {
		//Hash系列化方式
		HashOperations<String,String,Object> opsForHash = redisTemplate.opsForHash();
		long open = System.currentTimeMillis();//记录开始时间
		Map<String, Map<String,Object>> map = new HashMap<>();
		User user =  new User();//实例化对象
		int count = 0 ;
		for (int i = 0; i < 100000; i++) {//进行十万条数据的生成以及保存到redis中
			Map<String, Object> m = new HashMap<>();
			m.put("uid", i+1);
			m.put("uname", SqlMain.getChinaName());
			m.put("uemail", StringUtil1.email()+"@qq.com");
			m.put("sex", StringUtil1.sex());
			m.put("udate", StringUtil1.date());
			map.put("m", m);
			opsForHash.put("Hash", "m", map);//将数据保存到redis中
			count++;
		}
		long end = System.currentTimeMillis();//记录结束时间
		System.out.println("Hash系列化方式");
		System.out.println("保存数量为"+count);
		System.out.println("所耗时间为:"+(end-open));//输出所耗时间
		return "list";
		
	}
}
