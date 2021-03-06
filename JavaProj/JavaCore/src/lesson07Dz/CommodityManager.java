package lesson07Dz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*���������� �������� � ���������� ����. ����������� Scanner. ��������
 ���� Commodity.������� ����� ���� ������ - ������� ������. ��������
 �������������� ����, � ����� ������� �������� ������ ��� ������ �
 ����� ��'����:

 1. ������ ����� � ���.

 2. �������� ����� � ���� (������� ��� �� ��������� ���������, ���
 �� ������� �������).

 3. ������� ����� � ���.

 4. ����������� �� ������ (��� ���������� ������� ������� ����, ���
 ��������� �� ����� ���� �����������. ϳ��� ������ ���� ������ ������
 ����������). �������� �� ��������� �����������.

 0. ����� � ��������.

 ������� ������� �� 70%*/

public class CommodityManager {

	private List<Commodity> commodityList;

	// public static void main(String[] args) throws IOException {
	// CommodityManager commodityManager = new CommodityManager();
	// InputStream inputStream = System.in;
	// commodityManager.run(inputStream);
	// }
	
	
	public void run(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		fillCommodityList();
		boolean isRun = true;		
		while (isRun) {
			System.out.println("������� ������� �����:");
			System.out.println("1. ������ ����� � ������.");
			System.out.println("2. �������� ����� � ������");
			System.out.println("3. ������� ����� � � ������.");
			System.out.println("4. ³���������� ����� � ������.");			
			System.out.println("0. �����");			
			int choice = Integer.parseInt(reader.readLine());			
			switch (choice) {
			case 1: {
				printCommodityList();
				System.out.println("��������� ������:");
				System.out.println("������ Id ������:");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("������ ����� ������:");
				String name = reader.readLine();
				System.out.println("������ ������� ������:");
				int quantity = Integer.parseInt(reader.readLine());
				System.out.println("������ ���� ������:");
				double price = Double.parseDouble(reader.readLine());
				Commodity commodity = new Commodity(id, name, quantity, price);
				addCommodity(commodity);
				printCommodityList();
				break;
			}
			case 2: {
				printCommodityList();
				System.out.println("������ ID ��� ����� ������ ��� ���������:");
				String s = reader.readLine();
				try{
					int id = Integer.parseInt(s);
					deleteCommodity(id);
				}
				catch (Exception e){
					deleteCommodity(s);
				}	
				printCommodityList();
				break;
			}
			case 3: {
				printCommodityList();
				System.out.println("������ ID ������ ��� �����:");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("������ ����� ������ ������:");
				String name = reader.readLine();
				System.out.println("������ ������� ������ ������:");
				int quantity = Integer.parseInt(reader.readLine());
				System.out.println("������ ���� ������ ������:");
				double price = Double.parseDouble(reader.readLine());
				Commodity commodity = new Commodity(id, name, quantity, price);
				replaceCommodity(id, commodity);
				printCommodityList();
				break;
			}
			case 4: {
				printCommodityList();
				System.out.println("�� ����� ���� ���������:");
				System.out.println("1. Id ������");
				System.out.println("2. ����� ������");
				System.out.println("3. ʳ������ ������");
				System.out.println("4. ֳ�� ������");
				int field = Integer.parseInt(reader.readLine());
				System.out.println("������ ������� ����������:");
				System.out.println("1. ����� ����������");
				System.out.println("2. �������� ����������");
				int order = Integer.parseInt(reader.readLine());
				boolean reverse = (order == 1) ? false : true;
				switch (field) {
				case 1: {
					sortById(reverse);
					break;
				}
				case 2: {
					sortByName(reverse);
					break;
				}
				case 3: {
					sortByQuantity(reverse);
					break;
				}
				case 4: {
					sortByPrice(reverse);
					break;
				}
				default: {					
					break;
				}
				}				
				printCommodityList();
				break;
				}			
			case 0: {
				isRun = false;
				break;
			}
			default:
				System.out.println("���������� ����! ��������� �� ���!");
				break;
			}
		}
	}
	
	public void printCommodityList() {
		for (Commodity commodity: getCommodityList()){
			System.out.println(commodity);
		}
		System.out.println("-------------------------------");		
	}

	public CommodityManager() {
		commodityList = new ArrayList<>();
	}

	public List<Commodity> getCommodityList() {
		return commodityList;
	}

	public void addCommodity(Commodity commodity) {
		getCommodityList().add(commodity);
	}

	public void deleteCommodity(int id) {
		getCommodityList().removeIf((e) -> e.getId() == id);
	}
	
	public void deleteCommodity(String name) {
		getCommodityList().removeIf((e) -> e.getName().equals(name));
	}
	
	public void replaceCommodity(int id, Commodity newCommodity) {
		for (Commodity commodity: getCommodityList()){
			if (commodity.getId()==id)
				getCommodityList().set(getCommodityList().indexOf(commodity), newCommodity);
		}
	}
		
	public void sortById(boolean reverse) {
		if (!reverse)
			getCommodityList().sort((o1, o2) -> o1.getId()- o2.getId());
		else
			getCommodityList().sort((o2, o1) -> o1.getId()- o2.getId());
	}
	
	public void sortByName(boolean reverse) {
		if (!reverse)
			getCommodityList().sort((o1, o2) -> o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()));
		else
			getCommodityList().sort((o2, o1) -> o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()));
	}
	
	public void sortByPrice(boolean reverse) {
		if (!reverse)
			getCommodityList().sort((o1, o2) -> (int)((o1.getPrice() - o2.getPrice())*100.0));
		else
			getCommodityList().sort((o2, o1) -> (int)((o1.getPrice() - o2.getPrice())*100.0));
	}
	
	public void sortByQuantity(boolean reverse) {
		if (!reverse)
			getCommodityList().sort((o1, o2) -> o1.getQuantity() - o2.getQuantity());
		else
			getCommodityList().sort((o2, o1) -> o1.getQuantity() - o2.getQuantity());
	}
	
	public void fillCommodityList(){
		getCommodityList().add(new Commodity(1, "Kent", 150, 24.5));
		getCommodityList().add(new Commodity(25, "R1", 100, 20.1));
		getCommodityList().add(new Commodity(15, "LM", 200, 16.5));
		getCommodityList().add(new Commodity(11, "Bond", 58, 14.35));
		getCommodityList().add(new Commodity(16, "Prima", 70, 12.5));
		getCommodityList().add(new Commodity(19, "Lucky Strike", 66, 16.9));
		getCommodityList().add(new Commodity(2, "Davidoff", 100, 25.1));
		getCommodityList().add(new Commodity(13, "Vogue", 300, 18.1));
		getCommodityList().add(new Commodity(3, "Sobranie", 15, 32.3));
		getCommodityList().add(new Commodity(5, "Rotmans", 89, 22.15));
	}
}