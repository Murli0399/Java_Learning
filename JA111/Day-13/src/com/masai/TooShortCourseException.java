package com.masai;

public class TooShortCourseException extends Exception {
	public TooShortCourseException() {
		super("Course duration should not be less than 15 days");
	}
}
