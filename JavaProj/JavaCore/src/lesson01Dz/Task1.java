package lesson01Dz;

//�������� ������� ����� int compateTo(String str1, String str2), ���� ���� ��������� 
//����� ��� ����, �� � �ompareTo � ���� String. ��������� ��, �� ������ ������ ���� 
//���� �������. ������� ��� ����������� ����������� (������ ��������� ������ 
//����� � �.�.).

public class Task1 {

	public static void main(String[] args) {
		String s1 = "Hello World";
		String s2 = "Hello World";

		System.out.println(s1.compareTo(s2));
		System.out.println(compareTo(s1, s2));

	}

	public static int compareTo(String str1, String str2) {

		int length = (str1.length() > str2.length()) ? str2.length() : str1
				.length();
		for (int i = 0; i < length; i++) {
			if (str1.codePointAt(i) != str2.codePointAt(i))
				return str1.codePointAt(i) - str2.codePointAt(i);
		}
		return str1.length() - str2.length();
	}

}