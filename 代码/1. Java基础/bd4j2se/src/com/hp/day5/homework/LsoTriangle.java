package com.hp.day5.homework;

/**
 * 打印具有4行的等腰三角形(用循环来做)    
           *   
          ***  
         *****
        ******* 
 * @author McGradyXYZ
 *
 */
public class LsoTriangle {

	public static void main(String[] args) {
		int row = 4;
		String space = " ";
		for(int i = 1; i <= row; i++) {
			for(int j = 0; j<row-i; j++){
				System.out.print(space);
			}
			for(int k = 1; k <= 2*i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
