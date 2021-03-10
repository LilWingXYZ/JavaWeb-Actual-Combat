package com.hp.day8.cylinder;

public class Circle {
	private double radius;
	
	public Circle() {
		this.radius = 1;
	}
	
	public double findArea() {
		return Math.PI*this.radius*this.radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	
}
