package com.hpe.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.hpe.po.Users;
import com.hpe.util.DBUtil;

public class MyFirstServlet implements Servlet {
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		   res.getWriter().write("This is my first servlet");
		   System.out.println("service running .....");
		   //1、获取请求参数：用户名和密码、
		   String username = req.getParameter("username");
		   String password = req.getParameter("password");
		   
		   //2、jdbc连接数据库，查询一下用户名和密码是否正确
		   
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
			
		   //3、登录反馈
			if(user != null) {
				res.getWriter().write("ok");
			}else {
				res.getWriter().write("no");
			}

	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init running .....");
		//获取当前servlet的名字
		String servletName = config.getServletName();
		System.out.println("servletr 的名字是:"+servletName);
		//获取初始化参数
		String parameter = config.getInitParameter("url");
		System.out.println("当前初始化参数的URL值是："+parameter);
		//获取servelt上下文
		ServletContext servletContext = config.getServletContext();
		
	}
	public void destroy() {
		System.out.println("destroy running .....");
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
