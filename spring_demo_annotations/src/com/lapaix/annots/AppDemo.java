package com.lapaix.annots;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemo {

	public static void main(String[] args) {
		
		try {
			// load spring configuration file 
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			System.out.println("-----------------------------\n");
			
			Coach coach = context.getBean("tennisCoach", Coach.class);
			
			System.out.println(coach.getDailyWorkout());
			System.out.println(coach.getDailyFortune());
			// close the context
			context.close();
		} catch (Exception e) {
			// TODO: handle exception\
			System.out.println(e.getMessage());
		}
	}

}
