package com.hp.day3.iftest;

import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
//		System.out.println("请选择是否上晚自习？1：上晚自习，其他值:不要求");
		Scanner sc = new Scanner(System.in);
		//=是赋值，==是判断是否相等
//		int i = sc.nextInt();
//		System.out.println();
//		if(i==1){
//			System.out.println("上晚自习");
//		}
//		
//		int i1 = sc.nextInt();
//		if(i1 == 1){
//			//Sysout+alt+?快捷方式
//			System.out.println("上晚自习");
//		}
//		else{
//			System.out.println("happy");
//		}
//		
//		//使用ctrl+shift+F格式化代码
//		System.out.println("if-else-if");
//		int i2 = sc.nextInt();
//		if(i2==1){
//			System.out.println("上晚自习");
//		}
//		else if(i2 == 2){
//			System.out.println("听音乐");
//		}
//		else if(i2 == 3){
//			System.out.println("打篮球");
//		}
//		else if(i2 == 4){
//			System.out.println("看电影");
//		}
//		else{
//			System.out.println("聚餐");
//		}
//		
//		int j = 3;
//		//如果if-else中只有一行语句，{}可以省略
//		if(j==3)
//			System.out.println("打羽毛球");
		
		//作业练习
		while (true) {
			System.out.println("请输入一个分数：");
			int a = sc.nextInt();
			if (a < 0 || a > 100) {
				System.out.println("输入不正确");
			} else if (a >= 80) {
				System.out.println("优秀");
			} else if (a >= 60) {
				System.out.println("成绩合格");
			} else {
				System.out.println("成绩不合格");
			}
		}
		
		
		
		
	}

}
