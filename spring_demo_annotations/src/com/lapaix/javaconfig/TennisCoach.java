package com.lapaix.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
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
	
/**
 * 	
	// define bean init method
	@PostConstruct
	public void doStartup() {
		System.out.println("Inside doStartup() method");
	}
	
	// define bean cleanup method
	@PreDestroy
	public void doCleanup() {
			System.out.println("Inside doStartup() method");
		}
		
 */
	
	
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
