package lesson01Dz;

//�������� ���� Rectangle , � ����� ���� ������� ���� : �������, ������. 
//������� ��� ���� � �����������. �������� ����������� � ����������� � 
//��� ���������. �������� ������, �� ������ ������������� ����� �� ��������. 
//� Main ���� ���������������� ��������� �ᒺ��� �������������� ��� ������������. 
//������� �� ������� ����� � �������� ������������. ���� �� ������ ������� ���� 
//��������� ������: ������ ������������ = ��� ���� ����� �, ��������� ������������ = 
//��� ���� ��������.

public class Rectangle {

	public int length;
	public int width;

	public Rectangle() {

	}

	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public int area() {
		return this.length * this.width;
	}

	public int perimeter() {
		return (this.length + this.width) * 2;
	}

	public static void main(String[] args) {

		Rectangle rectangle1 = new Rectangle();
		rectangle1.length = 5;
		rectangle1.width = 10;
		System.out.println("����� ������������ = " + rectangle1.area()
				+ " �������� ������������ = " + rectangle1.perimeter());
		Rectangle rectangle2 = new Rectangle(6, 15);
		System.out.println("����� ������������ = " + rectangle2.area()
				+ " �������� ������������ = " + rectangle2.perimeter());
	}

}
