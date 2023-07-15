package com.masai;

import java.util.Objects;

class Employee {

	private String employeeId;
	private String name;
	private int salary;
	private EPFOAccount epfoAccount;

	public Employee(String employeeId, String name, int salary, EPFOAccount epfoAccount) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.epfoAccount = epfoAccount;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee e = (Employee) obj;
		return e.employeeId.equals(this.employeeId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public String toString() {
		return "Employee Id: " + employeeId + " Name: " + name + " Salary: " + salary + " EPFO Account details: ("
				+ epfoAccount.toString() + ")";
	}
}
