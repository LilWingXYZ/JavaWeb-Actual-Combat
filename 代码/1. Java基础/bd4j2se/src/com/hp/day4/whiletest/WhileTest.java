package com.hp.day4.whiletest;

import java.util.Scanner;

/**
 * 从键盘读入个数不确定的整数，并判断读入的正数和负数的个数
 * @author McGradyXYZ
 *
 */
public class WhileTest {

	public static void main(String[] args) {
		/**
		 * 要有输入：Scanner
		 * 整数个数不确定：使用循环
		 * 读入正数和负数：分支
		 * 记录个数,存储
		 * 输入0表示结束：循环终止条件
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入整数");
		int positive = 0;
		int negative = 0;
		int number = sc.nextInt();
		while(number != 0){
			if (number > 0)
				positive++;
			else
				negative++;
			number = sc.nextInt();
		}
		System.out.println("正数的个数：" + positive);
		System.out.println("负数的个数是：" + negative);
	}

}
