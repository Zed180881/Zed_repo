package lesson2;

//Для записаного в змінну n натурального числа порахуйте суму всіх його цифр 
//(заздалегідь не відомо скільки цифр буде в числі).

public class Task14 {

	public static void main(String[] args) {
		int n = 16569874;
		int sum = 0;
		while (n != 0) {
			sum = sum + (n % 10);
			n = n / 10;
		}
		System.out.println(sum);
	}
}
