package com.masai;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {

		// Q. 1
		Consumer<String> c1 = s -> System.out.println(s);
		c1.accept("Murli");

		// Q. 2
		BiConsumer<String, Integer> c2 = (s, i) -> System.out.println(s.length() - i);
		c2.accept("Murli", 2);

		// Q. 3
		Supplier<String> c3 = () -> "Hello";
		System.out.println(c3.get());

		// Q. 4
		List<String> list1 = new ArrayList<>();
		Consumer<List<String>> c4 = l -> l.add("Aman");
		c4.accept(list1);
		System.out.println(list1);

		// Q. 5
		Function<String, Character> c5 = s -> s.charAt(0);
		System.out.println(c5.apply("Murli"));

		// Q. 6
		Function<String, Double> c6 = Double::parseDouble;
		System.out.println(c6.apply("111"));

		// Q. 7
		Exception ex = new ArrayIndexOutOfBoundsException("Not a Valid index");
		Supplier<String> c7 = ex::toString;
		System.out.println(c7.get());

		// Q. 8
		Exception ex1 = new ArrayIndexOutOfBoundsException(2);
		Consumer<PrintStream> c8 = ex1::printStackTrace;
		c8.accept(System.out);

		// Q. 9
		Set<Integer> set = new LinkedHashSet<>();
		Predicate<Integer> c9 = set::add;
		c9.test(10);
		System.out.println(set);

		// Q. 10
		List<String> list = new ArrayList<>();
		list.add("One");
		BiConsumer<Integer, String> c10 = list::add;
		c10.accept(0, "Zero");
		System.out.println(list);

		// Q. 11
		Map<Integer, String> map = new LinkedHashMap<>();
		BiFunction<Integer, String, String> c11 = map::putIfAbsent;
		c11.apply(0, "Zero");
		System.out.println(map);

		// Q. 12
		Function<String, StringBuilder> bif = StringBuilder::new;
		StringBuilder s1 = bif.apply("all is well");
		System.out.println(s1);

	}
}
