package com.hpe.view;

import java.util.Scanner;

import com.hpe.dao.UserDao;
import com.hpe.dao.impl.UserDaoImpl;
import com.hpe.po.Users;
import com.hpe.util.DateFormat;

public class UserUI {
	private static Scanner sc = new Scanner(System.in);
	private static UserDao userdao = new UserDaoImpl();
	private static Users user = null;

	/**
	 * 描述：用户登录 作者： zxy 创建日期：2019年02月20日 版本号： 1.0.0
	 */
	public void login() {
		int logincount = 1;
		while (true) {
			System.out.println("---------个人生活助手平台----------");
			System.out.println("***********用户登录*************");
			System.out.print("请输入用户名：");
			String username = sc.next();
			System.out.print("请输入密码：");
			String password = sc.next();
			user = userdao.login(username, password);
			if (user != null) {
				System.out.println("登录成功!");
				// 调用二级菜单
				menu();
			} else {
				if (++logincount > 3) {
					System.err.println("连续3次输入错误，请确认后登录！");
					return;
				} else {
					System.err.println("用户名或密码错误！");
				}

			}
		}
	}

	/**
	 * 描述：用户注册类 作者： zxy 创建日期：2019年02月21日 版本号： 1.0.0
	 */
	public void register() {
		while (true) {
			System.out.println("---------个人生活助手平台------------");
			System.out.println("************用户注册***************");
			System.out.print("请输入用户名：");
			String username = sc.next();
			System.out.print("请输入密码：");
			String password = sc.next();
			System.out.print("请输入真实姓名：");
			String realname = sc.next();
			System.out.print("请输入电话号码：");
			String tel = sc.next();
			System.out.print("请输入联系地址：");
			String address = sc.next();
			// 需求调用后台方法：用户名查重
			boolean flag = userdao.findByName(username);
			if (flag) {
				System.err.println("用户名已经存在，请重新注册！");
				return;
			}

			Users ruser = new Users(username, password, realname, tel, address, DateFormat.myDateFormat());
			Integer it = userdao.register(ruser);
			/*
			 * 回顾： Integer i=4;//自动装箱int-->Integer int x=4+8;//自动拆箱Integer-->int
			 */
			if (it != null) {
				System.out.println("恭喜您，注册成功！");
				user = ruser;
				user.setUserId(it);
				// 调用二级菜单
				menu();
			} else {
				System.out.println("注册失败");
			}
		}
	}

	/**
	 * 描述：二级菜单 作者： zxy 创建日期：2019年02月21日 版本号： 1.0.0
	 */
	public void menu() {
		System.out.println("---------个人生活助手平台------------");
		System.out.println(
				"***********[欢迎您，用户-" + user.getUserName() + "上次登录时间：" + user.getLogin_time() + "]****************");
		System.out.println("1、信息维护   2、修改密码  3、个人钱包  4、备忘录  5、娱乐天地  0：返回登录主菜单");
		System.out.println("---------个人生活助手平台------------");
		System.out.print("请选择业务：");
		int select = sc.nextInt();

		switch (select) {
		case 1:
			// 信息维护
			infoUpdate();
			menu();
			break;
		case 2:
			// 修改密码
			changePassword();
			break;
		case 3:
			// 个人钱包
			AccountUI.personWallent(user);
			break;
		case 4:
			// 备忘录
			MemorandumUI.Memorandum(user);
			break;
		case 5:
			// 娱乐天地
			RankingUI.rankMenu(user);
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("选择错误");
			break;
		}
	}

	/**
	 * 信息维护
	 */
	public void infoUpdate() {
			System.out.println("---------个人生活助手平台------------");
			System.out.println("************信息维护***************");
			System.out.println(user.toString());
			System.out.print("请输入手机号：");
			String number = sc.next();
			System.out.print("请输入地址：");
			String address = sc.next();
			// 调用dao层方法进行信息维护
			int i = userdao.infoUpdate(number, address, user.getUserId());
			if (i != 0) {
				System.out.println("更新成功！");
				System.out.println(user.toString());
			} else {
				System.err.println("更新失败！");
			}
			
	}

	/**
	 * 描述：修改密码 作者： zxy 创建日期：2019年02月21日 版本号： 1.0.0
	 */
	public void changePassword() {
		while (true) {
			System.out.println("请输入原密码");
			String oldpassword = sc.next();
			if (!oldpassword.equals(user.getUserPassword())) {
				System.out.println("您输入的原密码错误");
			} else {
				System.out.println("请输入新密码");
				String newpassword = sc.next();
				System.out.println("请输入确认密码");
				String newpassword2 = sc.next();
				if (!newpassword.equals(newpassword2)) {
					System.out.println("两次输入的一密码不一致");
				} else {
					// 调用dao层方法修改密码
					int i = userdao.updatePassword(newpassword, user.getUserId());
					if (i != 0) {
						System.out.println("密码修改成功");
						break;
					} else {
						System.out.println("修改失败");
					}
				}

			}
		}

	}
}