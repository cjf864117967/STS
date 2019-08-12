package com.chenjifeng.utils;

public class StringUtil1 {
	
	//性别在男和女两个值中随机
	public static String sex() {
		String str[] = {"男","女"};
		String str1="";
		for (int i = 0; i < str.length; i++) {
			return str1=str[i];
		}
		return str1;
	}
	
	
	//邮箱随机生成
	public static String email() {
		String num2="";
		for (int i = 3; i < 21; i++) {
			int num = (int) (Math.random()*9);
			num2=num2+(num+"");
		}
		return num2;
		
	}
	
	//模拟生日
	public static String date() {
		return "1997-01-01";
		
	}
}
