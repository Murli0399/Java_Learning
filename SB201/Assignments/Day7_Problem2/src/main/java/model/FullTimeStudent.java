package model;

import javax.persistence.Entity;

@Entity
public class FullTimeStudent extends MasaiStudent {

	private double fullTimeFee;

	@Override
	public double payFee() {
		return getRegistrationFee() + getFullTimeFee();
	}

	public double getFullTimeFee() {
		return fullTimeFee;
	}

	public void setFullTimeFee(double fullTimeFee) {
		this.fullTimeFee = fullTimeFee;
	}

	public FullTimeStudent() {
	}

	public FullTimeStudent(double fullTimeFee) {
		this.fullTimeFee = fullTimeFee;
	}

}
