package com.ray.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ray.bean.User;

import sun.usagetracker.UsageTrackerClient;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin")) { //登录成功
			/*
			 * 去succ.jsp---欢迎xxx
			 * 
			 * */
			//保存用户信息到Session中
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//转发到succ.jsp
			request.getRequestDispatcher("/succ.jsp").forward(request, response);
		} else { //登录失败
			String msg = "用户名或密码错误,请重新登陆";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
