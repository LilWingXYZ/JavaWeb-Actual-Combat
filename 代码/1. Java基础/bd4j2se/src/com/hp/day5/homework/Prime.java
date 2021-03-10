package com.hp.day5.homework;

/**
 * 编程判断1-200之间有多少个素数，并输出所有素数。
 * @author McGradyXYZ
 *
 */

public class Prime {
	public static void main(String [] args) {
		int priNum = 0;
		for(int i = 1; i <= 200; i++) {
			int num = 0;
			for(int j = 1; j <= 200; j++) {
				if(num > 2) {
					break;
				}
				for(int k = 1; k <= 200; k++) {
					if(i == j*k) {
						num++;
						if(num > 2){
							break;
						}
					}
				}
			}
			if(num == 2) {
				System.out.print(i+" ");
				priNum++;
			}
		}
		System.out.println();
		System.out.println("共有"+priNum+"个素数");
	}
}
