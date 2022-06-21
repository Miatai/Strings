package com.training.strings;

import java.util.Arrays;

public class StringsAsArray {
	// 1. Дан массив названий переменных в camelCase. Преобразовать названия в
	// snake_case.
	public static void firstTask(String[] namesArray) {
		for (int i = 0; i < namesArray.length; i++) {
			StringBuilder nameBuilder = new StringBuilder();
			for (int j = 0, k = 0; j < namesArray[i].length(); j++, k++) {
				if (Character.isUpperCase(namesArray[i].charAt(j))) {
					nameBuilder.append("_");
					nameBuilder.append(Character.toLowerCase(namesArray[i].charAt(j)));
					continue;
				}
				nameBuilder.append(namesArray[i].charAt(j));
			}
			namesArray[i] = new String(nameBuilder);
		}
		System.out.println(Arrays.toString(namesArray));
	}

	// 2. Замените в строке все вхождения 'word' на 'letter'.
	public static void secondTask(String str, String replasementWord, String replace) {
		System.out.println(str.replace(replasementWord, replace));
	}

	// 3. В строке найти количество цифр.
	public static int thirdTask(String str) {
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) counter++;
		}
		return counter;
	}

	// 4. В строке найти количество чисел.
	public static int fourthTask(String str) {
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				for (int j = i; j < str.length(); j++) {
					if (!Character.isDigit(str.charAt(j))) {
						counter++;
						i = j;
						break;
					}
					if (j == str.length() - 1) {
						counter++;
						i = j;
						break;
					}
				}
			}
		}
		return counter;
	}

	// 5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
	// заменить на одиночные пробелы. Крайние пробелы в строке удалить.
	public static void fivthTask(String str) {
		StringBuilder sb = new StringBuilder();
		boolean repeatedSpace;
		for (int i = 0; i < str.length(); i++) {
			repeatedSpace = false;
			if (Character.isWhitespace(str.charAt(i))) {
				for (int j = i + 1; j < str.length(); j++) {
					if (Character.isWhitespace(str.charAt(j))) {
						repeatedSpace = true;
						break;
					} else {
						break;
					}
				}
			}
			if (!repeatedSpace) {
				sb.append(str.charAt(i));
			}
		}
		if (Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		if (Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		System.out.println("|" + sb.toString() + "|");
	}

}
