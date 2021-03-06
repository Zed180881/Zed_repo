package lesson09Dz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*�������� ���� ������� ������� ���� �����:
 Map<Person, List<Pet>> map;

 ������ � ��� ����� ������� ���� �� �� ������ �������� ���
 ��������� ��������.

 ���������� ��������� ����, ����� ����� ��� ����� ����:
 ������ �������� �����
 ������ �������� �� �������� �����
 �������� �������� � �������� �����
 �������� �������� �����
 �������� ��������� �������� � ��� ��������
 ������� �� ����� �������
 ����� � ��������

 ����������� ��� �������� ���� Switch.
 ������� ������� �� 60%

 �� �������� ������ �������� ������:
 �������� � �������
 ������������ � �������
 ������� � �������� �� �������
 �������� ���������� �� ������������.
 �������� ������� 40%*/

public class ZooClub {

    private HashMap<Person, ArrayList<Pet>> map;

    // public static void main(String[] args) throws IOException {
    // ZooClub zooClub = new ZooClub();
    // InputStream inputStream = System.in;
    // zooClub.run(inputStream);
    // }

    public ZooClub() {
	map = new HashMap<Person, ArrayList<Pet>>();
    }

    public HashMap<Person, ArrayList<Pet>> getMap() {
	return map;
    }

    public void run(InputStream inputStream) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		inputStream));
	fillZooClub();
	boolean isRun = true;
	while (isRun) {
	    System.out.println("������� ������� �����:");
	    System.out.println("1. ������ �������� �����.");
	    System.out.println("2. ������ �������� �� �������� �����.");
	    System.out.println("3. �������� �������� � �������� �����.");
	    System.out.println("4. �������� �������� �����.");
	    System.out.println("5. �������� ��� ������ � ��� ��������.");
	    System.out.println("6. ������� �� ����� �������.");
	    System.out.println("7. �������� ������� � �������.");
	    System.out.println("8. ������������ ������� � �������.");
	    System.out.println("9. ������� ������� � �������� �� �����.");
	    System.out.println("10. �������� �������.");
	    System.out.println("11. ����������� �������.");
	    System.out.println("0. �����");
	    int choice = Integer.parseInt(reader.readLine());
	    switch (choice) {
	    case 1: {
		addNewMember(reader);
		break;
	    }
	    case 2: {
		addNewPet(reader);
		break;
	    }
	    case 3: {
		deletePet(reader);
		break;
	    }
	    case 4: {
		deleteMember(reader);
		break;
	    }
	    case 5: {
		deleteAllPetsByType(reader);
		break;
	    }
	    case 6: {
		printZooClub();
		break;
	    }
	    case 7: {
		addToTextReportZooClub();
		break;
	    }
	    case 8: {
		createTextReportZooClub();
		break;
	    }
	    case 9: {
		printTextReportZooClub();
		break;
	    }
	    case 10: {
		saveZooClub();
		break;
	    }
	    case 11: {
		loadZooClub();
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

    @SuppressWarnings("unchecked")
    public void loadZooClub() {
	try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(
		"zoosave.data"))) {
	    map = (HashMap<Person, ArrayList<Pet>>) oos.readObject();
	} catch (IOException | ClassNotFoundException e) {
	}
    }

    public void saveZooClub() {
	try (ObjectOutputStream oos = new ObjectOutputStream(
		new FileOutputStream("zoosave.data"))) {
	    oos.writeObject(map);
	    oos.flush();
	} catch (IOException e) {
	}
    }

    public void printTextReportZooClub() {
	try (Scanner sc = new Scanner(new File("zoosummary.txt"))) {
	    while (sc.hasNextLine())
		System.out.println(sc.nextLine());
	} catch (IOException e) {
	}
    }

    private void createTextReportZooClub() {
	try (FileWriter fw = new FileWriter("zoosummary.txt", false)) {
	    for (Map.Entry<Person, ArrayList<Pet>> entry : getMap().entrySet()) {
		fw.append(entry.getKey().toString() + "\n");
		for (Pet pet : entry.getValue()) {
		    fw.append(pet.toString() + "\n");
		}
	    }
	} catch (IOException e) {
	}
    }

    private void addToTextReportZooClub() {
	try (FileWriter fw = new FileWriter("zoosummary.txt", true)) {
	    for (Map.Entry<Person, ArrayList<Pet>> entry : getMap().entrySet()) {
		fw.append(entry.getKey().toString() + "\n");
		for (Pet pet : entry.getValue()) {
		    fw.append(pet.toString() + "\n");
		}
	    }
	} catch (IOException e) {
	}
    }

    public void deleteAllPetsByType(BufferedReader reader) throws IOException {
	printZooClub();
	System.out.println("������ ��� �������� ��� ���������:");
	String petType = reader.readLine();
	for (Map.Entry<Person, ArrayList<Pet>> entry : map.entrySet()) {
	    entry.getValue().removeIf(((e) -> e.getPetType().equals(petType)));
	}
    }

    public void deleteMember(BufferedReader reader) throws IOException {
	printZooClub();
	System.out.println("������ ��� �� ������� �������� ��� ���������:");
	Person member = new Person(reader.readLine());
	if (map.containsKey(member)) {
	    map.remove(member);
	    System.out.println("�������� ����� ��������!");
	} else
	    System.out.println("���� ������ ��������!");
    }

    public void deletePet(BufferedReader reader) throws IOException {
	printZooClub();
	System.out
		.println("������ ��� �� ������� �������� ��� ��������� ��������:");
	Person member = new Person(reader.readLine());
	if (!map.containsKey(member)) {
	    System.out.println("���� ������ ��������!");
	    return;
	}
	System.out.println("������ ��� �������� ��� ���������:");
	String petName = reader.readLine();
	if (map.get(member).removeIf(((e) -> e.getName().equals(petName))))
	    System.out.println("�������� ��������!");
	else
	    System.out.println("����� �������� � ����� �������� ����!");
    }

    public void addNewPet(BufferedReader reader) throws IOException {
	printZooClub();
	System.out
		.println("������ ��� �� ������� �������� ��� ��������� ��������:");
	String memberName = reader.readLine();
	Person member = new Person(memberName);
	System.out.println("������ ��� ��������:");
	String petName = reader.readLine();
	System.out.println("������ ��� ��������:");
	String petType = reader.readLine();
	Pet newPet = new Pet(petName, petType);
	if (map.containsKey(member)) {
	    if (map.get(member).contains(newPet)) {
		System.out.println("���� �������� � ����� �������� ��� �!");
		return;
	    }
	    map.get(member).add(new Pet(petName, petType));
	} else
	    map.put(member, new ArrayList<>(Arrays.asList(newPet)));
    }

    public void printZooClub() {
	System.out.println("�������� ��������:");
	for (Map.Entry<Person, ArrayList<Pet>> entry : map.entrySet()) {
	    System.out.println(entry.getKey().getName());
	    System.out.print("�������: ");
	    for (Pet pet : entry.getValue()) {
		System.out.print(pet.getPetType() + " " + pet.getName() + ", ");
	    }
	    System.out.println();
	}
    }

    public void addNewMember(BufferedReader reader) throws IOException {
	System.out.println("��������� �������� �����:");
	System.out.println("������ ��� �� ������� ��������:");
	String name = reader.readLine();
	Person newMember = new Person(name);
	if (map.containsKey(newMember)) {
	    System.out.println("����� ������� ��� � � ����!");
	    return;
	}
	ArrayList<Pet> newMemberPets = new ArrayList<>();
	while (true) {
	    System.out
		    .println("������ ��� �� ��� �������� ����� ����� (X ��� ������):");
	    String s = reader.readLine();
	    if ("X".equals(s))
		break;
	    String[] petData = s.split(" ");
	    if (petData.length < 2) {
		System.out.println("���������� ����. �������� �� ���!");
		continue;
	    }
	    newMemberPets.add(new Pet(petData[0], petData[1]));
	}
	map.put(newMember, newMemberPets);
    }

    public void fillZooClub() {
	map.put(new Person("John Smith"),
		new ArrayList<>(Arrays.asList(new Pet("Tuzik", "dog"), new Pet(
			"Barsik", "cat"), new Pet("Nemo", "fish"))));
	map.put(new Person("Jack Daniels"),
		new ArrayList<>(Arrays.asList(new Pet("Tarzan", "monkey"),
			new Pet("Bagira", "cat"), new Pet("Snake", "snake"))));
	map.put(new Person("Lara Croft"),
		new ArrayList<>(Arrays.asList(new Pet("Fat", "hampster"),
			new Pet("Sharic", "dog"), new Pet("Barbos", "dog"))));
	map.put(new Person("Jack Ripper"),
		new ArrayList<>(Arrays.asList(new Pet("Killer", "dog"),
			new Pet("Anakonda", "snake"), new Pet("Ripper", "cat"))));
	map.put(new Person("John Flint"),
		new ArrayList<>(Arrays.asList(new Pet("Captain", "bird"),
			new Pet("BigRat", "rat"), new Pet("Layzi", "cat"))));
    }
}