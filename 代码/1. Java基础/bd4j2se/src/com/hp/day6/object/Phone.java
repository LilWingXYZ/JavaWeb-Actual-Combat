package com.hp.day6.object;

/**
 * 类定义：<修饰符> class 类名{
 *   成员变量
 *   方法
 * }
 * 在一个类文件中尽量只写一个类
 * 类名和文件名要完全一致
 * 一个类文件中至少要有一个public类型的类
 * @author McGradyXYZ
 *
 * debug 在执行过程中遇到方法调用，如果F6，则直接执行完方法
 * 如果想进入方法，按F5
 */
public class Phone {
	/*
	 * 描述属性时要有数据类型：数据类型，基本数据类型，引用数据类型
	 * 有用的描述作为成员变量，没有用的可以不写
	 * 在类中，方法外的变量是成员变量
	 */
	String brand;
	String size;
	int price;
	
	/**
	 * 修饰符 返回类型 方法名（[参数列表]）{
	 * 方法体
	 * }
	 * 访问修饰符有4种：
	 */
	/**
	 * 打电话功能
	 * @param num  拨打的手机号
	 */
	public void call(int num){
		
	}
	
	public static void main(String[] args) {
		/**
		 * 可以通过new + 类名() 创建具体对象
		 */
		Phone phone1 = new Phone();
		phone1.brand = "hw";
		//在赋值时要符合定义的数据类型
		phone1.price = 2500;
		phone1.size = "6.0";
		System.out.println(phone1);

		//通过类可以创建多个对象
		Phone phone2 = new Phone();
		phone2.brand = "oppo";
		
		//方法的调用使用对象.方法(不包括static方法)
		
	}

}
