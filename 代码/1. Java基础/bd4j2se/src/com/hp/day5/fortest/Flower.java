package com.hp.day5.fortest;

import java.util.Scanner;

public class Flower {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= 999; i++) {
			int hundred = i / 100;
			int ten = i / 10 % 10;
			int one = i % 10;
			if(i == Math.pow(hundred, 3)+Math.pow(ten, 3)+Math.pow(one, 3)) {
				System.out.println(i);
			}
		}

	}

}
