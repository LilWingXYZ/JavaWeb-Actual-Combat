package com.hp.day6.object;

/**
 * 用户的增删改查
 * 添加add+操作对象
 * 删除delete+操作对象
 * 更新update+操作对象
 * 查询find+操作对象+By条件
 * @author McGradyXYZ
 *
 */
public class UserService {

	/**
	 * 添加用户
	 * @param user
	 * 一般形参的命名：类名首字母改成小写；单词的前几个字母；多个单词首字母
	 */
	public void addUser(User user) {

	}
	
	public void deleteUser(User user) {
		
	}
	
	public void updateUser(User user) {
		
	}
	
	public void findUserByID(int id) {
		
	}
	
	public static void main(String[] args) {
		UserService us = new UserService();
		User u1 = new User();
		us.addUser(u1);
		us.deleteUser(u1);
		us.updateUser(u1);
		us.findUserByID(00001);

	}

}
