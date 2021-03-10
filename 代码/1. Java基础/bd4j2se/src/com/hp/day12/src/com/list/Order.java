package com.list;

import java.util.ArrayList;
import java.util.List;

//定义一个泛型类型
public class Order<T> {//就把这个T看做是一个数据类型
	
	private T oid;//订单编号     //就把这个T当成int类型
	private String oName;//订单名
	private List<T> list=new ArrayList<T>();
	
	public T getOid() {
		return oid;
	}
	
	public void setOid(T oid) {
		this.oid = oid;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", oName=" + oName + ", list=" + list + "]";
	}
	
	

}
