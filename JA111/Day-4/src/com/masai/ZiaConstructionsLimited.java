package com.masai;

public class ZiaConstructionsLimited {
	double getTotalCost(double totalArea, double labourCharges) {
		double totalBill = totalArea * labourCharges;
		return totalBill;
	}

	double getTotalCost(double totalArea, double labourCharges, double materialCharges) {
		double totalBill = (totalArea * labourCharges) + (totalArea * materialCharges);
		return totalBill;
	}

}
