package com.hpe.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.hpe.dao.RankingDao;
import com.hpe.dao.impl.RankingDaoImpl;
import com.hpe.po.Memorandum;
import com.hpe.po.Ranking;
import com.hpe.po.Users;
import com.hpe.util.DateFormat;

public class RankingUI {
	private static Scanner sc = new Scanner(System.in);
	private static Users currentuser = null;
	private static RankingDao rankdao = new RankingDaoImpl();

	public static void rankMenu(Users user) {
		while (true) {
			currentuser = user;
			System.out.println("-----------个人生活助手平台------------");
			System.out.println("--------------娱乐天地-------------");
			System.out.println("1、猜拳游戏   2、游戏排行榜   0：返回主菜单");
			System.out.println("请选择相关业务：");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				// 1.猜拳游戏
				guessGame();
				break;
			case 2:
				// 2.游戏排行榜
				score();
				break;
			case 0:
				currentuser = null;
				return;
			default:
				System.out.println("输入错误，请重新选择");
				break;
			}
		}
	}

	/**
	 * 猜拳游戏
	 */
	public static void guessGame() {
		int score = 0;
		System.out.println("--------------娱乐天地-------------");
		System.out.println("--------------猜拳游戏-------------");
		while (true) {
			System.out.println("请出拳：1、石头   2、剪刀   3：布");
			int unum = sc.nextInt();
			// 用户输入的是什么
			String userselect = play(unum);
			String computer = play(new Random().nextInt(3) + 1);
			int i = compare(userselect, computer);
			if (i == 1) {
				score++;
			} else if (i == -1) {
				Ranking r = new Ranking();
				r.setIntegral(score);
				r.setUserId(currentuser.getUserId());
				r.setTime(DateFormat.myDateFormat());
				// 写入数据库
				rankdao.guessScore(r);
				return;
			}
		}

	}

	/**
	 * 根据输入的整数转化为字符串
	 */
	public static String play(int num) {
		return num == 1 ? "石头" : (num == 2 ? "剪刀" : "布");
	}

	/**
	 * 比较用户和电脑
	 */
	public static int compare(String user, String computer) {
		if (user.equals(computer)) {
			System.out.println("平局");
			return 0;
		} else if (user.equals("石头") && computer.equals("剪刀") || user.equals("剪刀") && computer.equals("布")
				|| user.equals("布") && computer.equals("石头")) {
			System.out.println("恭喜你，你赢了");
			return 1;
		} else {
			System.out.println("您输了，游戏结束");
			return -1;
		}
	}
	
	/**
	 * 游戏排行榜
	 */
	public static void score() {
		System.out.println("--------------娱乐天地-------------");
		System.out.println("*************游戏排行榜*************");
		int i = 0;
		System.out.println("排名"+"\t"+"姓名"+"\t"+"积分"+"\t"+"时间");
		List<Ranking> list = rankdao.score();
		if (list != null && list.size() != 0) {
			for (Ranking r : list) {
			System.out.print(++i + "\t");
			System.out.print(r.getUserName()+"\t");
			System.out.print(r.getIntegral() + "\t");
			System.out.print(r.getTime());
			System.out.println();
			}
		}else {
			System.out.println("当前没有游戏排行榜");
		}
		
	}
		
}
	
