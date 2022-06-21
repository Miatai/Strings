package com.training.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

//1. Cоздать приложение, разбирающее текст (текст хранится в строке) и
// позволяющее выполнять с текстом три различных операции: отсортировать абзацы
// по количеству предложений; в каждом предложении отсортировать слова по длине;
// отсортировать лексемы в предложении по убыванию количества вхождений
// заданного символа, а в случае равенства – по алфавиту.
public class RegExFirstTask {
	public static void firstTask() {
		String[] strP = splitTextToParagraphs(
				"qwe. csddc.   \n dqwd. ddwed. vdfvdf. vdfgdfv. \n bgfb.     \n  dsfgdf. fewffe.");
		String[] strS = splitTextToSentences("das dfas!!! sdc vs dcv..... vsd fvd fv. vfd v  dfv??? vsd vd  svdf.");
		String[] strW = splitTextToWords("dqfwdv vdsfvf vdsfv   fscdv hnfgb sdc cervdfv");
		String[] sortedStrP = sortParagraphsByNumberOfSentences(strP);
		String[] sortedStrS = sortWordsByLength(strW);
		String[] sortedStrSBySymbol = sortWordsByNumberOfGivenSymbol(
				new String[] { "vfdvb", "vbd", "rfd", "bf", "abcdgg", "fgh", "acdfgg", "vfb" }, 'g');
		for (String str : sortedStrSBySymbol) {
			System.out.println(str);
		}
	}

	public static String[] splitTextToParagraphs(String text) {
		Pattern pattern = Pattern.compile("\\s*\\n+\\s*");
		return pattern.split(text);
	}

	public static String[] splitTextToSentences(String text) {
		Pattern pattern = Pattern.compile("\\s*[\\.\\!\\?]+\\s*");
		return pattern.split(text);
	}

	public static String[] splitTextToWords(String text) {
		Pattern pattern = Pattern.compile("\\s+");
		return pattern.split(text);
	}

	public static String[] sortParagraphsByNumberOfSentences(String[] paragraphs) {
		for (int i = 0; i < paragraphs.length - 1; i++) {
			for (int j = 0; j < paragraphs.length - i - 1; j++) {
				if (splitTextToSentences(paragraphs[j]).length < splitTextToSentences(paragraphs[j + 1]).length) {
					String temp = paragraphs[j];
					paragraphs[j] = paragraphs[j + 1];
					paragraphs[j + 1] = temp;
				}
			}
		}
		return paragraphs;
	}

	public static String[] sortWordsByLength(String[] sentence) {
		for (int i = 0; i < sentence.length - 1; i++) {
			for (int j = 0; j < sentence.length - i - 1; j++) {
				if (sentence[j].length() < sentence[j + 1].length()) {
					String temp = sentence[j];
					sentence[j] = sentence[j + 1];
					sentence[j + 1] = temp;
				}
			}
		}
		return sentence;
	}

	public static int numberOfGivenSymbolInLexeme(String lexeme, char symbol) {
		int counter = 0;
		for (int i = 0; i < lexeme.length(); i++) {
			if (lexeme.charAt(i) == symbol) counter++;
		}
		return counter;
	}

	public static String[] sortWordsByNumberOfGivenSymbol(String[] words, char symbol) {
		Arrays.sort(words);
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = 0; j < words.length - i - 1; j++) {
				if (numberOfGivenSymbolInLexeme(words[j], symbol) < numberOfGivenSymbolInLexeme(words[j + 1], symbol)) {
					String temp = words[j];
					words[j] = words[j + 1];
					words[j + 1] = temp;
				}

			}
		}
		return words;
	}
}
