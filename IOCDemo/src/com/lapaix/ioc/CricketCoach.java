package com.lapaix.ioc;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("Inside CricketCoach constructor.");
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside the CricketCoach setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		
		return "By cricket coach:"+ fortuneService.getFortune();
	}

}
