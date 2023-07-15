package model;

import javax.persistence.Entity;

@Entity
public class PartTimeStudent extends MasaiStudent {
	private double partTimeFee;

	@Override
	public double payFee() {
		return getRegistrationFee() + getPartTimeFee();
	}

	public PartTimeStudent() {
	}

	public PartTimeStudent(double partTimeFee) {
		this.partTimeFee = partTimeFee;
	}

	public double getPartTimeFee() {
		return partTimeFee;
	}

	public void setPartTimeFee(double partTimeFee) {
		this.partTimeFee = partTimeFee;
	}

}
