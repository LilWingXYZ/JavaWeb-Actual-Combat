package com.hpe.view;

import java.util.List;
import java.util.Scanner;

import com.hpe.dao.MemorandumDao;
import com.hpe.dao.UserDao;
import com.hpe.dao.impl.MemorandumDaoImpl;
import com.hpe.dao.impl.UserDaoImpl;
import com.hpe.po.Memorandum;
import com.hpe.po.Users;
import com.hpe.util.DateFormat;

public class MemorandumUI {
	private static Scanner sc = new Scanner(System.in);
	private static Users currentuser = null;
	private static Memorandum memorandum = null;
	private static MemorandumDao memodao = new MemorandumDaoImpl();

	/**
	 * 备忘录三级菜单
	 * 
	 * @param user
	 */
	public static void Memorandum(Users user) {
		while (true) {
			currentuser = user;
			System.out.println("---------------------我的备忘录--------------------");
			System.out.println("********欢迎您，用户-" + user.getUserName() + "*********");
			System.out.println("1、查看备忘录   2、添加备忘录  3、修改备忘录  4、删除备忘录  0：返回主菜单");
			System.out.println("请选择业务：");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				// 查看备忘录
				queryMemorandum();
				break;
			case 2:
				// 添加备忘录
				addMemorandum();
				break;
			case 3:
				// 修改备忘录
				updateMemorandum();
				break;
			case 4:
				// 删除备忘录
				deleteMemorandum();
				break;
			case 0:
				return;
			default:
				System.out.println("选择错误，请重新选择");
				break;
			}
		}
	}

	/**
	 * 查看备忘录
	 */
	public static void queryMemorandum() {
		List<Memorandum> list = memodao.queryMemorandum(currentuser.getUserId());
		if (list != null && list.size() != 0) {
			for (Memorandum me : list) {
				System.out.print(me.getMemorandumId() + "\t");
				System.out.print(me.getMemorandum_title() + "\t");
				System.out.print(me.getContent() + "\t");
				System.out.print(me.getTime() + "\t");
				System.out.println();
			}
		} else {
			System.out.println("当前用户没有备忘录");
		}
	}

	/**
	 * 添加备忘录功能
	 */
	public static void addMemorandum() {
			System.out.println("------------我的备忘录-------------");
			System.out.println("************添加备忘录*************");
			System.out.println("请输入标题：");
			String memorandumTitle = sc.next();
			System.out.println("请输入内容：");
			String content = sc.next();
			Memorandum amemorandum = new Memorandum(memorandumTitle, DateFormat.myDateFormat(), content,
					currentuser.getUserId());
			Integer it = memodao.addMemorandum(amemorandum);
			if (it != null) {
				System.out.println("添加备忘录成功");
			} else {
				System.out.println("添加备忘录失败");
			}
	}

	/**
	 * 修改备忘录功能
	 */
	public static void updateMemorandum() {
		queryMemorandum();
		System.out.println("请输入备忘录编号：");
		int memoid = sc.nextInt();
		/*
		 * 查看一下输入的这个备忘录是否存在
		 */
		Memorandum memoisexist = memodao.queryByMemoId(memoid);
		if (memoisexist != null) {
			System.out.println("请输入备忘录标题：");
			String title = sc.next();
			System.out.println("请输入备忘录内容：");
			String content = sc.next();
			Memorandum memoupdate = new Memorandum(title, DateFormat.myDateFormat(), content, currentuser.getUserId());
			// 调用底层方法
			int f = memodao.updateMemorandum(memoupdate, memoid);
			if (f != 0) {
				System.out.println("备忘录修改成功");
			} else {
				System.out.println("备忘录修改失败");
			}
		} else {
			System.out.println("当前编号的备忘录不存在");
		}

	}

	/**
	 * 刪除备忘录功能
	 */
	public static void deleteMemorandum() {
			System.out.println("------------我的备忘录-------------");
			System.out.println("************删除备忘录*************");
			queryMemorandum();
			System.out.println("请输入要删除的备忘录编号：");
			int memoid = sc.nextInt();
			/*
			 * 查看一下输入的这个备忘录是否存在
			 */
			Memorandum memoisexist = memodao.queryByMemoId(memoid);
			if (memoisexist != null) {
				System.out.println("确定删除吗？ y/n：");
				String isDelete = sc.next();
				if (isDelete.equals("y")) {
					int f = memodao.deleteMemorandum(memoid);
					if (f != 0) {
						System.out.println("备忘录删除成功");
					} else {
						System.out.println("备忘录删除失败");
					}
				} else if (isDelete.equals("n")) {
					
				}
			} else {
				System.out.println("当前编号的备忘录不存在");
			}
		}
}
