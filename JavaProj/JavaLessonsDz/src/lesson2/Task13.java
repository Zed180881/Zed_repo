package lesson2;

//������� �� ����� ����� 11 ������ ����������� Գ�������. ��������, �� 
//������ � ������ ����� ����������� ���� ��������, � ����� ��������� - ����� 
//���� ����������. 

public class Task13 {

	public static void main(String[] args) {
		int n1 = 1;
		int n2 = 1;
		for (int i = 0; i < 11; i++) {
			System.out.println(n1);
			int t = n1 + n2;
			n1 = n2;
			n2 = t;
		}

	}

}