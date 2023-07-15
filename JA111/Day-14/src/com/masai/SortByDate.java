package com.masai;

import java.util.Comparator;

public class SortByDate implements Comparator<Entry> {
	@Override
	public int compare(Entry a, Entry b) {
		return a.getDate().compareTo(b.getDate());
	}
}
