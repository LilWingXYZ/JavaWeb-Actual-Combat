package com.hpe.view;

import java.util.Scanner;

public class MainUI {
	private static Scanner sc=new Scanner(System.in);
	

	public static void main(String[] args) {
		while(true) {
		System.out.println("---------个人生活助手平台---------");
		System.out.println("***********1、登录*************");
		System.out.println("***********2、注册*************");
		System.out.println("***********0、退出*************");
		System.out.println("-----------------------------");
        System.out.print("请选择：");
        int select=sc.nextInt();
        UserUI userui=new UserUI();
        switch(select) {
        case 1:
        	//登录
        	userui.login();
        	break;
        case 2:
        	//注册
        	userui.register();
        	break;
        case 0:
        	System.out.println("谢谢使用！");
        	System.exit(0);
        	break;
        default:
        	break;
        }
		}
	}

}
