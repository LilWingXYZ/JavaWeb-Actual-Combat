package com.hpe.servlet;

import java.io.IOException;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso-8859-1"),"utf-8");
		String password = request.getParameter("password");
		
		String[] hobbys = request.getParameterValues("爱好");
		
		System.out.println(username + ":" + password);
		for(String string : hobbys) {
			System.out.println(string);

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String[] hobbys = request.getParameterValues("爱好");
		
		System.out.println(username + ":" + password);
		for(String string : hobbys) {
			System.out.println(string);

		}
	}

}
