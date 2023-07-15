package com.masai;

public class TooShortAttendanceException extends Exception {
	public TooShortAttendanceException() {
		super("Minimum 75% attendance is required to appear in examination");
	}
}
