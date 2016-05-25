package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//������� ��������, ��� �������� �������� ������������ ����� n, ��� 
//���������� ����� � ���������.

//import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		System.out
				.println("������ ���������� ����� ��� ���������� ���������: ");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		int n = Integer.parseInt(reader.readLine());

		// ��������� ����� ������
		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// in.close();

		if (n < 0)
			System.out
					.println("�� ����� ��'���� ����� - ���� �� �������� �� �����������");
		else
			System.out.println("�������� ����� " + n + " ������� "
					+ factorial(n));

	}

	private static int factorial(int n) {
		if (n == 0)
			return 1;
		else {
			int f = 1;
			for (int i = 1; i <= n; i++) {
				f = f * i;
			}
			return f;
		}

	}

}
