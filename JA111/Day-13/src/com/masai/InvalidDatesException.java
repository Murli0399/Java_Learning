package com.masai;

public class InvalidDatesException extends Exception {
	public InvalidDatesException() {
		super("Start date must not be after end date");
	}
}
