package com.hp.day8.cylinder;

public class Cylinder extends Circle {
	private double length;
	
	public Cylinder() {
		this.length = 1;
	}
	
	public double findVolume() {
		return findArea()*length;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	
}
