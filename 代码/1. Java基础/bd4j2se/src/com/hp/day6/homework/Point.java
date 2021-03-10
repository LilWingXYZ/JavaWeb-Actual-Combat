package com.hp.day6.homework;

/**
 * 创建一个Point类，有成员变量x，y，方法getX(),setX()，还有一个构造方法初始化x和y。创建类主类A来测试它
 * @author McGradyXYZ
 *
 */
public class Point {
	
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getX() {
		return this.x;
	}

	public static void main(String[] args) {

	}

}
