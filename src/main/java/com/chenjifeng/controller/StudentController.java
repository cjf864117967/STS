package com.chenjifeng.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenjifeng.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	
	@Resource
	private RedisTemplate redisTemplate;
	
	@SuppressWarnings("all")
	@RequestMapping("/list")
	public String list(Model model) {
		
		BoundListOperations ops = redisTemplate.boundListOps("hotlist");
		List resultList = new ArrayList();
		List range = ops.range(0, -1);
		if(range != null && range.size()>0) {
			resultList=range;
			System.out.println("yes");
		}else {
			resultList = service.list();
			for (Object object : range) {
				ops.rightPush(object);
			}
		}
//		List list = service.list();
		model.addAttribute("list", resultList);
		return "list";
		
		
	}
}
