package com.hp.day5.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 任意输入5个整数，从小到大的顺序输出，再任意输入1个整数，仍要求所有数按从小到大的顺序输出。
 * @author McGradyXYZ
 *
 */
public class Sort {
	public static void main(String [] args) {
		ArrayList list = new ArrayList();
		System.out.println("请输入5个整数：");
		Scanner sc = new Scanner(System.in);
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		Collections.sort(list);
		System.out.println("排序后为："+list);
		System.out.println("请再输入1个整数：");
		list.add(sc.nextInt());
		Collections.sort(list);
		System.out.println("排序后为："+list);
		Collections.reverse(list);
		System.out.println("倒序排列为"+list);
	}
}
