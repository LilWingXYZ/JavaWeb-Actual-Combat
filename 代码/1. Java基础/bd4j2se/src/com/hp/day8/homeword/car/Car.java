package com.hp.day8.homeword.car;

/**
 * final修饰的变量只可以初始化一次
 * 可以在成员变量定义的时候初始化
 * 也可以在构造方法中初始化
 * 初始化后值不能被修改
 * @author McGradyXYZ
 *
 */
public class Car {
	private final String brand;
	
	public Car() {
		this.brand = "";
	}
	
	public Car(String brand) {
		this.brand = brand;
	}
	
	public void drive() {
		
	}

	public String getBrand() {
		return brand;
	}
	
	public static void main(String[] args) {
		Car car = new Car("Audi");
	}
	
}
