package com.hp.day5.homework;

/**
 * 本金10000元存入银行，年利率是千分之三，每过1年，将本金和利息相加作为新的本金。计算5年后，获得的本金是多少？
 * @author McGradyXYZ
 *
 */
public class Principal {

	public static void main(String[] args) {
		double prin = 10000;
		double rate = 0.003;
		for(int i = 0; i < 5; i++) {
			prin += prin*rate;
		}
		System.out.println(prin);

	}

}
