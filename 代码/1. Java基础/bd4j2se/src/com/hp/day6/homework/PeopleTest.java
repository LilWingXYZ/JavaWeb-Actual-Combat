package com.hp.day6.homework;

/**
 * （2）创建主类：
	创建一个对象：名叫“张三”，性别“男”，年龄18岁，身高1.80；
	让该对象调用成员方法：
	说出“你好！”
	计算23+45的值
	将名字改为“李四”
	
 * @author McGradyXYZ
 *
 */
public class PeopleTest {

	public static void main(String[] args) {
		People people1 = new People("张三" , 18, "男", 1.80);
		System.out.println(people1.name+people1.age+people1.gender+people1.height);
		people1.speak("你好!");
		double addition = people1.addition(23,45);
		System.out.println(addition);
		people1.updateName("李四");
		System.out.println(people1.name+people1.age+people1.gender+people1.height);
	}

}
