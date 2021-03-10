package com.hpe.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.po.Users;
import com.hpe.util.DBUtil;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		int count=0;
		this.getServletContext().setAttribute("count", count);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//1、获取表单提交的数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//2、 进行数据库的查询
		StringBuffer sql=new StringBuffer();
		sql.append("select * from users where userName=? and userPassword=?");
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
		//3、判断查询结果，输出不同的结果
		if(user!=null) {
			ServletContext context = this.getServletContext();
			Integer count =(Integer)context.getAttribute("count");
			count++;
			response.getWriter().write(user.toString()+"您是第"+count+ "成功登录的用户");
			context.setAttribute("count", count);
		}else {
			response.getWriter().write("your password or username is wrong");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}