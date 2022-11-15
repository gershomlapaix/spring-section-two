package com.lapaix.ioc;

public class TrackCoach implements Coach{

	// define the a field for the dependency
		private FortuneService fortuneService;
		
		public TrackCoach(FortuneService theFortuneService) {
			fortuneService = theFortuneService;
		}
		
		
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return "In TrackCoach:" + fortuneService.getFortune();
	}
	
}
