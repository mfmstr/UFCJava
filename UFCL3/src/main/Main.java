package main;

import l3.rect.insiderect.Rectangle;

public class Main {
	public static void main(String[] args) {
		
		Rectangle type1obj1 = new Rectangle();
		
		type1obj1.setHeight(20);
		type1obj1.setWidth(20);
		
		Rectangle type1obj2 = new Rectangle();
		type1obj2.setHeight(30);
		type1obj2.setWidth(30);
		
		l3.rect.Rectangle type2obj1 = new l3.rect.Rectangle();
		type2obj1.setHeight(30);
		type2obj1.setWidth(50);
		
		l3.rect.Rectangle type2obj2 = new l3.rect.Rectangle();
		type2obj2.setHeight(30);
		type2obj2.setWidth(50);
		
		System.out.println(type1obj1.whichIsMore(type1obj1, type1obj2));
		
		System.out.println(type2obj1.wichIsMore(type2obj2));
	}
}
