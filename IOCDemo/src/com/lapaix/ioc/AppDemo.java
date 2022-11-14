package com.lapaix.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemo {

	public static void main(String[] args) {
		
		try {
			// load spring configuration file 
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			// retrieve bean from the spring container
			Coach theCoach = context.getBean("myCoach", Coach.class);
			
			// call methods on the bean
			theCoach.getDailyWorkout();
			
			// close the context
			context.close();
		} catch (Exception e) {
			// TODO: handle exception\
			System.out.println(e.getMessage());
		}
	}

}
