package com.hp.day6.homework;

/**
 * （1）创建一个叫做机动车的类：
	属性：车牌号(String)，车速(int)，载重量(double)
	功能：加速(车速自增)、减速(车速自减)、修改车牌号，查询车的载重量。
	编写两个构造方法：一个没有形参，在方法中将车牌号设置“XX1234”，速
	度设置为100，载重量设置为100；另一个能为对象的所有属性赋值；

 * @author McGradyXYZ
 *
 */
public class Vehicle {
	
	String number;
	int speed;
	double weight;
	
	public Vehicle() {
		this.number = "XX1234";
		this.speed = 100;
		this.weight = 100;
	}
	
	public Vehicle(String number, int speed, double weight) {
		this.number = number;
		this.speed = speed;
		this.weight = weight;
	}
	
	public void speedUp() {
		this.speed++;
	}
	
	public void speedDown() {
		this.speed--;
	}
	
	public void updateNumber(String number) {
		this.number = number;
	}
	
	public double findWeight() {
		return this.weight;
	}
	
	public static void main(String[] args) {
		

	}

}
