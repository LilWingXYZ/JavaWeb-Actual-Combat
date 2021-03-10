package com.hpe.util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	static String driver;
	static String url;
	static String user;
	static String password;
	/*
	 * 三个部分组成
	 * 1、加载配置文件，并加载驱动
	 */
	static {
		//用来加载配置文件
		Properties properties=new Properties();
		//从classpath根目录下读取配置文件
		InputStream is=DBUtil.class.getResourceAsStream("/db.properties");
		try {
			//读取配置文件内容
			properties.load(is);
			//根据键获取到相应的值
			driver=properties.getProperty("jdbc.driver");
			url=properties.getProperty("jdbc.url");
			user=properties.getProperty("jdbc.user");
			password=properties.getProperty("jdbc.password");
			//加载驱动
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2、获取数据库连接
	public static Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	//3、关闭链接
	public static void realseDB(ResultSet rs,PreparedStatement pst,Connection con) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
