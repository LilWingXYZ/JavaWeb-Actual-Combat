package com.hp.day10.abs;

/**
 * 
 * @author McGradyXYZ
 *
 */
public abstract class Animal {
	/**
	 * 不同的小动物，吃的行为不同，无法有统一的实现
	 * 所以，方法声明为抽象方法
	 * 方法的声明，声明没有方法体
	 * public abstract void eat();
	 * 方法的定义，
	 * 
	 */
	public abstract void eat();
	
	public static void main(String [] args) {
		/**
		 * 不能实例化一个抽象类
		 */
//		Animal animal = new Animal(); 
		/**
		 * abstract不能修饰属性
		 * abstract不能
		 */
	}
}
