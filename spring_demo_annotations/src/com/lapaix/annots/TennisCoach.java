package com.lapaix.annots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	/**
	 *  BY constructore injection
	 *  ------------
	 @Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService  = theFortuneService;
	}*/
	
	/** 
	 * public FortuneService getFortuneService() {
		return fortuneService;
	}
	 */

	/**
	 * @Autowired
	public void doSomeCrazyStaff(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	 * */
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	
	public TennisCoach() {
		System.out.println("Inside TennisCoach def constructor");
	}

	@Override
	public String getDailyWorkout() {
		
		return "Wake up early";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
