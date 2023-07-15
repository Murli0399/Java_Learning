package com.masai;

class SalariedPeople implements Taxation {

	double salary;

	public SalariedPeople(double salary) {
		this.salary = salary;
	}

	@Override
	public double calculateTax() {
		double tax = 0;
		if (salary > 10000000) {
			tax += 750000;
		} else if (salary > 1000000 && salary <= 10000000) {
			tax += 1000000 * 0.3;
			salary = salary - 1000000;
		} else if (salary <= 1000000 && salary > 500000) {
			tax += 500000 * 0.2;
			salary = salary - 500000;
		} else if (salary <= 500000 && salary > 250000) {
			tax += 250000 * 0.1;
			salary = salary - 250000;
		} else {
			tax += 0;
		}
		return tax;
	}

}
