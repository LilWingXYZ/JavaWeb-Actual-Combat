package com.hpe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hpe.dao.AccountDao;
import com.hpe.po.Account;
import com.hpe.po.AccountLog;
import com.hpe.po.Users;
import com.hpe.util.DBUtil;
import com.hpe.util.DateFormat;

public class AccountDaoImple implements AccountDao{

	@Override
	public Account queryMoney(int userid) {
		//1、准备sql
		StringBuffer sql=new StringBuffer();
		sql.append("select * from account where userId=?");
		//2、链接数据库
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Account account=null;
		//3、预编译sql
		try {
			 pst=con.prepareStatement(sql.toString());
		     pst.setInt(1, userid);
		    
		 //4、执行sql
		      rs=pst.executeQuery();
		      while(rs.next()) {
		    	account=new Account();
		    	account.setUserId(userid);
		    	account.setAccountId(rs.getInt("accountId"));
		    	account.setAccount_money(rs.getDouble("account_money"));
		      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.realseDB(rs, pst, con);
		}
		return account;
		
	}

	@Override
	public boolean savaMoney(AccountLog accountlog,int userid) {
		
		    //1、准备sql
				StringBuffer sql=new StringBuffer();
				sql.append("update account set account_money=account_money+? where userId=?");
				
				//2、链接数据库
				Connection con=DBUtil.getConnection();
				PreparedStatement pst=null;
				boolean flag=false;
				//3、开启事务
				try {
					con.setAutoCommit(false);
					//调用prepareStatement方法，能够获取生成的主键
					pst=con.prepareStatement(sql.toString());
					pst.setDouble(1, accountlog.getMoney());
					pst.setInt(2, userid);
					pst.executeUpdate();
					DBUtil.realseDB(null, pst, null);
					/*
					 * 自动生成个人账户，向账户表里写入一条数据 
					 */
					PreparedStatement pst2=null;
					String sql2="insert into account_log(accountId,transfer_account,type,log_time,money) values(?,?,?,?,?)";
					pst2=con.prepareStatement(sql2);
					pst2.setInt(1, accountlog.getAccountId());
					pst2.setInt(2, accountlog.getTransfer_account());
					pst2.setString(3, accountlog.getType());
					pst2.setString(4, accountlog.getLog_time());
					pst2.setDouble(5, accountlog.getMoney());
					pst2.executeUpdate();
					//提交事务
					con.commit();
					flag=true;
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return flag;
	}

	@Override
	public boolean isExistAccount(int accountid) {
		
		//1、准备sql
				StringBuffer sql=new StringBuffer();
				sql.append("select count(*) as accountid from account");
				sql.append(" where accountId=?");
				//2、链接数据库
				Connection con=DBUtil.getConnection();
				PreparedStatement pst=null;
				ResultSet rs=null;
				boolean flag=false;
				//3、预编译sql
				try {
					 pst=con.prepareStatement(sql.toString());
				     pst.setInt(1, accountid);
				    
				 //4、执行sql
				      rs=pst.executeQuery();
				      while(rs.next()) {
				        flag=rs.getInt("accountid")>0?true:false;
				      }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtil.realseDB(rs, pst, con);
				}
				return flag;
	}

	@Override
	public boolean transferMoney(AccountLog accountlog, int userid) {
		//1、准备sql1,从当前账户减钱
		StringBuffer sql=new StringBuffer();
		sql.append("update account set account_money=account_money-? where userId=?");
		
		//2、链接数据库
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		boolean flag=false;
		//3、开启事务
		try {
			con.setAutoCommit(false);
			//调用prepareStatement方法，能够获取生成的主键
			pst=con.prepareStatement(sql.toString());
			pst.setDouble(1, accountlog.getMoney());
			pst.setInt(2, userid);
			pst.executeUpdate();
			DBUtil.realseDB(null, pst, null);
		
		//4、向转账账户加钱
		String sql2="update account set account_money=account_money+? where accountId=?";
		PreparedStatement pst2=null;
		pst=con.prepareStatement(sql2);
		pst.setDouble(1, accountlog.getMoney());
		pst.setInt(2, accountlog.getTransfer_account());
		pst.executeUpdate();
		DBUtil.realseDB(null, pst, null);	
			/*
			 * 自动生成个人账户，向账户表里写入一条数据 
			 */
			PreparedStatement pst3=null;
			String sql3="insert into account_log(accountId,transfer_account,type,log_time,money) values(?,?,?,?,?)";
			pst2=con.prepareStatement(sql3);
			pst2.setInt(1, accountlog.getAccountId());
			pst2.setInt(2, accountlog.getTransfer_account());
			pst2.setString(3, accountlog.getType());
			pst2.setString(4, accountlog.getLog_time());
			pst2.setDouble(5, accountlog.getMoney());
			pst2.executeUpdate();
			//提交事务
			con.commit();
			flag=true;
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public double inMoney(AccountLog accountlog) {
		//1、准备sql
		StringBuffer sql=new StringBuffer();
		sql.append("select sum(money) as money from account_log ");
	    sql.append(" where transfer_account=? and log_time like ?");
		//2、链接数据库
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
	    double money=0;
		//3、预编译sql
		try {
			 pst=con.prepareStatement(sql.toString());
		     pst.setInt(1, accountlog.getTransfer_account());
		     String s=DateFormat.myDateFormat();
		     pst.setString(2, s.substring(0, 7)+"%");
		    
		 //4、执行sql
		      rs=pst.executeQuery();
		      while(rs.next()) {
		       money=rs.getInt("money");
		      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.realseDB(rs, pst, con);
		}
		return money;
	}

	@Override
	public double OutMoney(AccountLog accountlog) {
		
		//1、准备sql
				StringBuffer sql=new StringBuffer();
				sql.append("select sum(money) as money from account_log ");
			    sql.append(" where accountId=?  and log_time like ? and type =?");
				//2、链接数据库
				Connection con=DBUtil.getConnection();
				PreparedStatement pst=null;
				ResultSet rs=null;
			    double money=0;
				//3、预编译sql
				try {
					 pst=con.prepareStatement(sql.toString());
				     pst.setInt(1, accountlog.getAccountId());
				     String s=DateFormat.myDateFormat();
				     pst.setString(2, s.substring(0, 7)+"%");
				     pst.setString(3, accountlog.getType());
				    
				 //4、执行sql
				      rs=pst.executeQuery();
				      while(rs.next()) {
				       money=rs.getInt("money");
				      }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtil.realseDB(rs, pst, con);
				}
				return money;
	}
	

}
