package com.hpe.dao;

import com.hpe.po.Account;
import com.hpe.po.AccountLog;

public interface AccountDao {
	//查询余额
	public Account queryMoney(int userid);
    //存钱
	public boolean savaMoney(AccountLog accountlog,int userid);
	//判断账户是否存在
	public boolean isExistAccount(int accountid);
	/*
	 * 转账
	 * 返回值：boolean,int或对象类型
	 * 参数：accountlog,userid
	 * 转账操作：
	 * 1、update account set account_money=account-?  where userid=?
	 * 2、update account set account_money=account+?  where accountid=?
	 * 3、insert into account_log(accountId,transfer_account,type,log_time,money) values(?,?,?,?,?)
	 * transfer_account：你从前台输入的账号
	 * type：转出
	 */
	public boolean transferMoney(AccountLog accountlog,int userid);
	//统计收入
	public double inMoney(AccountLog accountlog);
	//统计支出
	public double OutMoney(AccountLog accountlog);
}
