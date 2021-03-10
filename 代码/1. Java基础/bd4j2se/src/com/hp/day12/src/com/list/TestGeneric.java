package com.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * 泛型可以加上集合上，还可以定义泛型类、泛型接口、泛型方法
 *
 */
public class TestGeneric {
	
	//如果没有定义泛型的集合
	@Test
	public void test(){
		//存成绩的   成绩都是整数
		//如果没有泛型：任何object类型的子类都可以添加到集合中
		List list=new ArrayList();
		list.add(90);
		list.add(89);
		list.add(70);
		list.add("aaa");
		
		//遍历输出成绩
		for(int i=0;i<list.size();i++){
		  int socre=(Integer)list.get(i);
		  System.out.println(socre);
		}
		
	}
	
	@Test
	public void test1(){
		//使用泛型的集合:顾名思义就是指定集合中只能存放什么类型的数据
		List<Integer> list=new ArrayList<Integer>();
		list.add(11);
		list.add(20);
		list.add(90);
		
		for(int i=0;i<list.size();i++){
			int score=list.get(i);//拆箱
			System.out.println(score);
		}
		
	}
	
	//泛型集合：要熟练掌握
	@Test
	public void test2(){
		Map<String, Integer> map=new HashMap<>();
		map.put("1001", 1000);
		map.put("1002", 2000);
		map.put("1003", 10001);
		
		//遍历
	 Set<Entry<String, Integer>> set=map.entrySet();
	   for(Entry<String, Integer> entry:  set){
		   System.out.println(entry.getKey()+"-"+entry.getValue());
		 
	 }
	}

}
