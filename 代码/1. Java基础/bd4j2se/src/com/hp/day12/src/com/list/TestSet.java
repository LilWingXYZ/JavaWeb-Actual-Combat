package com.list;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 *Set集合是无序的，不可重复的 主要实现类是HashSet
 *1.无序性：指的是元素存储的时候是无序的，不是随机的
 *2.不可重复性：在set添加相同元素时，后面的这个元素就添加不进去了
 *set元素是怎么存储的？使用了哈希值，
 *计算对象的哈希值，这个哈希值就代表我这个对象的位置，如果该对象之前没有哈希值，就把该对象存储到该位置，如果该
 *若此位置已经有了对象，调用equals（）方法判断两个对象内容是否相等，如果相等，后面的元素添加不进来
 */
public class TestSet {
	
	@Test
	public void test(){
		Set set=new HashSet();
		System.out.println(set.size());
		set.add(123);
		//set.add("aaa");
		set.add("bbb");
		set.add(new Date());
//		set.add(123);
		String str=new String("aaa");
		System.out.println(str.hashCode());
		str=new String("aaa");
		System.out.println(str.hashCode());
		set.add(str);
//		set.add(str1);
		System.out.println(set);
		
		
		
		//set遍历
		Iterator iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		for(Object o:set){
			System.out.println(o);
		}
	}
	

}
