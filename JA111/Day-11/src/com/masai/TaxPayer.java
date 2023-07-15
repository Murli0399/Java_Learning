package com.masai;

public class TaxPayer {
	private String PAN;
	private long adhaarNumber;
	private String name;

	public TaxPayer(String PAN, long adhaarNumber, String name) {
		this.PAN = PAN;
		this.adhaarNumber = adhaarNumber;
		this.name = name;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String PAN) {
		this.PAN = PAN;
	}

	public long getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(long adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TaxPayer taxPayer = (TaxPayer) o;
		return adhaarNumber == taxPayer.adhaarNumber && PAN.equals(taxPayer.PAN);
	}

	@Override
	public int hashCode() {
		int result = PAN.hashCode();
		result = 31 * result + (int) (adhaarNumber ^ (adhaarNumber >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", PAN: " + PAN + ", Adhaar Number: " + adhaarNumber;
	}
}
