package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AServlet
 */
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet.....");
		//获取ServletContext
		ServletContext ctx = this.getServletContext();
		//ctx = this.getServletConfig().getServletContext();
		//域对象的功能
		/*
		 * Servlet中的域对象
		 * 		ServletContext***
		 * 		Session
		 * 		Request
		 * JSP四大作用域
		 * 		Application-----ServletContext
		 * 		Session-----Session
		 * 		Request-----Request
		 * 		PageContext
		 * 域对象
		 * 域-----区域，范围-----作用范围
		 * 		getAttribute(name)-----从域对象中获取内容
		 * 		setAttribute(name, Object)-----在域对象中存放内容
		 * 		removeAttribute(name)-----从域对象中删除内容
		 * 
		 * ServletContext-------整个Web应用
		 * 
		 * */
		//在域对象中存放数据
		ctx.setAttribute("name", "zhangsan");//key-value
		//从域对象中获取数据
		String name = (String)ctx.getAttribute("name");//key
		System.out.println(name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost.....");
	}

}
