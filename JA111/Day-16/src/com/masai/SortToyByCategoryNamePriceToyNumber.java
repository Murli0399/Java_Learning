package com.masai;

import java.util.Comparator;

public class SortToyByCategoryNamePriceToyNumber implements Comparator<Toy> {

	@Override
	public int compare(Toy t1, Toy t2) {
		if (t1.getCategory().compareTo(t2.getCategory()) != 0) {
			return t1.getCategory().compareTo(t2.getCategory());
		}
		if (t1.getToyName().compareTo(t2.getToyName()) != 0) {
			return t1.getToyName().compareTo(t2.getToyName());
		}
		if (t1.getPrice() != (t2.getPrice())) {
			if(t1.getPrice() > t2.getPrice()) {
				return 1;
			}else {
				return -1;
			}
		}
		return t1.getToyNumber().compareTo(t2.getToyNumber());
	}
}
