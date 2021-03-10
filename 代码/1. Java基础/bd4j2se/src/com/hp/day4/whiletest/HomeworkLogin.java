package com.hp.day4.whiletest;

import java.util.Scanner;

/**
 * 
 * @author McGradyXYZ
 *
 */

public class HomeworkLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean judge = false;
		do {
			System.out.println("请输入用户名：");
			String userName = sc.next();
			System.out.println("请输入密码：");
			String password = sc.next();
			if ("admin".equals(userName) && "111".equals(password)) {
				System.out.println("登录成功");
				judge = false;
			}
			else {
				System.out.println("用户名或密码不正确！请重新输入！");
				judge = true;
			}
		}while(judge);

	}

}
