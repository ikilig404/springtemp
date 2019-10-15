package com.dgut.spring.aop.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class TestAspectJ {

	@Test
	void test() {
		ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("springaop-aspectJ-xml.xml");
		CalculatorInterface calculator = context.getBean("calculator", CalculatorInterface.class);
		System.out.println(calculator.getClass().getName());
		int result = calculator.div(2, 0);
		System.out.println("The Final result = " + result);
		
		context.close();
	}

}
