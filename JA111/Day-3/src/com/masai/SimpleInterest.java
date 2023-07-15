package com.masai;

public class SimpleInterest {
	double principle_amount;
	double time_period;
	double interest_rate;
	
	void setValues(double pa, double tp, double ir){
		principle_amount = pa;
		time_period = tp;
		interest_rate = ir;
	}

	double getInterestAmount(){
		System.out.println(Math.round((principle_amount * time_period * interest_rate) / 100.0 * 100) / 100.0);
	    return Math.round((principle_amount * time_period * interest_rate) / 100.0 * 100) / 100.0;
	}
	
}

class SimpleInterestTester{
    public static void main(String args[]){
        SimpleInterest siOne = new SimpleInterest();
        SimpleInterest siTwo = new SimpleInterest();
        siOne.setValues(1005, 2, 7.5);
        siTwo.setValues(1235.50, 2.5, 8.25);
    }
}