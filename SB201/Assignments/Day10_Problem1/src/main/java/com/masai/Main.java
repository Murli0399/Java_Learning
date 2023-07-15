package com.masai;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");

		AppConfig context = ctx.getBean("xy",AppConfig.class);
		
		List<String> cities = context.cities();
		System.out.println("Cities: " + cities);

		List<Student> students = context.students();
		System.out.println("Students: " + students);
	}
}
