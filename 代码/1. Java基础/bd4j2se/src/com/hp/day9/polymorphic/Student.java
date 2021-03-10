package com.hp.day9.polymorphic;

public class Student extends Person {
	private String school;
	
	/**
	 * 
	 */
	public String getInfo() {
		return "Name: " + getName() + "\n" + "age： " +getAge()+"\nschool:"+school;
	}
	
	public static void main(String [] args) {
		//当创建的是子类对象时，调用的是子类的方法
		Student s = new Student();
		System.out.println("创建子类对象："+s.getInfo());
		
		//当创建的是父类对象时，调用的是父类的方法
		Person p = new Person();
		System.out.println("创建父类对象"+p.getInfo());
		
		/*
		 * 父类类型  变量名  = 子类构造方法()
		 * 如果有 重写（子类的方法覆盖了父类的方法），调用时调用子类的方法
		 */
		Person p2 = new Student();
		System.out.println(""+p2.getInfo());
	}
}
