package com.masai;

public class TooLongCourseException extends Exception {
	public TooLongCourseException() {
		super("Course duration should not be more than 30 days");
	}
}
