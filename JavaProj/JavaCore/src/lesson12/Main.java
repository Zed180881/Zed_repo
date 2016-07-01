package lesson12;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	Person person = new Person.Builder().age(18).name("Ivan").build();
	@SuppressWarnings("unused")
	Person.Pet pet = person.new Pet("Barsik");
	@SuppressWarnings("unused")
	Person.Pet pet2 = new Person().new Pet("tuzik");

	@SuppressWarnings("unused")
	Comparator<Person> ascComparator = new Comparator<Person>() {

	    @Override
	    public int compare(Person o1, Person o2) {
		return o1.getName().compareTo(o2.getName());
	    }
	};

    }

    public static Comparator<Person> getDescComparator() {
	return new Comparator<Person>() {
	    @Override
	    public int compare(Person o1, Person o2) {
		return o2.getName().compareTo(o1.getName());
	    }
	};
    }

    public static Comparator<Person> getAscComparator() {
	return (Person o1, Person o2) -> o1.getName().compareTo(o2.getName());
    }

    public void doSomething() {
	class Foo {
	    void foo() {

	    }
	}
	Foo foo = new Foo();
	foo.foo();
    }

}
