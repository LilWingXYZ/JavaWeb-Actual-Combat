package com.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 *   一、异常的体系结构：
 *          --Error:错误，程序是不能进行处理的
 *          --Exception：异常，要求在编写程序时，我们就要考虑对这种异常进行处理
 *                 --编译时异常：在编译时就出现的异常
 *                 --运行时异常：在运行时出现的异常
 *                 
 *    二、如何处理Exception异常
 *    Java提供了异常抓抛模型
 *    1.“抛”：当我程序执行时，如果出现异常，这时就在异常代码处生成一个对应的异常对象，把这个对象抛出去，抛给方法调用出，
 *      一旦异常对象被抛出，程序就会终止
 *    2.“抓”：就是抓住抛出的异常对象，进行处理，怎么抓呢？就是异常处理
 *    Java提供了两种处理异常的方式   
 *    处理异常的第一种方式：（自己处理）、
 *    try{
 *    可能会出现异常的代码
 *    }catch(Exception1 e){
 *       //当产生Exception1异常对象时，处理措施
 *    }catch(Exception2 e){
 *        //当产生Exception2异常对象时，处理措施
 *    }
 *     [finally]{
 *        //无条件执行
 *     }
 *     
 *   1.try:内部声明的变量类似于局部变量，出来try语句这个变量就不能用了
 *   2.catch:对异常进行处理,catch可以写多个，try中抛出的异常对从上往下去匹配catch中的异常对象，如果匹配成功，就执行，
 *   后面多余的catch就不会再执行，如果有多个catch，一定要注意他们的抒写顺序，子类在前面父类在后面
 *   3.如果异常处理了，后面的代码是可以被执行的
 *   4.finally中放的是一定会被执行的代码，不管try或者catch是否有异常未被处理，都会被执行 
 *    
 *   三、对于运行时异常来说，可以不显示的进行处理（因为运行异常太多了）;
 *      对于编译时异常来说，必须要显示的进行处理
 *            
 */
public class TestException {
	
	public static void main(String[] args) {
	    //test1();
	    test2();
		//test3();
		//test4();
		
	}
	
	    //编译时异常
	    @Test
	    public void test(){
	    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    	try {
				Date date=sdf.parse("jsjs");
				System.out.println(date);
			} catch (ParseException e) {
				System.out.println("你写的字符错类型有问题");
			}
//	    	System.out.println(date);
	    }
	    
	    
	    //运行时异常
	    //1.数组下标越界:ArrayIndexOutOfBoundsException
	    public static void test1(){
	    	try{
	    	int[] i=new int[10];
	    	System.out.println(i[10]);
	    	}catch(ArrayIndexOutOfBoundsException a){
	    		//System.out.println("数组下标越界了");//自己定义处理方式
	    		//a.printStackTrace();//打印栈里面错误信息
	    		a.getMessage();//只打印错误信息
	    	}
	    }
	    
	    //2.类型转换异常  ClassCastException
	    public static void test2(){
	    	try{
	    	Object obj=new Date();
	    	String str=(String) obj;
	    	System.out.println(str);
	    	}catch(ClassCastException c){
	    		System.out.println("类型转换错误");
	    		System.out.println(10/0);
	    	}catch(RuntimeException e){
	    		System.out.println("运行异常");
	    	}catch(Exception e){
	    		System.out.println("出现异常");
	    		
	    	}finally{
	    		System.out.println("hi,帅哥，你好啊");
	    	}
	    	
	    
	    }
	    
	    //3.算术异常ArithmeticException
	    public static void test3(){
	    	try {
				int i = 10;
				int b = i / 0;
				System.out.println(b);
			} catch (Exception e) {
				System.out.println("shajshaj");
			}
	    }
	    
	    //4.空指针异常  NullPointerException(最常见的一种异常)
	    public static void test4(){
	    	String[] str=null;
	    	System.out.println(str[0]);
	    }

}
