package com.hp.day3.switchtest;

import java.util.Scanner;

/**
 * 根据用户
 * @author McGradyXYZ
 *
 */

public class HomeworkSeason {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入月份：");
			int month = sc.nextInt();
			if(month<1 || month>12) {
				System.out.println("请输入正确的月份！");
			}
			else {
				switch(month) {
				case 3:
				case 4:
				case 5:
					System.out.println("春季");
					break;
				case 6:
				case 7:
				case 8:
					System.out.println("夏季");
					break;
				case 9:
				case 10:
				case 11:
					System.out.println("秋季");
					break;
				default:
					System.out.println("冬季");
					break;
				}
			}
		}
	}

}
