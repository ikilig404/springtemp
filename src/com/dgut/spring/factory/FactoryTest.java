package com.dgut.spring.factory;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class FactoryTest {

	@Test
	public void testFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-factory.xml");
		Bean1 bean1 = context.getBean("bean1", Bean1.class);
		System.out.println(bean1);
		Bean2 bean2 = context.getBean("bean2", Bean2.class);
		System.out.println(bean2);
		((ConfigurableApplicationContext)context).close();
	}

}
