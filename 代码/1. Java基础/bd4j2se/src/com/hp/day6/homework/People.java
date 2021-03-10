package com.hp.day6.homework;

/**
 * （1）创建一个叫做People的类：
	属性：姓名、年龄、性别、身高
	行为：说话、计算加法、改名
	编写能为所有属性赋值的构造方法；
 * @author McGradyXYZ
 *
 */
public class People {
	
	String name;
	int age;
	String gender;
	double height;
	
	public People(String name, int age, String gender, double height) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
	}
	
	public void speak(String str) {
		System.out.println(str);
	}
	
	public double addition(double a, double b) {
		return a+b;
	}
	
	public void updateName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		

	}

}
