package com.masai;

class FeeWithCess extends FeeExpenses {

	private double cess;
	  
	  public FeeWithCess(double tuitionFee, double serviceTax, double cess){
	    super(tuitionFee, serviceTax);
	    this.cess = cess;
	  }
	  
	  @Override
	  public double getTotalFee(){
	    return super.getTotalFee() + (super.tuitionFee * (cess/100));
	  }

}
