package com.masai;

import java.time.LocalDate;

public class Entry implements Comparable<Entry> {
	private String particular;
	private double amount;
	private LocalDate date;
	private char category;

	public Entry(String particular, double amount, LocalDate date, char category) {
		this.particular = particular;
		this.amount = amount;
		this.date = date;
		this.category = category;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public char getCategory() {
		return category;
	}

	public void setCategory(char category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return String.format("%s     %s     %s", date, (category == 'E' ? -amount : amount), particular);
	}

	@Override
	public int compareTo(Entry entry) {
		return date.compareTo(entry.date);
	}
}
