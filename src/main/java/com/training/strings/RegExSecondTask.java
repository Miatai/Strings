package com.training.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSecondTask {

	// 2. ���� ������, ���������� ��������� ����� (xml-��������):
	//
	// <notes>
	// <note id = "1">
	// <to>����</to>
	// <from>�����</from>
	// <heading>�����������</heading>
	// <body>������� ��� ������!</body>
	// </note>
	// <note id = "2">
	// <to>����</to>
	// <from>����</from>
	// <heading>������ �����������</heading>
	// <body/>
	// </note>
	// </notes>
	//
	// �������� ����������, ����������� ��������������� ���������� ���������� �����
	// xml-��������� � ��� ��� (����������� ���, ����������� ���, ���������� ����,
	// ��� ��� ����). ������������ �������� ��������� XML ��� ������� ������ ������
	// ������.

	private static final String str = new String(
			"<notes><note id = \"1\"><to>����</to><from>�����</from><heading>�����������</heading><body>������� ��� ������!</body></note><note id = \"2\"><to>����</to><from>����</from><heading>������ �����������</heading></body></note></notes>");

	public static void secondTask() {
		Pattern notesRegex = Pattern.compile("<([^<>]+)>(.*?)</(\\1)>", Pattern.DOTALL);
		Matcher notesMatcher = notesRegex.matcher(str);
		while (notesMatcher.find()) {
			System.out.println("tag: " + notesMatcher.group(1));
			Pattern note = Pattern.compile("<([^<>]+) ([^>]*)>(.*?)</(\\1)>");
			Matcher noteMatcher = note.matcher(notesMatcher.group(2));
			while (noteMatcher.find()) {
				System.out.println("tag: " + noteMatcher.group(1));
				Pattern attribute = Pattern.compile("\"([^\"]*)\"");
				Matcher attributeMatcher = attribute.matcher(noteMatcher.group(2));
				while (attributeMatcher.find()) {
					System.out.println("attribute id = " + attributeMatcher.group(1));
				}
				Pattern field = Pattern.compile("<([^<>]+)>([^<>]+)</([^<>]+)>|</([^<>]+)>");
				Matcher fieldMatcher = field.matcher(noteMatcher.group(3));
				while (fieldMatcher.find()) {
					if (fieldMatcher.group(4) == null) {
						System.out.println("opening tag: " + fieldMatcher.group(1));
						System.out.println("value: " + fieldMatcher.group(2));
						System.out.println("closing tag: " + fieldMatcher.group(3));

					} else {
						System.out.println("only closing tag: " + fieldMatcher.group(4));
					}
				}
				System.out.println("closing tag: " + noteMatcher.group(4));
			}
			System.out.println("closing tag: " + notesMatcher.group(3));

		}

	}

}
