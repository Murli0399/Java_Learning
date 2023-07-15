package com.masai;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ledger {
	private List<Entry> expenseEntries;
	private List<Entry> incomeEntries;

	public Ledger() {
		expenseEntries = new ArrayList<>();
		incomeEntries = new ArrayList<>();
	}

	public void addExpense(Entry expenseEntry) {
		expenseEntries.add(expenseEntry);
	}

	public void addIncome(Entry incomeEntry) {
		incomeEntries.add(incomeEntry);
	}

	public double getTotalExpenses() {
		double total = 0;
		for (Entry entry : expenseEntries) {
			total += entry.getAmount();
		}
		return total;
	}

	public double getTotalIncome() {
		double total = 0;
		for (Entry entry : incomeEntries) {
			total += entry.getAmount();
		}
		return total;
	}

	public String getRemarkOnFinHealth() {
		double expenses = getTotalExpenses();
		double income = getTotalIncome();
		double percentage = expenses / income * 100;
		if (percentage <= 70) {
			return "Your financial health is good";
		} else if (percentage <= 100) {
			return "You need to increase the saving";
		} else {
			return "You need to manage expenses well also try to increase income";
		}
	}

	public List<Entry> getHighestLowestExpenseIncomeEntries() {
		List<Entry> result = new ArrayList<>();
		Collections.sort(expenseEntries, new SortByAmount());
		Collections.sort(incomeEntries, new SortByAmount());
		result.add(expenseEntries.get(0));
		result.add(expenseEntries.get(expenseEntries.size() - 1));
		result.add(incomeEntries.get(0));
		result.add(incomeEntries.get(incomeEntries.size() - 1));
		return result;
	}

	public List<Entry> getIncomeByDateRange(LocalDate parse, LocalDate parse2) {
		List<Entry> result = new ArrayList<>();
        for (Entry entry : incomeEntries) {
            if (entry.getDate().compareTo(parse) >= 0 && entry.getDate().compareTo(parse2) <= 0) {
                result.add(entry);
            }
        }
        return result;
	}

	public void deleteExpensesExcludingAmountRange(int i, int j) {
		
	}

	
}
