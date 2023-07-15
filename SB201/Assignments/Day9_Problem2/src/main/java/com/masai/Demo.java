package com.masai;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	private Map<Department, Employee> theMap;

	// use setter injection to inject theMap;
	public void setTheMap(Map<Department, Employee> theMap) {
		this.theMap = theMap;
	}

	public void myInit() {
		System.out.println("inside myInit method");
	}

	public void cleanUp() {
		System.out.println("inside cleanUp method");
	}

	public void showDetails() {
		System.out.println("inside showDetails of Demo class");
		for (Department dept : theMap.keySet()) {
			System.out.println("Department: " + dept);
			System.out.println("Employee: " + theMap.get(dept));
		}
	}

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		Demo t = ctx.getBean("demo", Demo.class);
		t.showDetails();
	}
}
