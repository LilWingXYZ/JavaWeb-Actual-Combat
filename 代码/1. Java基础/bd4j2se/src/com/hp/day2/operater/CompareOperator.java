package com.hp.day2.operater;

/**
 * 比较运算符
 * @author McGradyXYZ
 *
 */
public class CompareOperator {
	
	public static void main(String[] args) {
		System.out.println("4等于3吗"+(4==3));
		/**
		 * String类型是类引用数据类型
		 * 根据类命名规范判断，应该是类或接口
		 * 字符串的比较使用equals方法
		 * 
		 * 一般情况下，比较两个对象（字符串），一般常量放前面，变量放后面
		 * 变量不可控
		 */
		String name = "zhang";
		System.out.println("name的值是wang吗"+"wang".equals(name));
	}

}
