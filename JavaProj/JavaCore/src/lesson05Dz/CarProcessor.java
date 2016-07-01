package lesson05Dz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*�������� List ����� (��� �����, �� ���� � ���������� �� ����������). ������ 5-10 �������� � ���. �������� ������� �������� �������������� �������� � ���������:
1) ������ ������, �� ����� �������� ������ ����.
2) ������ ������, �� ����� �������� ������ ���� �� ���� ������.
3) ������� � ��� �������, �� ����� �������� ���� ������, ����� �� ����.
4) �������� ������ ���� �����, ���� ����� �� ��������.
5) ������� �� ������, �� ����� ������ �������� ����� �� ������� ��������, �� ���� ������.
����� ������ �������� ������� ���� ���������� � �������� �����.
����� �����, ������ �� ����� ������ ���� ������� ����, ��� ����������� ������ ���� ��������

����������� ������������ ���������� (����������� � ��� �����). �������� ������� �������� �������������� �������� � ��������� �� ��� ������ �������� �� ����������:
1) ������ ������, �� �������������� �������� ��� ������.
2) �������� � ���� �� ������, �� ����� �������� ���� ������.
3) ������� ��� �������, ������ ���� ���� ������ � ��������� ������� ���� �� �����.
4) �������� �� ������, �� ����� �������� ��� ������ �� �������� ������� ������� �����.
5) �����'����� ������� �����, �� ����� �������� ��� ������.

����������� ������ � ��������. ������� ����� (�����, �����, ������ ��
������) �������� ������ equals �� hashCode. �������� LinkedHashSet
�����. �������� ������, �� ������ ������ ��������:

1. �������, �� ����� �������� ���� ������ �� �������� ������
������, ������ ��� ��� �� ��������.
2. �������� ������, ������ ����� ���� ������ � �������� �������.
3. ������ ������, �� ����� �������� ��� ��� �� ������ ���� ����
������ � �������� �������.*/


public class CarProcessor {

	public List<Car> cars;
	public Set<Car> carsSet;

	public CarProcessor() {
		cars = createCars();
		carsSet = createCarsSet();
	}
	
//	public static void main(String[] args) throws IOException {
//
//		CarProcessor carProcessor = new CarProcessor();
//		InputStream inputStream = System.in;		
//		carProcessor.processCars(inputStream);
//
//	}

	public void processCars(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		boolean isRun = true;
		while (isRun) {
			System.out.println("������� ������� �����:");
			System.out.println("1. ������ ������ �� ������� ����.");
			System.out.println("2. ������ ������ �� ������� ���� �� ������� ������.");
			System.out.println("3. ������� � ��� �������, �� ����� �������� ���� ������, ����� �� ����.");
			System.out.println("4. �������� ������ ���� �����, ���� ����� �� ��������.");
			System.out.println("5. ������� �� ������, �� ����� ������ �������� ����� �� ������� ��������, �� ���� ������.");
			System.out.println("6. ������ ������, �� �������������� �������� ��� ������.");
			System.out.println("7. �������� � ���� �� ������, �� ����� �������� ���� ������.");
			System.out.println("8. ������� ��� �������, ������ ���� ���� ������ � ��������� ������� ���� �� �����.");
			System.out.println("9. �������� �� ������, �� ����� �������� ��� ������ �� �������� ������� ������� �����.");
			System.out.println("10. �����'����� ������� �����, �� ����� �������� ��� ������.");
			System.out.println("11. Set. ����� ��� �� ������ ������ �� ������� ����.");
			System.out.println("12. Set. ��������� ����� �� ������� ����.");
			System.out.println("13. Set. ����� ����� �� ���� ��� �� ������� ����");
			System.out.println("14. ����� � ��������.");
			int choice = Integer.parseInt(reader.readLine());			
			switch (choice) {
			case 1: {
				printCars(cars);
				System.out.println("������ ������� ���� ��� ������:");
				int diameter = Integer.parseInt(reader.readLine());
				List<Car> searchResult = carSearchByWheelDiameter(cars,
						diameter);
				System.out.println("���������� ������ ����� � �������� ���� "
						+ diameter + " �����:");
				printCars(searchResult);
				break;
			}
			case 2: {
				printCars(cars);
				System.out.println("������ ������� ���� ��� ������:");
				int diameter = Integer.parseInt(reader.readLine());
				System.out.println("������ ���� ������ ��� ������:");
				String bodyColor = reader.readLine();
				List<Car> searchResult = carSearchByWheelDiameterAndBodyColor(
						cars, diameter, bodyColor);
				System.out.println("���������� ������ ����� � �������� ���� "
						+ diameter + " ����� �� �������� " + bodyColor + ":");
				printCars(searchResult);
				break;
			}
			case 3: {
				printCars(cars);
				System.out.println("��� ����� ���������� � �������� ������� (1 - � ��������, 2 - ��� ������:");
				int steeringWheelChoice = Integer.parseInt(reader.readLine());
				carReplaceRedCarSteeringWheel(cars, steeringWheelChoice);
				printCars(cars);
				break;
			}
			case 4: {
				printCars(cars);
				carIncreaseWheelsDiameter(cars);
				printCars(cars);
				break;
			}
			case 5: {
				printCars(cars);
				System.out.println("������ ������� ���� ��� �����:");
				int diameter = Integer.parseInt(reader.readLine());
				carReplaceCarsByWheelDiameter(cars, diameter);
				printCars(cars);
				break;
			}
			case 6: {
				printCars(cars);
				System.out.println("������ ��� ������ ��� ������:");
				String bodyType = reader.readLine();
				List<Car> searchResult = carSearchByBodyType(cars, bodyType);
				System.out.println("���������� ������ ����� � ����� ������ "
						+ bodyType + ":");
				printCars(searchResult);
				break;
			}
			case 7: {
				printCars(cars);
				System.out.println("������ ���� ������ ��� ���������:");
				String bodyColor = reader.readLine();
				cars = carDeleteByBodyColor(cars, bodyColor);
				printCars(cars);
				break;
			}
			case 8: {
				printCars(cars);
				System.out.println("������ ��������� ������� ���� ��� ����� �� �����:");
				int minWheelDiameter = Integer.parseInt(reader.readLine());
				System.out.println("������ ������������ ������� ���� ��� ����� �� �����:");
				int maxWheelDiameter = Integer.parseInt(reader.readLine());
				carReplaceTyres(cars, minWheelDiameter, maxWheelDiameter);
				printCars(cars);
				break;
			}
			case 9: {
				printCars(cars);
				System.out.println("������ ��� ������ ��� ���������:");
				String bodyType = reader.readLine();
				System.out
						.println("������ ��������� ������� ����� ��� ���������:");
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
				printCars(cars);
				System.out.println("������ ��� ������ ��� ������:");
				String bodyType = reader.readLine();
				List<Integer> indexList = carIndexSearchByBodyType(cars,
						bodyType);
				System.out.println(indexList);
				break;
			}
			case 11: {
				printCars(carsSet);
				System.out.println("������ ���� ������ ��� ����� ���:");
				String bodyColor = reader.readLine();
				System.out.println("������ ��������� ������� ���� ��� ����� ���:");
				int minWheelDiameter = Integer.parseInt(reader.readLine());
				System.out.println("������ ������������ ������� ���� ��� ����� ���:");
				int maxWheelDiameter = Integer.parseInt(reader.readLine());
				System.out.println("���� ��� ��� ����������?");
				String tyreType = reader.readLine();
				carSetReplaceTyres(carsSet, bodyColor, minWheelDiameter, maxWheelDiameter, tyreType);
				printCars(carsSet);
				break;
			}
			case 12: {
				printCars(carsSet);
				System.out.println("������ ��������� ������� ���� ��� ���������:");
				int minWheelDiameter = Integer.parseInt(reader.readLine());
				System.out.println("������ ������������ ������� ���� ��� ���������:");
				int maxWheelDiameter = Integer.parseInt(reader.readLine());
				carsSet = carSetDeleteByWheelsDiameter(carsSet, minWheelDiameter, maxWheelDiameter);
				printCars(carsSet);
				break;
			}
			case 13: {
				printCars(carsSet);
				System.out.println("������ ��� ��� ��� ������:");
				String tyreType = reader.readLine();
				System.out.println("������ ��������� ������� ���� ��� ������:");
				int minWheelDiameter = Integer.parseInt(reader.readLine());
				System.out.println("������ ������������ ������� ���� ��� ������:");
				int maxWheelDiameter = Integer.parseInt(reader.readLine());
				Set<Car> searchResult = carSearchByTyreTypeAndWheelDiameter(carsSet, tyreType,
						minWheelDiameter, maxWheelDiameter);
				System.out.println("���������� ������ ����� � ����� ������ - " + tyreType + ", �� �������� ���� � ������� "+ minWheelDiameter + " - " + maxWheelDiameter + " �����:");
				printCars(searchResult);
				break;
			}
			case 14: {
				isRun = false;
				break;
			}
			default:
				System.out.println("��������� ���! ��������� �� ���!");
				break;
			}
		}
	}

	public Set<Car> carSearchByTyreTypeAndWheelDiameter(Set<Car> carsSet,
		String tyreType, int minWheelDiameter, int maxWheelDiameter) {
		Set<Car> searchResult = new LinkedHashSet<>();
		for (Car car : carsSet) {
			if (car.getTyreType().equals(tyreType)&&car.getWheelsDiameter()>=minWheelDiameter&&car.getWheelsDiameter()<=maxWheelDiameter)
				searchResult.add(car);
		}
		return searchResult;
}

	public Set<Car> carSetDeleteByWheelsDiameter(Set<Car> carsSet,
		int minWheelDiameter, int maxWheelDiameter) {
		Set<Car> newCars = new LinkedHashSet<>();
		for (Car car : carsSet) {
			if (!(car.getWheelsDiameter() >= minWheelDiameter && car.getWheelsDiameter() <= maxWheelDiameter))
				newCars.add(car);
		}
		return newCars;
}

	public void carSetReplaceTyres(Set<Car> carsSet, String bodyColor,
			int minWheelDiameter, int maxWheelDiameter, String tyreType) {
		for (Car car : carsSet) {
			if (car.getColor().equals(bodyColor)
					&& car.getWheelsDiameter() >= minWheelDiameter && car.getWheelsDiameter() <= maxWheelDiameter)
					car.setTyreType(tyreType);
		}		
	}

	public List<Integer> carIndexSearchByBodyType(List<Car> cars,
			String bodyType) {
		List<Integer> indexList = new ArrayList<>();
		for (Car car : cars) {
			if (car.getBodyType().equals(bodyType))
				indexList.add(cars.indexOf(car));
		}
		return indexList;
	}

	public List<Car> carDeleteByBodyTypeAndSteeringWheelDiameter(
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

	public void carReplaceTyres(List<Car> cars, int minWheelDiameter,
			int maxWheelDiameter) {
		for (Car car : cars) {
			if (car.getWheelsDiameter() >= minWheelDiameter
					&& car.getWheelsDiameter() <= maxWheelDiameter)
				car.setTyreType("winter");
		}
	}

	public List<Car> carDeleteByBodyColor(List<Car> cars, String bodyColor) {
		List<Car> newCars = new ArrayList<>();
		for (Car car : cars) {
			if (!car.getColor().equals(bodyColor))
				newCars.add(car);
		}
		return newCars;
	}

	public List<Car> carSearchByBodyType(List<Car> cars, String bodyType) {
		List<Car> searchResult = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.getBodyType().equals(bodyType))
				searchResult.add(car);
		}
		return searchResult;
	}

	public void carReplaceCarsByWheelDiameter(List<Car> cars, int diameter) {
		for (Car car : cars) {
			if (car.getWheelsDiameter() < diameter)
				cars.set(cars.indexOf(car), new Car());
		}
	}

	public void carIncreaseWheelsDiameter(List<Car> cars) {
		for (Car car : cars) {
			if (car.isSteeringWheelHasButtons())
				car.setWheelsDiameter(car.getWheelsDiameter() * 2);
		}
	}

	public void carReplaceRedCarSteeringWheel(List<Car> cars,
			int steeringWheelChoice) {
		boolean hasButtons = (steeringWheelChoice == 1) ? true : false;
		for (Car car : cars) {
			if (car.getColor().equals("red"))
				car.setSteeringWheelHasButtons(hasButtons);
		}
	}

	public List<Car> carSearchByWheelDiameterAndBodyColor(List<Car> cars,
			int diameter, String bodyColor) {
		List<Car> searchResult = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.getWheelsDiameter() == diameter
					&& car.getColor().equals(bodyColor))
				searchResult.add(car);
		}
		return searchResult;
	}

	public List<Car> carSearchByWheelDiameter(List<Car> cars, int diameter) {
		List<Car> searchResult = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.getWheelsDiameter() == diameter)
				searchResult.add(car);
		}
		return searchResult;
	}

	public List<Car> createCars() {
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
	
	public Set<Car> createCarsSet() {
		Set<Car> cars = new LinkedHashSet<Car>();
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

	public void printCars(Collection<Car> cars) {
		for (Car car : cars) {
			System.out.println(car);
		}
		System.out.println("-----------------------------------------------");
	}

}
