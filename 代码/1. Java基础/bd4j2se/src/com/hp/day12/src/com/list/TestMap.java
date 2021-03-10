package com.list;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * Map接口：已key-value方式存储
 *       --HashMap:主要实现类
 *       --LinkedHashMap：链条的形式存储
 *       --Hashtable:太古老
 *     
 *
 */
public class TestMap {
	
	@Test
	public void test(){
		Map map=new HashMap();
		//put(key, value):键值对的方式添加元素到集合中
		map.put(123, "123");
		map.put("abc", "abc");
		map.put(null, null);
		map.put(new String("aaa"), "bbb");
		map.put(new String("aaa"), "ccc");
		
		map.put(new Person("张三"), "可以");//因为没有重写equals方法
		map.put(new Person("张三"), "可以1");
		/**
		 * HashMap():key是用set存的，不可重复；value是用collection存储，可重复
		 * 一个key-value就是一个Entry,所有的Entry都是用set存储的，不可重复，无序，如果键的值出现重复，就把上一个覆盖了
		 */
		map.put(123, "张三");
		//remove(object key):根据key删除值
		map.remove(null);
		System.out.println(map);
	}
	
	@Test
	public void test1(){
		Map map=new HashMap();
		map.put(123, "123");
		map.put("abc", "abc");
		map.put(null, null);
		map.put(new String("aaa"), "bbb");
		
		//Set keySet():获取map中所有的键
		
	  System.out.println("====遍历map所有的key");
	  Set set=map.keySet();
	  for(Object obj:set){
		  System.out.println(obj);
	  }
	  
	  System.out.println("====遍历map所有的value");
	  //Collection values():获取map中所有的value
	  Collection coll=map.values();
	  Iterator iterator=coll.iterator();
	  while(iterator.hasNext()){
		  System.out.println(iterator.next());
	  }
	  
	  //遍历map key-value值     null-null
	  System.out.println("===遍历map的第一种方式");
	  Set s=map.keySet();
	  for(Object o:s){
		  System.out.println(o+"-"+map.get(o));
	  }
	  
	  System.out.println("遍历map的第二种方式");
	  //Set entrySet()
	  Set set1=map.entrySet();
	  for(Object obj1:set1){
//		  System.out.println(obj1);
		 Entry entry=(Entry) obj1;
		System.out.println(entry.getKey()+"-"+entry.getValue());
	  }
	}
}

class Person{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public Person() {
		super();
	}
	
}