package com.masai;

public class WatchPriceCalculator {

	double getWatchPrice(String watchType, int age, String gender) {
		double costPrice, profitPercentage, GST;
		if (watchType == "Titan") {
			costPrice = 7999;
			profitPercentage = 12.5;
			GST = 7.5;
		} else {
			costPrice = 10999;
			profitPercentage = 13.5;
			GST = 12.5;
		}

		double billAmount = costPrice + (costPrice * profitPercentage / 100) + (costPrice * GST / 100);
		if (gender == "female") {
			billAmount = billAmount - (billAmount * 2 / 100);
		} else if (age >= 60) {
			billAmount = billAmount - (billAmount * 3 / 100);
		}

		return Math.round(billAmount * 100) / 100.0;

	}

}

class WatchPriceTester {
	public static void main(String args[]) {
		WatchPriceCalculator wcOne = new WatchPriceCalculator();
//for watch type = Titan, gender = "female", age = 25
		System.out.println(wcOne.getWatchPrice("Titan", 25, "female"));
//for watch type = Rolex, gender = "male", age = 61
		System.out.println(wcOne.getWatchPrice("Titan", 61, "male"));
//for watch type = Rolex, gender = "female", age = 61
		System.out.println(wcOne.getWatchPrice("Titan", 61, "male"));
//for watch type = Rolex, gender = "female", age = 61
		System.out.println(wcOne.getWatchPrice("Titan", 25, "male"));

	}

}