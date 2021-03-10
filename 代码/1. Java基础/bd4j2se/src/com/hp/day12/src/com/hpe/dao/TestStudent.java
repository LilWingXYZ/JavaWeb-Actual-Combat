package com.hpe.dao;

import com.hpe.pojo.Student;

public class TestStudent {
	
	public static void main(String[] args) {
		StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
		Student stu=new Student();
		stu.setName("张三");
		studentDaoImpl.add(stu);
	}

}
