package com.hpe.po;

import java.util.Date;

/**
 * 类描述：用户信息实体类
 * 作者： zxy
 * 创建日期：2018年11月21日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class Users {
	
	//用户ID
	private int userId;
	
	//用户名
	private String userName;
	
	//用户密码
	private String userPassword;
	
	//真实姓名
	private String realName;
	
	//联系方式
	private String tel;
	
	//地址
	private String address;
	
	//上次登录时间
	private String login_time;
	
	public Users() {
		
	}
	public Users(String userName, String userPassword, String realName, String tel, String address, String login_time) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.realName = realName;
		this.tel = tel;
		this.address = address;
		this.login_time = login_time;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", realName="
				+ realName + ", tel=" + tel + ", address=" + address + "]";
	}
	
	
}
