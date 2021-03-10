package com.hp.day9.initialize;

public class Bowl {
	Cup c1;
	Cup c2 = new Cup(2);
	{
		c1 = new Cup(1);
	}
	static Cup c3 = new Cup(3);
	static {
		c4 = new Cup(4);
		System.out.println("Bowl中的静态快,静态块只在类加载的时候运行，所以只运行一次");
	}
	
	static Cup c4;

	Bowl() {
		System.out.println("new Bowl()");
	}

	static void f() {
		System.out.println("Bowl中的静态方法f()被访问");
	}

	public static void main(String[] args) {
		Bowl.f();
		System.out.println("实例化一个Bowl对象");
		new Bowl();
		System.out.println("再实例化一个Bowl对象");
		new Bowl();
	}

}
