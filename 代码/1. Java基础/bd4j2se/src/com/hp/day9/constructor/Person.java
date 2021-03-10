package com.hp.day9.constructor;

import java.util.Date;

/**
 * 
 * @author McGradyXYZ
 *
 */
public class Person {
	// 修饰符 数据类型
	private String name;
	private int age;
	private Date birthday;

	public Person() {
		System.out.println("@@@@");
	}
	
	public Person(String name, int age) {
		this();
		this.name = name;
		this.age = age;
	}

	// 有参构造方法目的：1.创建对象 2.初始化成员变量
	/**
	 * 如果在一个方法中，形式参数/局部
	 * 
	 * @param name 姓名
	 * @param age
	 * @param birthday
	 */
	public Person(String name, int age, Date birthday) {
//		this.name = name;
//		this.age = age;
		this(name,age);
		this.birthday = birthday;
	}

	public String getInfo() {
		String result = this.getInfo2();
		return result;
	}
	
	public String getInfo2() {
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public static void main(String [] args){
		/**
		 * 可以有两种方式初始化成员对象
		 * 1.通过无参构造方法创建对象，通过成员变量的set方法修改（初始化）成员变量的值
		 *   具体调用哪些
		 * 2.可以通过有参构造方法
		 * 
		 * 如果初始化成员变量较少，可以使用第一种
		 * 如果成员变量比较多，在创建对象需
		 * spring中使用第一种，所以如果重载了有参构造方法，必须要有一个无参
		 */
		Person p = new Person();
		p.setName("zhang");
		p.setAge(10);
		p.setBirthday(new Date());
		
		Person p2 = new Person("wang", 18, new Date());

//		com.hp.day8.extend.Person p2 = new com.hp.day8.extend.Person("wang", 18, new Date());
		
	}

}
