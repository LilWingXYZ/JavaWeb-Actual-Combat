package com.hp.day9.polymorphic;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a1 = new Animal();
		Animal cat = new Cat();
		Animal dog = new Dog();
		a1.eat();
		cat.eat();
		dog.eat();

	}

}
