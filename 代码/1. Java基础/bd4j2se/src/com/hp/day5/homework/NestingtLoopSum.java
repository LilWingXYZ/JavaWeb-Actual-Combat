package com.hp.day5.homework;

/**
 * java中的循环嵌套
 * 求1＋（1＋2）＋（1＋2＋3）＋．．．．．．＋（1＋2＋3＋．．．．．．＋100）的和。
 * @author McGradyXYZ
 *
 */
public class NestingtLoopSum {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 100; i > 0; i--) {
			for(int j = 1; j <= i; j++) {
				sum += j;
			}
		}
		System.out.println(sum);
	}
}
