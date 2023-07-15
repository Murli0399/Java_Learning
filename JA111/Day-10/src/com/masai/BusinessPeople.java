package com.masai;

class BusinessPeople implements Taxation {

	private double totalSale;
	private double totalPurchase;
	private double operatingExpenses;

	BusinessPeople(double totalSale, double totalPurchase, double operatingExpenses) {
		this.totalSale = totalSale;
		this.totalPurchase = totalPurchase;
		this.operatingExpenses = operatingExpenses;
	}

	@Override
	public double calculateTax() {
		double netProfit = totalSale - (totalPurchase + operatingExpenses);
		double tax = 0.0;
		if (netProfit <= 500000) {
			tax = 0;
		} else if (netProfit <= 1500000) {
			tax = netProfit * 0.1;
		} else if (netProfit <= 5000000) {
			tax = netProfit * 0.22;
		} else if (netProfit > 5000000 && netProfit <= 50000000) {
			tax = netProfit * 0.32;
		} else {
			tax = 1250000;
		}

		return tax;
	}

}
