package com.hp.day5.fortest;

public class HomeworkMultTable {

	public static void main(String[] args) {
		for(int i = 1; i <= 9; i++ ) {
			for(int j = 1; j <=9; j++) {
				System.out.print(i+ "X"+j+"="+(i*j)+"\t");
			}
			System.out.println();
		}
		
		System.out.println();

		for(int i = 1; i <= 9; i++ ) {
			for(int j = 1; j <=i; j++) {
				System.out.print(j+ "X"+i+"="+(i*j)+"\t");
			}
			System.out.println();
		}
	}

}

