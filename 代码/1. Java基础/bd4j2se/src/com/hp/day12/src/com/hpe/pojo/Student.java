package com.hpe.pojo;

//实体类，就是一个虚拟的表 和数据库中的对应
public class Student {
	
	private int stuid;//学号
	private String name;//姓名
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", name=" + name + "]";
	}
	
	

}
