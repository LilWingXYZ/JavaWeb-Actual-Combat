package com.hp.day9.polymorphic;

public class Person {
	private String name;
	private int age;

	public String getInfo() {
		return " ";
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

	public String toString() {
		return "Name: " + name + "\n" + "age： " + age;

	}

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("zhang");
		p.setAge(18);
		System.out.println(p.toString());
	}
}
