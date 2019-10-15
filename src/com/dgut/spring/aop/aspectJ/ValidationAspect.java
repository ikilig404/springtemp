package com.dgut.spring.aop.aspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidationAspect {
	
	@Before("execution(* com.dgut.spring.aop.aspectJ.Calculator.*(..))")
	public void beforeAnnounce() {
		System.out.println("Validation Apsect Before Announcement.");
	}
}
