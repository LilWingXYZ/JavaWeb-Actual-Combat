package com.hpe.po;

/**
 * 类描述: 账户信息实体类
 * 作者： zxy
 * 创建日期：2018年10月
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class Account {
	//账户ID
	private int accountId;
	
	//余额
	private double account_money;
	
	//用户ID
	private int userId;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAccount_money() {
		return account_money;
	}
	public void setAccount_money(double account_money) {
		this.account_money = account_money;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", account_money=" + account_money + ", userId=" + userId + "]";
	}
	
}
