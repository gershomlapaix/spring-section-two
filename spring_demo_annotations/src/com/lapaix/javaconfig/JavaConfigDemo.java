package com.lapaix.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lapaix.annots.Coach;

public class JavaConfigDemo {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);

		com.lapaix.javaconfig.Coach theCoach = context.getBean("tennisCoach", com.lapaix.javaconfig.Coach.class );
		
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
	}
}
