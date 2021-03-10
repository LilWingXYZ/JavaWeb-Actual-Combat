package com.hp.day6.homework;

public class TriangleTest {

	public static void main(String[] args) {
		Triangle tri = new Triangle();
		tri.side1 = 3;
		tri.side2 = 4;
		tri.side3 = 5;
		double perimeter = tri.getPerimeter(tri.side1,tri.side2,tri.side3);
		System.out.println(perimeter);
		}
}
