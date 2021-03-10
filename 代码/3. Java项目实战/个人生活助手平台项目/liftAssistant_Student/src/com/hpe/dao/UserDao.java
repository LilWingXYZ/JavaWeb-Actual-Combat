package com.hpe.dao;

import com.hpe.po.Users;

public interface UserDao {
	//用户登录 
	public Users login(String username,String password);
	//用户注册
	public Integer register(Users user);
	//用户名查重
	public boolean findByName(String username);
	//信息维护
	public int infoUpdate(String number,String address,int userId);
	//修改密码
	public int updatePassword(String password,int userId);
	
}
