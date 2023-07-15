package com.masai;

import java.util.Comparator;

public class SortByAmount implements Comparator<Entry> {
	@Override
	public int compare(Entry a, Entry b) {
		return Double.compare(a.getAmount(), b.getAmount());
	}
}
