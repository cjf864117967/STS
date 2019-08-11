package com.chenjifeng.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenjifeng.bean.Student;
import com.chenjifeng.mapper.StudentMapper;
@Service
public class StudentServiceimpl implements StudentService{
	
	@Resource
	private StudentMapper dao;
	@Override
	public List<Student> list() {
		// TODO Auo-generated method stub
		return dao.list();
	}

}
