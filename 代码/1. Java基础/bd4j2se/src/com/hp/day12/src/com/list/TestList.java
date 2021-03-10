package com.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestList {
	
	//ArrayList是List的主要实现类，底层是数组
//  void add(Object o):添加元素
//	void add(int index, Object ele)：根据指定索引把元素添加到指定位置
//	boolean addAll(int index, Collection eles)
//	Object get(int index):根据索引查找元素
//	int indexOf(Object obj):返回当前集合中元素obj首次出现的位置，如果没有返回-1
//	int lastIndexOf(Object obj):返回当前集合中元素obj最后一次出现的位置，如果没有返回-1
//	Object remove(int index)：删除指定索引的元素
//	Object set(int index, Object ele):设置指定索引位置的元素为ele
	//list集合中常用方法:
	//增  删  改  查   长度size()
	
	@Test
	public void test(){
		
		List list=new ArrayList();
		//添加元素
		list.add("aaa");
		list.add("bbb");
		list.add(123);
		list.add("aaa");
		System.out.println(list);
		//void add(int index, Object ele)：根据指定索引把元素添加到指定位置
		list.add(0, new String("ccc"));
		System.out.println(list);
//		Object get(int index):根据索引查找元素
		System.out.println(list.get(3));
		//Object remove(int index)：删除指定索引的元素
		list.remove(0);
		System.out.println(list.get(0));
		//Object set(int index, Object ele):设置指定索引位置的元素为ele
		list.set(0, 250);
		System.out.println(list.get(0));
		
	}

	  @Test
	  public void test1(){

		List list=new ArrayList();
		//添加元素
		list.add("aaa");
		list.add("bbb");
		list.add(123);
		list.add("aaa");
		  //第一种遍历使用迭代器
		Iterator i=list.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
			
		}
		
		System.out.println("======");
		//第二种使用foreach
		for(Object o:list){
			System.out.println(o);
		}
		System.out.println("===================");
		//第三种使用for循环
		for(int a=0;a<list.size();a++){
			System.out.println(list.get(a));
		}
		
	  }
}
