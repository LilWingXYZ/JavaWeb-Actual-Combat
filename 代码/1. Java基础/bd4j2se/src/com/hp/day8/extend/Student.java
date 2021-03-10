package com.hp.day8.extend;

import java.util.Date;

/**
 * 1.成员变量
 * 2.构造方法（）
 * 
 * @author McGradyXYZ
 *
 */
public class Student extends Person {
	private String school;
	
	public Student(){
		super();
	}
	
	/**
	 * super可以调用父类的构造方法，如果没有参数，则调用的父类的无参构造方法，如果没有显示的父类，调用的object的方法
	 * 如果有参数，在父类中必须有参数和数据类型匹配的构造方法
	 * 在构造方法中使用的this或super要放到第一行
	 * @param name
	 * @param age
	 * @param birthday
	 * @param school
	 */
	
	public Student(String name, int age, Date birthday, String school) {
		super(name, age, birthday);
		this.school = school;
	}
	
	/**
	 * super调用父类的普通方法，使用super.方法
	 */
	public void getInfo3() {
//		super.getInfo();
		getInfo();
		this.getInfo();
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	public static void main(String [] args) {
		Student stu = new Student();
		Student stu2 = new Student("wang", 18, new Date(), "聊城大学");
		
	}

	
}
