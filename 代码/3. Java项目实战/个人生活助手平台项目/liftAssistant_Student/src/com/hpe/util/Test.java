package com.hpe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		/*
		 * jdbc操作步骤
		 * 1、加载驱动包
		 * 2、定义四大参数:
		 *     1)加载什么样驱动（mysql,oralce,sqlserver）
		 *     2)数据库服务器的地址、端口号及数据库的名字（字符集）
		 *     3)数据库的用户名
		 *     4)数据库的密码
		 *     
		 *  3、加载驱动(抛出找不到类的异常)
		 *  4、JDBC常用类（连接数据库）\
		 *     1)连接数据库
		 *     2)准备sql语句，创建statement对象，编译sql语句
		 *     3)执行sql语句(insert ,update ,delete,通用executeUpdate)
		 *         如果sql是select，返回是一个结果集
		 *  
		 */
		/*
		 * Statement与preparedStatement区别：
		 * 1、p执行速度要快于s
		 *      p执行sql时：sql模板发送给数据库服务器
		 *                检查模板sql语法,如果每次模板相同，不再检查
		 *                设置参数
		 *                执行sql
		 *      s执行sql时：检查sql语法，每次都检查
		 *                编译sql--函数执行    
		 *  2、sql语句攻击，sql是碎片化，需要进行拼接，p需要检查里是否有单引号
		 *                                   s不需要检查
		 *  3、p的功能要强大，代码简洁
		 *  4、executeUpdate()有无参数
		 */
		/*
		 * 两个异常
		 * 1、ClassNotFoundException
		 * 2、SQLException
		 */
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/life_assistant";
		String user="root";
		String password="root";
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url, user, password);
		   /*String sql="update users set userPassword=? ,realName=?"
		    		   + "where userId=120";
		    		   
		    */	
			String sql="select * from users";
		    // st=con.createStatement();
		    pst=con.prepareStatement(sql);
		    //pst.setString(1, "999");
		    //pst.setString(2, "zhangxinyi");
//		    int flag=pst.executeUpdate();
//		    if(flag==1) {
//		    	System.out.println("数据更新成功");
//		    }
		   /*
		    * 查询
		    */
		    rs=pst.executeQuery();
		    while(rs.next()) {
		    	System.out.println("用户名是："+rs.getString("userName")+",密码是"+rs.getString("userPassword"));
		    }
		  } catch (SQLException e) {
			e.printStackTrace();
		  }finally {
			  try {
				  rs.close();
				  pst.close();
				  con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  }
		  

	}

}
