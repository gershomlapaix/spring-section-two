package com.lapaix.annots;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Randomly you will get the luck";
	}
}
