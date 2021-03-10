package com.list;

public class TestOrder {

	public static void main(String[] args) {
		/**
		 * 当我实例化对象时，需要指明泛型类型。那么这个类中所有使用泛型的位置都变成了实例化中指定的泛型类型
		 */
		Order<Integer> order=new Order<Integer>();
		order.setOid(8989);
		System.out.println(order.getOid());

	}

}
