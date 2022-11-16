package com.lapaix.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator  implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	public CourseCodeConstraintValidator(CourseCode theCousCode) {
		coursePrefix = theCousCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
	
		boolean result = theCode.startsWith(coursePrefix);
		return result;
	}
} 