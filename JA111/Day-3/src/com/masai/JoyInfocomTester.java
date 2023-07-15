package com.masai;

class JoyInfocom {
	double getBillAmount(boolean usingCallService, boolean usingSMSService, boolean usingDataService) {
		double billAmount = 0;
        if (usingCallService) {
            billAmount += 300;
        }
        if (usingDataService) {
            billAmount += 50;
        }
        if (usingSMSService) {
            billAmount += 125;
        }
        return billAmount;
	}
}

public class JoyInfocomTester {
	public static void main(String args[]) {
		JoyInfocom joy = new JoyInfocom();
		System.out.println(joy.getBillAmount(true, true, false));
		System.out.println(joy.getBillAmount(true, false, false));
		System.out.println(joy.getBillAmount(true, true, true));
	}
}