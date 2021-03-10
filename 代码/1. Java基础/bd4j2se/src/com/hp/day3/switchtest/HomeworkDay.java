package com.hp.day3.switchtest;

import java.util.Scanner;

/**
 * 
 * @author McGradyXYZ
 *
 */
public class HomeworkDay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入2014年的月：");
			int month = sc.nextInt();
			int num = 0;
			int maxDay = 31;
			if(month < 1 || month > 12){
				System.out.println("请输入正确的月份！");
				continue;
			} else if (month == 2) {
				maxDay = 28;
			} else if(month == 4 || month == 6 || month == 9 || month == 11) {
				maxDay = 30;
			}
			System.out.println("请输入2014年的日：");
			int day = sc.nextInt();
			if (day<1 || day>maxDay) {
				System.out.println("请输入正确的日子！");
			} 
			else {
				switch(month-1) {
				case 12:
					num += 31;
				case 11:
					num += 30;
				case 10:
					num += 31;
				case 9:
					num += 30;
				case 8:
					num += 31;
				case 7:
					num += 31;
				case 6:
					num += 30;
				case 5:
					num += 31;
				case 4:
					num += 30;
				case 3:
					num += 31;
				case 2:
					num += 28;
				case 1:
					num += 31;
					break;
				default:
					break;
				}
				num += day;
				System.out.println("今天是2014年的第"+num+"天");
			}
		}
	
	}
}
