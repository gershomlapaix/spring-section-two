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
			System.out.println(theCoach.getDailyWorkout());
			System.out.println(theCoach.getDailyFortune());
			
			System.out.println("-----------------------------\n");
			
			CricketCoach crCoach = context.getBean("cricket", CricketCoach.class);
			System.out.println(crCoach.getDailyWorkout());
			System.out.println(crCoach.getDailyFortune());
			
			// get email and team of the cricket coach
			System.out.println("Team: "+crCoach.getEmail());
			
			// close the context
			context.close();
		} catch (Exception e) {
			// TODO: handle exception\
			System.out.println(e.getMessage());
		}
	}

}
