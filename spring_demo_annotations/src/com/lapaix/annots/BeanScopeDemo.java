package com.lapaix.annots;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nBeans pointing to the same object: "+result+"\n");
		System.out.println("Bean 1: "+theCoach);
		System.out.println("Beans 2: "+ alphaCoach);
		
		context.close();
	}

}
