package com.hp.day8.cylinder;

public class TestCylinder {

	public static void main(String[] args){
		Cylinder cy = new Cylinder();
		cy.setRadius(1);
		cy.setLength(4);
		System.out.println(cy.findVolume());
	}
}
