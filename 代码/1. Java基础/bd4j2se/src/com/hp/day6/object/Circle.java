package com.hp.day6.object;

public class Circle {
	//圆的半径
	double radius;
	
	/**
	 * 计算圆的面积
	 * @param radius 半径
	 * @return
	 */
	public double getArea(double radius) {
//		return Math.PI*radius*radius;
		return Math.PI*Math.pow(radius, 2);
	}
	
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.radius = 2;
		double area = circle.getArea(circle.radius);
		System.out.println(area);

	}

}
