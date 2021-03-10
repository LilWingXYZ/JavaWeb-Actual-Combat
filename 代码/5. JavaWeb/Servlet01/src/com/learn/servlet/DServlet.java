package com.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DServlet
 */
public class DServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
     * 登录
     * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 
		 * 在页面上显示DServlet被访问的次数
		 * 
		 * 次数----每次访问在上一次的值上面加一----要把上一次的值保存下来
		 * 
		 * ServletContext----"count"
		 * 
		 */
		//获取ServletContext
		ServletContext ctx = this.getServletContext();
		//获取count
		Integer count = (Integer)ctx.getAttribute("count");
		//判断是否是首次访问
		if(count == null) {
			count = 1; //自动装箱
		} else {
			count++;
		}
		
		ctx.setAttribute("count", count);
		
		//在页面上显示
		PrintWriter out = response.getWriter();
		out.print("count:" + count);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
