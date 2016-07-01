package lesson01Dz;

//Написати клас Rectangle , в якому буде описано поля : довжина, ширина. 
//Описати дані поля в конструкторі. Створити конструктор з параметрами і 
//без параметрів. Написати методи, які будуть розраховувати площу та периметр. 
//В Main класі продемонструвати створення об’єктів використовуючи два конструктори. 
//Вивести на консоль площу і периметр прямокутника. Вивід на консолі повинен мати 
//наступний вигляд: «Площа прямокутника = тут буде площа », «Периметр прямокутника = 
//тут буде периметр».

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
		System.out.println("Площа прямокутника = " + rectangle1.area()
				+ " Периметр прямокутника = " + rectangle1.perimeter());
		Rectangle rectangle2 = new Rectangle(6, 15);
		System.out.println("Площа прямокутника = " + rectangle2.area()
				+ " Периметр прямокутника = " + rectangle2.perimeter());
	}

}
