package com.hp.day7.account;

/**
 * 写一个名为Account的类模拟账户。
 * 该类的属性和方法如下图所示。
 * 该类包括的属性：账号id，余额balance，年利率annualInterestRate；
 * 包含的方法：访问器方法（getter和setter方法），取款方法withdraw()，存款方法deposit()。
 *
 *提示：在提款方法withdraw中，
 *需要判断用户余额是否能够满足提款数额的要求，
 *如果不能，应给出提示。
 * @author McGradyXYZ
 *
 */
public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	
	public void withdraw(Customer costomer,double money) {
		if(costomer.getAccount().getBalance() < money) {
			System.out.println("余额不足,取款失败");
		}
		else {
			costomer.getAccount().setBalance(costomer.getAccount().getBalance() - money);
			System.out.println("成功取出："+money);
		}
	}
	
	public void deposit(Customer costomer,double money) {
		costomer.getAccount().setBalance(costomer.getAccount().getBalance() + money);
		System.out.println("成功存入："+money);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	
	
}
