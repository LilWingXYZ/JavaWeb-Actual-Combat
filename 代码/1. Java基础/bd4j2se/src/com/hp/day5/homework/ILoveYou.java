package com.hp.day5.homework;

import java.util.Scanner;

/**
 * 使用do-while循环：输出询问“我爱你，嫁给我吧？”，选择“你喜欢我吗？(y/n):"，
 * 如果输入为y则打印”我们形影不离“，若输入为n,则继续询问。
 * @author McGradyXYZ
 *
 */
public class ILoveYou {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String like = "n";
		do {
			System.out.println("我爱你，嫁给我吧？");
			System.out.println("你喜欢我吗？(y/n):");
		    like = sc.next();
			if("y".equals(like)) {
				System.out.println("我们形影不离");
				break;
			}
		}while("n".equals(like));

	}

}
