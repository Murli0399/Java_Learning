package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonService personService = context.getBean("ps", PersonService.class);

		personService.printSkillMap();
		System.out.println();
		personService.printPersonList();
	}
}
