package com.hp.day5.fortest;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		System.out.println("请输入一个正整数n:");
		Scanner sc = new Scanner(System.in);
		//记录输入的正整数
		int num = sc.nextInt();
		//记录求和
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("1~"+num+"的和为:"+sum);

	}

}
