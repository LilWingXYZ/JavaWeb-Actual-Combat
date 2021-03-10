package com.hp.day5.homework;

import java.util.Scanner;

/**
 * 任意输入一个整数（小于10位），求它的位数
 * @author McGradyXYZ
 *
 */
public class NumberOfDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输出一个整数（小于10位）：");
		int num = sc.nextInt();
		for(int i = 10; i > 0; i--) {
			int flag = (int)(num/Math.pow(10, i));
			if(flag != 0) {
				System.out.println("有"+(i+1)+"位");
				break;
			}
		}
	}

}
