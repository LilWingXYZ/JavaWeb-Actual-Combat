package com.hpe.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDBUtil {

	public static void main(String[] args) {
		//1、准备sql
		String sql="select * from users";
		//2、获取链接
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		//3、预编译sql
		try {
			 pst=con.prepareStatement(sql);
			 //4、执行sql
			 rs=pst.executeQuery();
			 while(rs.next()) {
					System.out.println("用户名是："+rs.getString("userName")+",密码是"+rs.getString("userPassword")); 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.realseDB(rs, pst, con);
		}

	}

}
