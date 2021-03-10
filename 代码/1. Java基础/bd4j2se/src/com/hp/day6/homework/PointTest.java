package com.hp.day6.homework;

public class PointTest {

	public static void main(String[] args) {
		Point p1 = new Point(3, 5);
		System.out.println("("+p1.x+","+p1.y+")");
		p1.setX(4);
		System.out.println("("+p1.x+","+p1.y+")");
		p1.setX(5);
		double x = p1.getX();
		System.out.println(x);
	}

}
