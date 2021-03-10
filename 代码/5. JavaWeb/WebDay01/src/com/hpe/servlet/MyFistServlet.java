package com.hpe.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyFistServlet implements Servlet {
	
	public void init(ServletConfig conf) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init running....");
		//1、ServletConfig可以获得servlet的name--<servlet-name>
		System.out.println(conf.getServletName());//abc
		//2、该servlet初始化的参数
		System.out.println(conf.getInitParameter("url"));
		//3、 获得ServletContext对象
		//ServletContext sc=conf.getServletContext();
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 专门向客户提供响应的方法
		HttpServletResponse response=(HttpServletResponse) res;
		response.getWriter().write("This is my first servlet");
		System.out.println("service running......");
	}
	
	
	public void destroy() {
		System.out.println("destroy running....");
		
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
