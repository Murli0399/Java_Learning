package com.masai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ABCVocationalSchool {

	static long getCourseDurationinDays(String startDateText, String endDateText)
			throws InvalidDatesException, TooLongCourseException, TooShortCourseException {
		LocalDate startDate = LocalDate.parse(startDateText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate endDate = LocalDate.parse(endDateText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		if (startDate.isAfter(endDate)) {
			throw new InvalidDatesException();
		}

		long courseDuration = ChronoUnit.DAYS.between(startDate, endDate.plusDays(1));
		if (courseDuration < 15) {
			throw new TooShortCourseException();
		} else if (courseDuration > 30) {
			throw new TooLongCourseException();
		}

		return courseDuration;
	}

	static long getMedicalLeavesDurationinDays(String startDateText, String endDateText, long courseDurationInDays)
			throws InvalidDatesException, TooMuchMedicalLeavesException {
		LocalDate startDate = LocalDate.parse(startDateText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate endDate = LocalDate.parse(endDateText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		if (startDate.isAfter(endDate)) {
			throw new InvalidDatesException();
		}

		long medicalDuration = ChronoUnit.DAYS.between(startDate, endDate.plusDays(1));
		if (medicalDuration > courseDurationInDays * 0.2) {
			throw new TooMuchMedicalLeavesException();
		}

		return medicalDuration;
	}

	static double getAttendancePercentage(long courseDurationInDays, long medicalLeavesInDays, long attendanceInDays)
			throws TooShortAttendanceException {
		double totalDays = courseDurationInDays - medicalLeavesInDays;
		double attendence = attendanceInDays / totalDays;

		if (attendence < .75) {
			throw new TooShortAttendanceException();
		}
		return attendence;
	}

	static String getRemark(double attendancePercentage) {
		if (attendancePercentage >= .95) {
			return "You got 10 out of 10 marks in discipline and extracurricular activity";
		} else if (attendancePercentage >= .90) {
			return "You got 8 out of 10 marks in discipline and extracurricular activity";
		} else if (attendancePercentage >= .85) {
			return "You got 6 out of 10 marks in discipline and extracurricular activity";
		} else if (attendancePercentage >= .80) {
			return "You got 4 out of 10 marks in discipline and extracurricular activity";
		}

		return "You got 2 out of 10 marks in discipline and extracurricular activity";

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter course start date of course ");
			String courseStartDate = sc.next();
			System.out.print("Enter course end date of course ");
			String courseEndDate = sc.next();
			long courseDurationInDays = getCourseDurationinDays(courseStartDate, courseEndDate);
			System.out.println("Total course duration is " + courseDurationInDays + " days");
			System.out.print("Have you taken medical leaves? (y/n) ");
			char takenMedicalLeave = sc.next().toLowerCase().charAt(0);
			long medicalLeavesInDays = 0;
			if (takenMedicalLeave == 'y') {

				System.out.print("Enter medical leave start date ");
				String medicalStartDate = sc.next();
				System.out.print("Enter medical leave end date ");
				String medicalEndDate = sc.next();
				medicalLeavesInDays = getMedicalLeavesDurationinDays(medicalStartDate, medicalEndDate,
						courseDurationInDays);
				System.out.println("Total medical leave duration is " + medicalLeavesInDays + " days");
			}
			System.out.print("Enter number of days you attended this course ");
			long attendanceInDays = sc.nextLong();
			double attendancePercentage = getAttendancePercentage(courseDurationInDays, medicalLeavesInDays,
					attendanceInDays);
			System.out.println(getRemark(attendancePercentage));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		sc.close();
	}

}
