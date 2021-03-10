package com.hp.day5.homework;

/**
 * 利用循环，实现下面数据的输出结果。
 *   1-3+5-7+…-99+101
 * @author McGradyXYZ
 *
 */
public class LoopAdd {

	public static void main(String[] args) {
		int addSum = 0;
		int lessSum = 0;
		int sum = 0;
		for(int i = 1; i <= 101; i=i+4) {
			addSum += i;
		}
		for(int j = 3; j <= 101; j=j+4) {
			lessSum += j;
		}
		sum = addSum - lessSum;
		System.out.println(sum);
	}

}
