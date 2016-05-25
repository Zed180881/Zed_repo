package smallapps;
import java.util.Scanner;


public class TemperatureConverter {
	
	public String convertTemp(int temperature, char convertTo) {
		if (convertTo == 'C') {
			return (temperature + " �������� �� ������� ����� " + (temperature*9/5+32) + " �������� �� ����������");
		} else if (convertTo == 'F') {
			return (temperature + " �������� �� ���������� ����� " + (temperature-32)*5/9 + " �������� �� �������");
		} else {
			return "����������� ����� ����������";
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("������� ����������� � ��������:");
		int temperature = in.nextInt();
		in.close();
		System.out.println("������� ����� (F - ���������, C - �������)");
		Scanner in1 = new Scanner(System.in);
		char convertTo = (in1.nextLine()).charAt(0);
		in1.close();
		TemperatureConverter temperatureConverter = new TemperatureConverter();
		String result = temperatureConverter.convertTemp(temperature, convertTo);
		System.out.println(result);
	}

}
