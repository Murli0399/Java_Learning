package com.masai;

class Main {

	static public void main(String args[]) {
		EPFOAccount e1 = new EPFOAccount("EPFO001", 25000);
		EPFOAccount e2 = new EPFOAccount("EPFO002", 35000);

		Employee emp1 = new Employee("E001", "Anuj", 45000, e1);
		Employee emp2 = new Employee("E002", "Jayesh", 38000, e2);
		Employee emp3 = new Employee("E001", "Rajesh", 35500, e2);

		System.out.println(emp1.equals(emp2));
		System.out.println(emp2.equals(emp3));
		System.out.println(emp3.equals(emp1));
		System.out.println();

		System.out.println(emp1.hashCode() == emp2.hashCode());
		System.out.println(emp2.hashCode() == emp3.hashCode());
		System.out.println(emp3.hashCode() == emp1.hashCode());
		System.out.println();

		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);

	}

//	Output
//	false
//	false
//	true
//
//	false
//	false
//	true
//
//	Employee Id: E001 Name: Anuj Salary: 45000 EPFO Account details: (Account number: EPFO001 Balance: 25000/-)
//	Employee Id: E002 Name: Jayesh Salary: 38000 EPFO Account details: (Account number: EPFO002 Balance: 35000/-)
//	Employee Id: E001 Name: Rajesh Salary: 35500 EPFO Account details: (Account number: EPFO002 Balance: 35000/-)
//	```
}
