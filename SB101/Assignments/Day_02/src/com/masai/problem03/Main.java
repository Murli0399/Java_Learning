package com.masai.problem03;

// static

import java.util.Arrays;
import java.util.List;

class StringUtils {
	public static boolean startsWithUpperCase(String str) {

		return Character.isUpperCase(str.charAt(0));

	}
}

public class Main {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("ApPle", "Banana", "Cherry");
		long count = strings.stream().filter(StringUtils::startsWithUpperCase).count();
		System.out.println(count);
	}
}
