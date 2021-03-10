package com.hp.day5.homework;

import java.util.Scanner;

/**
 * 求s=a+aa+aaa+aaaa+….+aa...a的值，其中a是一个数字。例如2+22+222+2222，a的值和加数个数n均从键盘获取。
 * @author McGradyXYZ
 *
 */
public class SameNumberSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入a的值：");
		double a = sc.nextDouble();
		System.out.println("请输入n的值：");
		double sum = 0.0;
		double common = 0.0;
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			sum += a*Math.pow(10, i-1);
			common += sum;
		}
		System.out.println(common);
	}

}
