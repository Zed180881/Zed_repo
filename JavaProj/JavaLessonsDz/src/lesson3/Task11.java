package lesson3;

import java.util.Scanner;

//������� �������� �������� ��� ���� ���������� ����������� ������ ���� ����, 
//� ������ �� ���� ����� �� �����, ������ �� ���� ��������� ������ � �� � 
//��������� ������ �� ������� ��� ������� �� ������ ��������� � ������ 19 �������. 
//ϳ��� ����� �������� ������� �������� ����� ������� ������ ������ ���� 
//���������� �� ����, � � ����� ������� � ����� � ��������� � 0-�� ��������� 
//����������� ������� + ������ � ��������� ���������, ������� ����� ����� 
//��������������, ����� ����� ��������� �� �������� �� �������� ����� + �������
//(������) + �� �� � �� ������ � �� ��� ����� �� ������� �� ���������� ����. 
//� ��������� �� ���� ��������� ����� � �������� � ��� �� ����������� � ����� 
//���� ����������.

public class Task11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int age = read("������ ��� ����?", sc);
		int pension = read("� ����� ��� �� � ����� ����� �� �����?", sc);
		int savings = read("��� ���� ����� �� ������ ��������� ������?", sc);
		int percent = read(
				"ϳ� ������ ������� �� � ����� ������� ����� � ����?", sc);

		sc.close();

		double[] depoArray = new double[pension - age];
		calculate(depoArray, savings, percent);
		printResults(depoArray, age);
	}

	private static void printResults(double[] depoArray, int age) {
		System.out.println("���������� ����������:");
		for (int i = 0; i < depoArray.length; i++)
			System.out.println("��� ��: " + (age + 1 + i)
					+ " ����. ���� �����������: " + depoArray[i] + " ���.");

	}

	private static void calculate(double[] depoArray, int savings, int percent) {
		depoArray[0] = Math.round((double) savings * (100.0 + percent)) / 100.0;
		for (int i = 1; i < depoArray.length; i++)
			depoArray[i] = Math.round((double) (depoArray[i - 1] + savings)
					* (100.0 + percent)) / 100.0;
	}

	public static int read(String question, Scanner sc) {

		System.out.println(question);
		if (sc.hasNextInt())
			return sc.nextInt();
		return 0;
	}
}
