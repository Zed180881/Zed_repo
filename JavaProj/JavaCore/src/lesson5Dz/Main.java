package lesson5Dz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//�������� List ����� (��� �����, �� ���� � ���������� �� ����������). ������ 5-10 �������� � ���. �������� �������� �������� �������������� �������� � ���������:
//1) ������ ������, �� ����� �������� ������ ����.
//2) ������ ������, �� ����� �������� ������ ���� �� ���� ������.
//3) ������� � ��� �������, �� ����� �������� ���� ������, ����� �� ����.
//4) �������� ������ ���� �����, ���� ����� �� ��������.
//5) ������� �� ������, �� ����� ������ �������� ����� �� ������� ��������, �� ���� ������.
//����� ������ �������� ������� ���� ���������� � �������� �����.
//����� �����, ������ �� ����� ������� ���� �������� ����, ��� ����������� ������� ���� ��������
//
//
//����������� ������������ ���������� (����������� � ��� �����). �������� �������� �������� �������������� �������� � ��������� �� ��� ������ �������� �� ����������:
//1) ������ ������, �� �������������� �������� ��� ������.
//2) �������� � ���� �� ������, �� ����� �������� ���� ������.
//3) ������� ��� �������, ������ ���� ���� ������ � ��������� �������� ���� �� �����.
//4) �������� �� ������, �� ����� �������� ��� ������ �� �������� ������� ������� �����.
//5) �����'����� ������� �����, �� ����� �������� ��� ������.

public class Main {

	public static void main(String[] args) throws IOException {

		List<Car> cars = createCars();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		boolean isRun = true;
		while (isRun) {
			System.out.println("������� ������� �����:");
			System.out.println("1. ������ ������ �� ������� ����.");
			System.out
					.println("2. ������ ������ �� ������� ���� �� ������� ������.");
			System.out
					.println("3. ������� � ��� �������, �� ����� �������� ���� ������, ����� �� ����.");
			System.out
					.println("4. �������� ������ ���� �����, ���� ����� �� ��������.");
			System.out
					.println("5. ������� �� ������, �� ����� ������ �������� ����� �� ������� ��������, �� ���� ������.");
			System.out
					.println("6. ������ ������, �� �������������� �������� ��� ������.");
			System.out
					.println("7. �������� � ���� �� ������, �� ����� �������� ���� ������.");
			System.out
					.println("8. ������� ��� �������, ������ ���� ���� ������ � ��������� �������� ���� �� �����.");
			System.out
					.println("9. �������� �� ������, �� ����� �������� ��� ������ �� �������� ������� ������� �����.");
			System.out
					.println("10. �����'����� ������� �����, �� ����� �������� ��� ������.");
			System.out.println("11. ����� � ��������.");
			int choice = Integer.parseInt(reader.readLine());
			printCars(cars);
			switch (choice) {
			case 1: {
				System.out.println("������ ������� ���� ��� ������:");
				int diameter = Integer.parseInt(reader.readLine());
				carSearchByWheelDiameter(cars, diameter);

				break;
			}
			case 2: {
				System.out.println("������ ������� ���� ��� ������:");
				int diameter = Integer.parseInt(reader.readLine());
				System.out.println("������ ���� ������ ��� ������:");
				String bodyColor = reader.readLine();
				carSearchByWheelDiameterAndBodyColor(cars, diameter, bodyColor);
				break;
			}
			case 3: {
				System.out
						.println("��� ����� ���������� � �������� ������� (1 - � ��������, 2 - ��� ������:");
				int steeringWheelChoice = Integer.parseInt(reader.readLine());
				carReplaceRedCarSteeringWheel(cars, steeringWheelChoice);
				printCars(cars);
				break;
			}
			case 4: {
				carIncreaseWheelsDiameter(cars);
				printCars(cars);
				break;
			}
			case 5: {
				System.out.println("������ ������� ���� ��� �����:");
				int diameter = Integer.parseInt(reader.readLine());
				carReplaceCarsByWheelDiameter(cars, diameter);
				printCars(cars);
				break;
			}
			case 6: {
				System.out.println("������ ��� ������ ��� ������:");
				String bodyType = reader.readLine();
				carSearchByBodyType(cars, bodyType);
				break;
			}
			case 7: {
				System.out.println("������ ���� ������ ��� ���������:");
				String bodyColor = reader.readLine();
				cars = carDeleteByBodyColor(cars, bodyColor);
				printCars(cars);
				break;
			}
			case 8: {
				System.out
						.println("������ ���������� ������� ���� ��� ����� �� �����:");
				int minWheelDiameter = Integer.parseInt(reader.readLine());
				System.out
						.println("������ ������������ ������� ���� ��� ����� �� �����:");
				int maxWheelDiameter = Integer.parseInt(reader.readLine());
				carReplaceTyres(cars, minWheelDiameter, maxWheelDiameter);
				printCars(cars);
				break;
			}
			case 9: {
				System.out.println("������ ��� ������ ��� ���������:");
				String bodyType = reader.readLine();
				System.out
						.println("������ ���������� ������� ����� ��� ���������:");
				int minStWheelDiameter = Integer.parseInt(reader.readLine());
				System.out
						.println("������ ������������ ������� ����� ��� ���������:");
				int maxStWheelDiameter = Integer.parseInt(reader.readLine());
				cars = carDeleteByBodyTypeAndSteeringWheelDiameter(cars,
						bodyType, minStWheelDiameter, maxStWheelDiameter);
				printCars(cars);
				break;
			}
			case 10: {
				System.out.println("������ ��� ������ ��� ������:");
				String bodyType = reader.readLine();
				List<Integer> indexList = carIndexSearchByBodyType(cars,
						bodyType);
				System.out.println(indexList);
				break;
			}
			case 11: {
				isRun = false;
			}
			default:
				break;
			}
		}

	}

	private static List<Integer> carIndexSearchByBodyType(List<Car> cars,
			String bodyType) {
		List<Integer> indexList = new ArrayList<>();
		for (Car car : cars) {
			if (car.getBodyType().equals(bodyType))
				indexList.add(cars.indexOf(car));
		}
		return indexList;
	}

	private static List<Car> carDeleteByBodyTypeAndSteeringWheelDiameter(
			List<Car> cars, String bodyType, int minStWheelDiameter,
			int maxStWheelDiameter) {
		List<Car> newCars = new ArrayList<>();
		for (Car car : cars) {
			if (!(car.getBodyType().equals(bodyType)
					&& car.getSteeringWheelDiameter() >= minStWheelDiameter && car
					.getSteeringWheelDiameter() <= maxStWheelDiameter))
				newCars.add(car);
		}
		return newCars;
	}

	private static void carReplaceTyres(List<Car> cars, int minWheelDiameter,
			int maxWheelDiameter) {
		for (Car car : cars) {
			if (car.getWheelsDiameter() >= minWheelDiameter
					&& car.getWheelsDiameter() <= maxWheelDiameter)
				car.setTyreType("winter");
		}
	}

	private static List<Car> carDeleteByBodyColor(List<Car> cars,
			String bodyColor) {
		List<Car> newCars = new ArrayList<>();
		for (Car car : cars) {
			if (!car.getColor().equals(bodyColor))
				newCars.add(car);
		}
		return newCars;
	}

	private static void carSearchByBodyType(List<Car> cars, String bodyType) {
		System.out.println("���������� ������ ����� � ����� ������ " + bodyType
				+ ":");
		for (Car car : cars) {
			if (car.getBodyType().equals(bodyType))
				System.out.println(car);
		}
	}

	private static void carReplaceCarsByWheelDiameter(List<Car> cars,
			int diameter) {
		for (Car car : cars) {
			if (car.getWheelsDiameter() < diameter)
				cars.set(cars.indexOf(car), new Car());
		}
	}

	private static void carIncreaseWheelsDiameter(List<Car> cars) {
		for (Car car : cars) {
			if (car.isSteeringWheelHasButtons())
				car.setWheelsDiameter(car.getWheelsDiameter() * 2);
		}
	}

	private static void carReplaceRedCarSteeringWheel(List<Car> cars,
			int steeringWheelChoice) {
		boolean hasButtons = (steeringWheelChoice == 1) ? true : false;
		for (Car car : cars) {
			if (car.getColor().equals("red"))
				car.setSteeringWheelHasButtons(hasButtons);
		}
	}

	private static void carSearchByWheelDiameterAndBodyColor(List<Car> cars,
			int diameter, String bodyColor) {
		System.out.println("���������� ������ ����� � �������� ���� "
				+ diameter + " ����� �� �������� " + bodyColor + ":");
		for (Car car : cars) {
			if (car.getWheelsDiameter() == diameter
					&& car.getColor().equals(bodyColor))
				System.out.println(car);
		}
	}

	private static void carSearchByWheelDiameter(List<Car> cars, int diameter) {
		System.out.println("���������� ������ ����� � �������� ���� "
				+ diameter + " �����:");
		for (Car car : cars) {
			if (car.getWheelsDiameter() == diameter)
				System.out.println(car);
		}
	}

	private static List<Car> createCars() {
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("Mazda", "black", "sedan", 21, "winter", 15, true));
		cars.add(new Car("Mazda", "red", "cupe", 19, "summer", 16, false));
		cars.add(new Car("BMW", "metallic", "cabrio", 21, "demiseason", 17,
				true));
		cars.add(new Car("BMW", "white", "sedan", 19, "winter", 18, true));
		cars.add(new Car("Toyota", "red", "cupe", 17, "summer", 15, true));
		cars.add(new Car("Toyota", "silver", "universal", 22, "winter", 18,
				true));
		cars.add(new Car("Lada", "purple", "hatchback", 16, "winter", 20, false));
		cars.add(new Car("Lada", "red", "sedan", 16, "summer", 16, false));
		cars.add(new Car("Ford", "red", "cupe", 19, "demiseason", 16, true));
		cars.add(new Car("Ford", "grey", "sedan", 21, "winter", 15, true));
		return cars;
	}

	private static void printCars(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car);
		}
		System.out.println("-----------------------------------------------");
	}

}
