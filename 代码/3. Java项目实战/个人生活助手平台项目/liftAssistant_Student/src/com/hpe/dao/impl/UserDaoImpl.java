package com.hpe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hpe.dao.UserDao;
import com.hpe.po.Users;
import com.hpe.util.DBUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public Users login(String username,String password) {
		//1、准备sql
		StringBuffer sql=new StringBuffer();
		sql.append("select * from users where userName=? and userPassword=?");
		//2、链接数据库
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Users user=null;
		//3、预编译sql
		try {
			 pst=con.prepareStatement(sql.toString());
		     pst.setString(1, username);
		     pst.setString(2, password);
		 //4、执行sql
		      rs=pst.executeQuery();
		      while(rs.next()) {
		    	user=new Users();
		    	user.setUserId(rs.getInt("userId"));
		    	user.setUserName(rs.getString("userName"));
		    	user.setUserPassword(rs.getString("userPassword"));
		    	user.setTel(rs.getString("tel"));
		    	user.setRealName(rs.getString("realName"));
		    	user.setAddress(rs.getString("address"));
		    	user.setLogin_time(rs.getString("login_time"));
		      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.realseDB(rs, pst, con);
		}
		return user;
	}

	@Override
	public Integer register(Users user) {
		//1、准备sql
		StringBuffer sql=new StringBuffer();
		sql.append("insert into users(userName,userPassword,realname,tel,address,login_time)");
		sql.append(" values(?,?,?,?,?,?)");
		Object[] args= {user.getUserName(),user.getUserPassword(),user.getRealName(),
				user.getTel(),user.getAddress(),user.getLogin_time()};
		//2、链接数据库
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Integer keyword=null;
		//3、开启事务
		try {
			con.setAutoCommit(false);
			//调用prepareStatement方法，能够获取生成的主键
			pst=con.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			for(int i=0;i<args.length;i++) {
				pst.setObject(i+1, args[i]);
			}
			pst.executeUpdate();
			//获取userid
			rs=pst.getGeneratedKeys();
			if(rs.next()) {
				keyword=rs.getInt(1);
			}
			DBUtil.realseDB(rs, pst, null);
			/*
			 * 自动生成个人账户，向账户表里写入一条数据 
			 */
			PreparedStatement pst2=null;
			String sql2="insert into account(account_money,userId) values(?,?)";
			pst2=con.prepareStatement(sql2);
			pst2.setDouble(1, 0);
			pst2.setInt(2, keyword);
			pst2.executeUpdate();
			//提交事务
			con.commit();
			
		} catch (SQLException e) {
			//如果主键没有生成，整个事务回滚
			if(keyword==null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		return keyword;
	}

	@Override
	public boolean findByName(String username) {
		//1、准备sql
		      StringBuffer sql=new StringBuffer();
				sql.append("select * from users where userName=?");
				//2、链接数据库
				Connection con=DBUtil.getConnection();
				PreparedStatement pst=null;
				ResultSet rs=null;
			    boolean f=false;
				//3、预编译sql
				try {
					 pst=con.prepareStatement(sql.toString());
				     pst.setString(1, username);
				 //4、执行sql
				      rs=pst.executeQuery();
				      while(rs.next()) {
				    	 f=true;
				      }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtil.realseDB(rs, pst, con);
				}
				return f;
	}
	
	@Override
	public int infoUpdate(String number, String address, int userId) {
		//1、准备sql
	        StringBuffer sql=new StringBuffer();
			sql.append("update users set tel=?,address=? where userId=?");
			//2、链接数据库
			Connection con=DBUtil.getConnection();
			PreparedStatement pst=null;
		    int f=0;
			//3、预编译sql
			try {
				 pst=con.prepareStatement(sql.toString());
			     pst.setString(1, number);
			     pst.setString(2, address);
			     pst.setInt(3, userId);
			 //4、执行sql
			     f=pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.realseDB(null, pst, con);
			}
			return f;
	}

	@Override
	public int updatePassword(String password,int userId) {
		//1、准备sql
	      StringBuffer sql=new StringBuffer();
			sql.append("update users set userPassword=? where userId=?");
			//2、链接数据库
			Connection con=DBUtil.getConnection();
			PreparedStatement pst=null;
		    int f=0;
			//3、预编译sql
			try {
				 pst=con.prepareStatement(sql.toString());
			     pst.setString(1, password);
			     pst.setInt(2, userId);
			 //4、执行sql
			     f=pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.realseDB(null, pst, con);
			}
			return f;
	}
	
}
