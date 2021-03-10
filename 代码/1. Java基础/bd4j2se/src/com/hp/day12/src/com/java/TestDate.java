package com.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	/*Date类：时间类*/
	public static void main(String[] args) {
		//获取当前系统时间
		Date date=new Date();
		System.out.println(date);//重写了toString 方法
		
		
		//SimpleDateFormat:可以实现日期的格式化
		//format():对日期类型进行格式化，转成文本格式
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
		String date1= simpleDateFormat.format(new Date());
		System.out.println(date1);
		
		//指定显示日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//记住这个格式
		String date2=sdf.format(new Date());
		System.out.println(date2);
		
		//文本格式转成时间
		//parse():把字符串转成时间类型  了解
		try {
			Date date3= sdf.parse("2019-01-17 08:59:33");//转化的字符串必须是时间格式
			System.out.println(date3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
