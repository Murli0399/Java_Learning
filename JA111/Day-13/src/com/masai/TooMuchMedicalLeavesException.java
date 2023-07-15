package com.masai;

public class TooMuchMedicalLeavesException extends Exception {
	public TooMuchMedicalLeavesException() {
		super("Maximum 20% of total course duration can be taken as medical leave");
	}
}
