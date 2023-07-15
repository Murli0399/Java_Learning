package com.masai;

class FeeExpenses {

	protected double tuitionFee;
	  private double serviceTax;
	  
	  public FeeExpenses(double tuitionFee, double serviceTax){
	    this.tuitionFee = tuitionFee;
	    this.serviceTax = serviceTax;
	  }
	  
	  public double getTotalFee(){
	    return tuitionFee + (tuitionFee * (serviceTax/100));
	  }
}
