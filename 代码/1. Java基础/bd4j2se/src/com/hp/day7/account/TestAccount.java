package com.hp.day7.account;

/**
 *  写一个测试程序。
	（1）	创建一个Customer ，名字叫 Jane Smith, 他有一个账号为1000，余额为2000元，年利率为 1.23％ 的账户。
	（2）	对Jane Smith操作。
	存入 100 元，再取出960元。再取出2000元。
	打印出Jane Smith 的基本信息

 * @author McGradyXYZ
 *
 */
public class TestAccount {
	public static void main(String[] args) {
		Customer cu = new Customer("Jane","Smith");
		Account ac = new Account();
		ac.setId(1000);
		ac.setBalance(2000);
		ac.setAnnualInterestRate(0.0123);
		cu.setAccount(ac);
		cu.getAccount().deposit(cu,100);
		cu.getAccount().withdraw(cu, 960);
		cu.getAccount().withdraw(cu, 2000);
		System.out.println("Customer["+cu.getFirstName()+" "+cu.getLastName()+"] has a account: id is "+cu.getAccount().getId()+",annualInterestRate is "+cu.getAccount().getAnnualInterestRate()*100+"%,balance is "+cu.getAccount().getBalance());
		
	}
}
