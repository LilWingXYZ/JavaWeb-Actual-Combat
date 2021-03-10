package com.hp.day5.homework;

import java.util.Scanner;

/**
 * 从控制台接收两个数字，利用变量将这两个数字进行互换，并输出。
 * @author McGradyXYZ
 *
 */
public class NumberChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入两个数字");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int temp = num1;
		num1 = num2;
		num2 = temp;
		System.out.println(num1+" "+num2);
	}

}
