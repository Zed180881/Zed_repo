package lesson09Dz;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class ZooClubTest {

    HashMap<Person, ArrayList<Pet>> mapToCheck;
    ZooClub zooClub;

    @Before
    public void initTestCase() {
	zooClub = new ZooClub();
	mapToCheck = new HashMap<Person, ArrayList<Pet>>();
    }

    @Test
    public void zooClubTest() throws IOException {
	InputStream inputStream = new FileInputStream("arguments_zoo.txt");
	zooClub.run(inputStream);
    }

    @Test
    public void createListTest() {
	zooClub.fillZooClub();
	mapToCheck.put(
		new Person("John Smith"),
		new ArrayList<>(Arrays.asList(new Pet("Tuzik", "dog"), new Pet(
			"Barsik", "cat"), new Pet("Nemo", "fish"))));
	mapToCheck.put(
		new Person("Jack Daniels"),
		new ArrayList<>(Arrays.asList(new Pet("Tarzan", "monkey"),
			new Pet("Bagira", "cat"), new Pet("Snake", "snake"))));
	mapToCheck.put(
		new Person("Lara Croft"),
		new ArrayList<>(Arrays.asList(new Pet("Fat", "hampster"),
			new Pet("Sharic", "dog"), new Pet("Barbos", "dog"))));
	mapToCheck
		.put(new Person("Jack Ripper"),
			new ArrayList<>(Arrays.asList(new Pet("Killer", "dog"),
				new Pet("Anakonda", "snake"), new Pet("Ripper",
					"cat"))));
	mapToCheck.put(
		new Person("John Flint"),
		new ArrayList<>(Arrays.asList(new Pet("Captain", "bird"),
			new Pet("BigRat", "rat"), new Pet("Layzi", "cat"))));
	assertEquals(mapToCheck, zooClub.getMap());
    }

    @Test
    public void addNewMemberTest() throws IOException {
	zooClub.fillZooClub();
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		new FileInputStream("arguments_zoo_add.txt")));
	zooClub.addNewMember(reader);
	zooClub.addNewMember(reader);
	mapToCheck.put(
		new Person("John Smith"),
		new ArrayList<>(Arrays.asList(new Pet("Tuzik", "dog"), new Pet(
			"Barsik", "cat"), new Pet("Nemo", "fish"))));
	mapToCheck.put(
		new Person("Jack Daniels"),
		new ArrayList<>(Arrays.asList(new Pet("Tarzan", "monkey"),
			new Pet("Bagira", "cat"), new Pet("Snake", "snake"))));
	mapToCheck.put(
		new Person("Lara Croft"),
		new ArrayList<>(Arrays.asList(new Pet("Fat", "hampster"),
			new Pet("Sharic", "dog"), new Pet("Barbos", "dog"))));
	mapToCheck
		.put(new Person("Jack Ripper"),
			new ArrayList<>(Arrays.asList(new Pet("Killer", "dog"),
				new Pet("Anakonda", "snake"), new Pet("Ripper",
					"cat"))));
	mapToCheck.put(
		new Person("John Flint"),
		new ArrayList<>(Arrays.asList(new Pet("Captain", "bird"),
			new Pet("BigRat", "rat"), new Pet("Layzi", "cat"))));
	mapToCheck.put(
		new Person("Pjotr Zeljonka"),
		new ArrayList<>(Arrays.asList(new Pet("Pushok", "cat"),
			new Pet("Bobic", "dog"))));
	assertEquals(mapToCheck, zooClub.getMap());
    }

    @Test
    public void addNewPetTest() throws IOException {
	zooClub.fillZooClub();
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		new FileInputStream("arguments_zoo_addPet.txt")));
	zooClub.addNewPet(reader);
	zooClub.addNewPet(reader);
	zooClub.addNewPet(reader);
	mapToCheck.put(
		new Person("John Smith"),
		new ArrayList<>(Arrays.asList(new Pet("Tuzik", "dog"), new Pet(
			"Barsik", "cat"), new Pet("Nemo", "fish"), new Pet(
			"Srun", "bird"))));
	mapToCheck.put(
		new Person("Jack Daniels"),
		new ArrayList<>(Arrays.asList(new Pet("Tarzan", "monkey"),
			new Pet("Bagira", "cat"), new Pet("Snake", "snake"))));
	mapToCheck.put(
		new Person("Lara Croft"),
		new ArrayList<>(Arrays.asList(new Pet("Fat", "hampster"),
			new Pet("Sharic", "dog"), new Pet("Barbos", "dog"))));
	mapToCheck
		.put(new Person("Jack Ripper"),
			new ArrayList<>(Arrays.asList(new Pet("Killer", "dog"),
				new Pet("Anakonda", "snake"), new Pet("Ripper",
					"cat"))));
	mapToCheck.put(
		new Person("John Flint"),
		new ArrayList<>(Arrays.asList(new Pet("Captain", "bird"),
			new Pet("BigRat", "rat"), new Pet("Layzi", "cat"))));
	mapToCheck.put(new Person("Billy Bons"),
		new ArrayList<>(Arrays.asList(new Pet("Ratty", "rat"))));
	assertEquals(mapToCheck, zooClub.getMap());
    }

    @Test
    public void deletePetTest() throws IOException {
	zooClub.fillZooClub();
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		new FileInputStream("arguments_zoo_deletePet.txt")));
	zooClub.deletePet(reader);
	zooClub.deletePet(reader);
	zooClub.deletePet(reader);
	mapToCheck.put(
		new Person("John Smith"),
		new ArrayList<>(Arrays.asList(new Pet("Barsik", "cat"),
			new Pet("Nemo", "fish"))));
	mapToCheck.put(
		new Person("Jack Daniels"),
		new ArrayList<>(Arrays.asList(new Pet("Tarzan", "monkey"),
			new Pet("Bagira", "cat"), new Pet("Snake", "snake"))));
	mapToCheck.put(
		new Person("Lara Croft"),
		new ArrayList<>(Arrays.asList(new Pet("Fat", "hampster"),
			new Pet("Sharic", "dog"), new Pet("Barbos", "dog"))));
	mapToCheck
		.put(new Person("Jack Ripper"),
			new ArrayList<>(Arrays.asList(new Pet("Killer", "dog"),
				new Pet("Anakonda", "snake"), new Pet("Ripper",
					"cat"))));
	mapToCheck.put(
		new Person("John Flint"),
		new ArrayList<>(Arrays.asList(new Pet("Captain", "bird"),
			new Pet("BigRat", "rat"), new Pet("Layzi", "cat"))));
	assertEquals(mapToCheck, zooClub.getMap());
    }

    @Test
    public void deleteMemberTest() throws IOException {
	zooClub.fillZooClub();
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		new FileInputStream("arguments_zoo_deleteMember.txt")));
	zooClub.deleteMember(reader);
	zooClub.deleteMember(reader);
	mapToCheck.put(
		new Person("Jack Daniels"),
		new ArrayList<>(Arrays.asList(new Pet("Tarzan", "monkey"),
			new Pet("Bagira", "cat"), new Pet("Snake", "snake"))));
	mapToCheck.put(
		new Person("Lara Croft"),
		new ArrayList<>(Arrays.asList(new Pet("Fat", "hampster"),
			new Pet("Sharic", "dog"), new Pet("Barbos", "dog"))));
	mapToCheck
		.put(new Person("Jack Ripper"),
			new ArrayList<>(Arrays.asList(new Pet("Killer", "dog"),
				new Pet("Anakonda", "snake"), new Pet("Ripper",
					"cat"))));
	mapToCheck.put(
		new Person("John Flint"),
		new ArrayList<>(Arrays.asList(new Pet("Captain", "bird"),
			new Pet("BigRat", "rat"), new Pet("Layzi", "cat"))));
	assertEquals(mapToCheck, zooClub.getMap());
    }

    @Test
    public void deleteAllPetsByTypeTest() throws IOException {
	zooClub.fillZooClub();
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		new FileInputStream("arguments_zoo_deleteAllPets.txt")));
	zooClub.deleteAllPetsByType(reader);
	zooClub.deleteAllPetsByType(reader);
	mapToCheck.put(
		new Person("John Smith"),
		new ArrayList<>(Arrays.asList(new Pet("Barsik", "cat"),
			new Pet("Nemo", "fish"))));
	mapToCheck.put(
		new Person("Jack Daniels"),
		new ArrayList<>(Arrays.asList(new Pet("Tarzan", "monkey"),
			new Pet("Bagira", "cat"), new Pet("Snake", "snake"))));
	mapToCheck.put(new Person("Lara Croft"),
		new ArrayList<>(Arrays.asList(new Pet("Fat", "hampster"))));
	mapToCheck.put(
		new Person("Jack Ripper"),
		new ArrayList<>(Arrays.asList(new Pet("Anakonda", "snake"),
			new Pet("Ripper", "cat"))));
	mapToCheck.put(
		new Person("John Flint"),
		new ArrayList<>(Arrays.asList(new Pet("Captain", "bird"),
			new Pet("BigRat", "rat"), new Pet("Layzi", "cat"))));
	assertEquals(mapToCheck, zooClub.getMap());
    }

    @Test
    public void hashCodeTest() {
	Pet pet1 = new Pet("BigRat", "rat");
	Pet pet2 = new Pet("BigRat", "rat");
	assertEquals(pet1.hashCode(), pet2.hashCode());
	pet1 = new Pet(null, "rat");
	pet2 = new Pet(null, "rat");
	assertEquals(pet1.hashCode(), pet2.hashCode());
	pet1 = new Pet("BigRat", null);
	pet2 = new Pet("BigRat", null);
	assertEquals(pet1.hashCode(), pet2.hashCode());
	Person p1 = new Person("John Smith");
	Person p2 = new Person("John Smith");
	assertEquals(p1.hashCode(), p2.hashCode());
	p1 = new Person(null);
	p2 = new Person(null);
	assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void equalsPetTest() {
	Pet pet1 = new Pet("BigRat", "rat");
	Pet pet2 = new Pet("BigRat", "rat");
	assertTrue(pet1.equals(pet2));
	pet2 = pet1;
	assertTrue(pet1.equals(pet2));
	pet2 = null;
	assertFalse(pet1.equals(pet2));
	assertFalse(pet1.equals(new Person("John Smith")));
	pet1 = new Pet(null, "rat");
	pet2 = new Pet("BigRat", "rat");
	assertFalse(pet1.equals(pet2));
	pet2 = new Pet(null, "rat");
	assertTrue(pet1.equals(pet2));
	pet1 = new Pet("BigRat", null);
	pet2 = new Pet("BigRat", "rat");
	assertFalse(pet1.equals(pet2));
	pet2 = new Pet("BigRat", null);
	assertTrue(pet1.equals(pet2));
	pet1 = new Pet("BigRat", "rat");
	pet2 = new Pet("LitleRat", "rat");
	assertFalse(pet1.equals(pet2));
	pet1 = new Pet("BigRat", "rat");
	pet2 = new Pet("BigRat", "cat");
	assertFalse(pet1.equals(pet2));
    }

    @Test
    public void equalsPersonTest() {
	Person p1 = new Person("Jack");
	Person p2 = new Person("Jack");
	assertTrue(p1.equals(p2));
	p2 = p1;
	assertTrue(p1.equals(p2));
	p2 = null;
	assertFalse(p1.equals(p2));
	assertFalse(p1.equals(new Pet("Bobic", "dog")));
	p1 = new Person(null);
	p2 = new Person("Jack");
	assertFalse(p1.equals(p2));
	p2 = new Person(null);
	assertTrue(p1.equals(p2));
	p1 = new Person("Jack");
	p2 = new Person("John");
	assertFalse(p1.equals(p2));
    }
}