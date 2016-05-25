package smallapps;
import java.util.Scanner;


public class TemperatureConverter {
	
	public String convertTemp(int temperature, char convertTo) {
		if (convertTo == 'C') {
			return (temperature + " градусов по Цельсию равно " + (temperature*9/5+32) + " градусов по Фаренгейту");
		} else if (convertTo == 'F') {
			return (temperature + " градусов по Фаренгейту равно " + (temperature-32)*5/9 + " градусов по Цельсию");
		} else {
			return "Неизвестная шкала температур";
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Введите температуру в градусах:");
		int temperature = in.nextInt();
		in.close();
		System.out.println("Введите шкалу (F - Фаренгейт, C - Цельсий)");
		Scanner in1 = new Scanner(System.in);
		char convertTo = (in1.nextLine()).charAt(0);
		in1.close();
		TemperatureConverter temperatureConverter = new TemperatureConverter();
		String result = temperatureConverter.convertTemp(temperature, convertTo);
		System.out.println(result);
	}

}
