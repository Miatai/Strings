package com.training.strings;

import java.util.Scanner;

public class StringAndStringBuilder {
	// 1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в
	// нем.
	public static void firstTask(String str) {
		int counter = 0;
		int maxCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isWhitespace(str.charAt(i))) {
				counter++;
			} else {
				if (maxCount < counter) maxCount = counter;
				counter = 0;
			}
		}
		System.out.println(maxCount);
	}

	// 2. В строке вставить после каждого символа 'a' символ 'b'.
	public static void secondTask(String str) {
		System.out.println(str.replaceAll("a", "ab"));
	}

	// 3. Проверить, является ли заданное слово палиндромом.
	public static boolean thirdTask(String str) {
		return str.equalsIgnoreCase(new StringBuffer(str).reverse().toString()) ? true : false;
	}

	// 4. С помощью функции копирования и операции конкатенации составить из частей
	// слова “информатика” слово “торт”.
	public static void fourthTask() {
		String informatika = new String("информатика");
		StringBuilder tortBuilder = new StringBuilder().append(informatika.charAt(7)).append(informatika.charAt(3))
				.append(informatika.charAt(4)).append(informatika.charAt(7));
		System.out.println(tortBuilder.toString());
	}

	// 5. Подсчитать, сколько раз среди символов заданной строки встречается буква
	// “а”.
	public static int fivthTask(String str, char character) {
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == character) counter++;
		}
		return counter;
	}

	// 6. Из заданной строки получить новую, повторив каждый символ дважды.
	public static void sixthTask(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i)).append(str.charAt(i));
		}
		System.out.println(sb.toString());
	}

	// 7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все
	// пробелы. Например, если было введено "abc cde def", то должно быть выведено
	// "abcdef".
	public static void seventhTask() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Введите строку: ");
			String str = in.nextLine();
			in.close();
			System.out.println(str);
			str = str.replaceAll(" ", "");
			System.out.println(str);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				if (sb.toString().contains(new String(Character.toString(str.charAt(i))))) continue;
				sb.append(str.charAt(i));
			}
			System.out.println("Результат:" + sb.toString());
		} catch (Exception e) {
			System.err.println("Возникла ошибка!");
			e.getStackTrace();
		}
	}

	// 8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и
	// вывести его на экран. Случай, когда самых длинных слов может быть несколько,
	// не обрабатывать.
	public static void eighthTask() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Введите строку: ");
			String str = in.nextLine();
			in.close();
			String[] strArray = str.split(" ");
			int maxIndex = 0;
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[maxIndex].length() < strArray[i].length()) maxIndex = i;
			}
			System.out.println(strArray[maxIndex]);
		} catch (Exception e) {
			System.err.println("Возникла ошибка!");
			e.getStackTrace();
		}
	}

	// 9. Посчитать количество строчных (маленьких) и прописных (больших) букв в
	// введенной строке. Учитывать только английские буквы.
	public static void ninthTask() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Введите строку: ");
			String str = in.nextLine();
			in.close();
			int upperCaseCounter = 0;
			int lowerCaseCounter = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') lowerCaseCounter++;
				if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') upperCaseCounter++;
			}
			System.out.println("Количество ПРОПИСНЫХ букв: " + upperCaseCounter);
			System.out.println("Количество строчных букв: " + lowerCaseCounter);
		} catch (Exception e) {
			System.err.println("Возникла ошибка!");
			e.getStackTrace();
		}
	}

	// 10. Строка X состоит из нескольких предложений, каждое из которых кончается
	// точкой, восклицательным или вопросительным знаком. Определить количество
	// предложений в строке X.
	public static void tenthTask(String str) {
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.' || str.charAt(i) == '!' || str.charAt(i) == '?') counter++;
		}
		System.out.println(counter);
	}

}
