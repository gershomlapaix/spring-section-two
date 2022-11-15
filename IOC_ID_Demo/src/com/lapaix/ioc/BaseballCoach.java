package com.lapaix.ioc;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

	// define the a field for the dependency
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Make five pushups each morning";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
