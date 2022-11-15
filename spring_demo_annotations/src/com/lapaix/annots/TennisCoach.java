package com.lapaix.annots;

import org.springframework.stereotype.Component;

@Component        // "thatSillyCoach" : bean ID
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Practice too much during the mid day";
	}

}
