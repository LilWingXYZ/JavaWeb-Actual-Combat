package com.hpe.view;

import java.util.Scanner;

import com.hpe.dao.AccountDao;
import com.hpe.dao.impl.AccountDaoImple;
import com.hpe.po.Account;
import com.hpe.po.AccountLog;
import com.hpe.po.Users;
import com.hpe.util.DateFormat;

public class AccountUI {
	private static Scanner sc=new Scanner(System.in);
	private static Account account=null;
	private static AccountDao accountdao=new AccountDaoImple();
	private static Users currentuser=null;
	/**
	 * 描述：个人钱包三级菜单
	 * 作者： zxy
	 * 创建日期：2019年02月22日
	 * 版本号： 1.0.0
	 */
	public static void personWallent(Users user) {
		while(true) {
		 currentuser=user;
		 account=accountdao.queryMoney(user.getUserId());
		 System.out.println("--------------个人钱包----------------");
		 System.out.println("1、查看余额   2、存钱  3、转账  4、统计查询  0：返回");
		 System.out.println("请选择业务：");
	     int select=sc.nextInt();
	       switch(select) {
	       case 1:
	         	//查看余额
	    	   queryMoney();
	           break;
	       case 2:
	       	    //存钱
	    	    saveMoney();
	         	break;
	       case 3:
	          	//转账
	    	   transferMoney();
	          	break;
	       case 4:
	          	//统计查询
	    	   staticsQuery();
	          	break;
	       case 0:
		       	account=null;
		       	break;
	       default:
	    	   System.out.println("选择错误，请重新选择");
	       	break;
	}}
	}
	/**
	 * 描述：查询账户余额
	 * 作者： zxy
	 * 创建日期：2019年02月22日
	 * 版本号： 1.0.0
	 */
	public static void queryMoney() {
	
		System.out.println("您的账号是："+account.getAccountId()+",您的余额是："+account.getAccount_money());
	}
	/**
	 * 描述：存钱模块
	 * 作者： zxy
	 * 创建日期：2019年02月22日
	 * 版本号： 1.0.0
	 */
	public static void saveMoney() {
		 System.out.println("--------------个人钱包----------------");
		 System.out.println("***************存钱*****************");
		 System.out.println("请输入金额：");
		 double money=sc.nextDouble();
		 /*调用dao层方法实现存钱
		  * 1、方法返回值：存钱成功与否（boolean,int）
		  * 2、方法参数AccountLog对象
		 */
		 AccountLog accountlog=new AccountLog();
		 accountlog.setAccountId(account.getAccountId());
		 accountlog.setTransfer_account(account.getAccountId());
		 accountlog.setType("转入");
		 accountlog.setMoney(money);
		 accountlog.setLog_time(DateFormat.myDateFormat());
		 boolean flag=accountdao.savaMoney(accountlog,currentuser.getUserId());
	     if(flag) {
	    	 System.out.println("您存钱成功");
	     }else {
	    	 System.out.println("您存钱失败");
	     }
	}
	/*
	 * 转账：
	 *   输入金额：判断一下你当前的账户余额是否够
	 *   输入转账的账号：判断一下这个账号是否存在
	 *   转账
	 */
	public static void  transferMoney() {
		while(true) {
		 System.out.println("--------------个人钱包----------------");
		 System.out.println("***************转账*****************");
		 System.out.println("请输入对方账号：");
		 int transferaccountid=sc.nextInt();
		 //需要调用dao层方法，判断输入的账号是否存在
		 boolean flag=accountdao.isExistAccount(transferaccountid);
	     if(!flag) {
	    	 System.out.println("您输入的账号不存在，请重新输入");
	    	 continue;
	     }
	     System.out.println("请输入金额：");
		 double money=sc.nextDouble();
		 //判断当前输入的金额与你账户的余额的大小
		 double currentmoney=account.getAccount_money();
		 if(money-currentmoney>0) {
			 System.out.println("您的账户余额不足");
			 return;
		 }
		 //如果账户余额足够，实现转账
		 AccountLog accountlog=new AccountLog();
		 accountlog.setAccountId(account.getAccountId());
		 accountlog.setTransfer_account(transferaccountid);
		 accountlog.setType("转出");
		 accountlog.setLog_time(DateFormat.myDateFormat());
		 accountlog.setMoney(money);
		 boolean f=accountdao.transferMoney(accountlog, account.getUserId());
	     if(f) {
	    	 System.out.println("您转账成功");
	    	 return;
	     }else {
	    	 System.out.println("转账失败");
	     }
	     
		}
	}
	/**
	 * 描述：统计查询模块
	 * 作者： zxy
	 * 创建日期：2019年02月24日
	 * 版本号： 1.0.0
	 */
	public static void staticsQuery() {
		//统计当月收入：当transfer_accountid是我自己时，本条记录就是收入，type="转入"
		AccountLog accountlog=new AccountLog();
		accountlog.setTransfer_account(account.getAccountId());
		//调用dao层方法进行统计
		double inmoney=accountdao.inMoney(accountlog);
		System.out.println("您当月的收入是"+inmoney+"元");
		
		
		//统计当月的支出：accountId是我自己，而type=“转出”
		accountlog.setAccountId(account.getAccountId());
		accountlog.setType("转出");
		//调用dao层方法进行统计
		double outmoney=accountdao.OutMoney(accountlog);
		System.out.println("您当月的支出是"+outmoney+"元");
	}
	
}
