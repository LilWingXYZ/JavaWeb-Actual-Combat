package com.hp.day4.whiletest;

import java.util.Scanner;

public class DoWhileTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入整数,如果是0，统计整数和负数结束");
		int positive = 0;
		int negative = 0;
		int number = 0;
		do{
			number = sc.nextInt();
			if(number>0)
				positive++;
			else if(number <0)
				negative++;
		}while(number != 0);
		System.out.println("正数的个数：" + positive);
		System.out.println("负数的个数是：" + negative);
	}

}
