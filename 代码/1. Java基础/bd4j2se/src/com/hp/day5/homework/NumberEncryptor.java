package com.hp.day5.homework;

import java.util.Scanner;

/**
 * 实现一个数字加密器，加密规则是：加密结果 = （整数*10+5）/2 + 3.14159 
 * 加密结果仍为一整数(数字从控制台输入)
 * @author McGradyXYZ
 *
 */
public class NumberEncryptor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int num = sc.nextInt();
		int encryptor = (int)((num*10+5)/2 + 3.14159);
		System.out.println("加密后的数为："+encryptor);

	}

}
