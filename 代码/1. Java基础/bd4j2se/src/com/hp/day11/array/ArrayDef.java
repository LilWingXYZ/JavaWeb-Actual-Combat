package com.hp.day11.array;

import java.util.Date;

import com.hp.day8.extend.Person;
import com.hp.day8.extend.Soldier;
import com.hp.day8.extend.Student;

/**
 * 
 * @author McGradyXYZ
 *
 */
public class ArrayDef {
	private int arr2[] = new int[3];
	public static void main(String[] args) {
		int arr[] = null;
		System.out.println(arr);
		ArrayDef ad = new ArrayDef();
		System.out.println("输入int类型数组的地址："+ad.arr2);
		System.out.println("输入int类型数组的第一个元素："+ad.arr2[0]);
		ad.arr2[1]=1;
		System.out.println("修改后的："+ad.arr2[1]);
		/**
		 * 数组中经常遇到的问题，Index
		 */
//		System.out.println(ad.arr2[3]);
		
		/**
		 * 相同数据类型的集合
		 */
		Student [] stuArray = new Student[2];
		stuArray[0] = new Student("zhang", 18, new Date(), "海大");
		
		//错误，想同数据类型的放到一起
//		stuArray[1] = new soldier();
		
		/**
		 * 数组，包括相同数据类型的子类
		 */
		Person [] personArray = new Person[2];
		personArray[0] = new Student("zhang", 18, new Date(), "海大");
		personArray[1] = new Soldier();
		
		//静态初始化的两种形式
		int [] a = new int[]{1,3,5};
		int [] a1 = {2,4,6};
		
		int [] a2 = new int[3];
		a2 = new int[4];
		
}
}
