package com.hp.day5.homework;

/**
 * 输出一个用*组成的矩形，如：
     ********* 
     *       *   
     *       *
     *       *
     *********
思路：1、定义一个方法输出一个矩形
      2、在主方法中调用矩形方法，给予不同的长和宽
      
 * @author McGradyXYZ
 *
 */
public class StarRectangle {
	
	public static void rectangle(int lenth, int width) {
		for(int i = 0; i < width; i++) {
			if(i == 0 || i == width-1){
				for(int j = 0; j < lenth; j++) {
						System.out.print("*");
				}
			}
			else {
				System.out.print("*");
				for(int k = 0; k < lenth-2; k++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		rectangle(9,5);
	}

}
