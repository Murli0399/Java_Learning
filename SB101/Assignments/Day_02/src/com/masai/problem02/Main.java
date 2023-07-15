package com.masai.problem02;

@FunctionalInterface
interface Demo {
	void printDetail(Student student);
}

public class Main {

	public void fun1(Student s) {
		System.out.println("Using non-static Method reference, " + s.toString());
	}

	public static void fun2(Student s) {
		System.out.println("Using static Method reference, " + s.toString());
	}

	Main() {
	}

	Main(Student s) {
		System.out.println("Using Constructor Method reference, " + s.toString());
	}

	public static void main(String[] args) {
//		using non-static method
		Demo d1 = new Main()::fun1;
		d1.printDetail(new Student("Murli"));

//		using static method
		Demo d2 = Main::fun2;
		d2.printDetail(new Student("Murli"));

//		Using constructor method reference
		Demo d3 = Main::new;
		d3.printDetail(new Student("Murli"));

	}
}
