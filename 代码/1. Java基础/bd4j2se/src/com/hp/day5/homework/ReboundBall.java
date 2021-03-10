package com.hp.day5.homework;

/**
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 * @author McGradyXYZ
 *
 */
public class ReboundBall {

	public static void main(String[] args) {
		double height = 100.0;
		double metersSum = height;
		for(int i = 1; i<10; i++) {
			height = height/2;
			metersSum += height*2;
		}
		height = height/2;
		System.out.println(metersSum+"  "+height);
	}

}
