package com.hpe.po;

import java.util.Date;

/**
 * 类描述：
 * 作者： zxy
 * 创建日期：2018年11月21日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class AccountLog {
	
	//操作日志ID
	private int log_id;
	
	//账户ID
	private int accountId;
	
	//转入账户
	private int transfer_account;
	
	//转入或者转出
	private String type;
	
	//操作时间
	private String log_time;
	
	//金额
	private double money;
	
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getTransfer_account() {
		return transfer_account;
	}
	public void setTransfer_account(int transfer_account) {
		this.transfer_account = transfer_account;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLog_time() {
		return log_time;
	}
	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}
