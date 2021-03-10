package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/**
 * 1.存储多个对象：数组，集合
 * 2.数组存对象特点：Student[] stu=new Student[10];
 *               弊端：一旦创建，其长度不可改变，我们可以使用集合来解决这个问题
 *  3.集合分为两大体系：Collection和map
 *                  Collection接口
 *                            -----List接口
 *                                 ---有序的，可以重复的
 *                                 ArrayList(主要实现类):查询速度快
 *                                 LinkedList:增删改速度快
 *                            -----Set接口
 *                                   ----无序的，不可重复
 *                                   HashSet
 *
 */
public class TestCollection {
	
	@Test
	public void test(){
		
		//定义一个集合
		Collection coll=new ArrayList();
		//size():获取集合中一共有多少元素   常用
		System.out.println(coll.size());
		
		//2.add(Object o)：添加集合元素  常用
		coll.add(111);
		coll.add("AAA");
		coll.add(new Date());
		System.out.println(coll.size());
		//3.addAll(Collection c):讲集合C中所有元素添加到当前集合中
		Collection col=Arrays.asList(1,2,3,4);
		coll.addAll(col);
		System.out.println(coll.size());
		//4.isEmpty():判断当前集合是否为空  常用
		System.out.println(coll.isEmpty());
		//5.clear():清空集合中的元素
		coll.clear();
		System.out.println(coll.size());
	}
	
	@Test
	public void test1(){
		Collection coll=new ArrayList();
		coll.add(111);
		coll.add("AAA");
		coll.add(new Date());
		//6.contains(Object o):判单当前集合中是否包含O元素，如果包含返回true，不包含返回false  常用
		boolean b=coll.contains(111);
		System.out.println(b);
		//7.containsAll(Collection c):判断当前集合中是否包含集合c所有元素
		
		//8.equals():判断两个集合中所有元素是否相等  常用
		Collection c=new ArrayList();
		c.add(111);
		c.add("AAA");
		c.add(new Date());
		System.out.println(coll.equals(c));
		
		//9.remove（object o）:删除当前集合中o元素  常用
		boolean b1=coll.remove(111);
		System.out.println(b1);
		System.out.println("===============");
		//10 toArray():把集合转成数组【重要】
		Object[] obj=coll.toArray();
		for(Object arr:obj){
			System.out.println(arr);
		}
	}

	@Test
	public void test2(){
		Collection coll=new ArrayList();
		coll.add(111);
		coll.add("AAA");
		coll.add(new Date());
		//iterator():迭代器,返回一个Iterator接口
	    Iterator i=coll.iterator();
//	    System.out.println(i.next());
//	    for(int a=0;a<coll.size();a++){//不要用这种方法
//	    	System.out.println(i.next());
//	    }
	    
	    //遍历第一种方法
	    while(i.hasNext()){//判断当前集合中有没有下一个元素，如果有为true
	    	System.out.println(i.next());//输出
	    }
	    
	    //遍历的第二种方式
	    System.out.println("===foreach");
	    for(Object o:coll){
	    	System.out.println(o);
	    }
	}
}
