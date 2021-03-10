package com.hp.day5.homework;

/**
 * 计算出1—100之间所有不能被3整除的整数的和大于(或等于)2000的数字。
 * @author McGradyXYZ
 *
 */
public class DivisibleSum2 {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i%3 != 0) {
				sum += i;
				if(sum > 2000) {
					System.out.println(i);
					break;
				}
			}
		}
		
	}

}
