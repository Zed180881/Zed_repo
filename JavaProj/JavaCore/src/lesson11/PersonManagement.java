package lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonManagement extends ArrayList<Person> {

    private static final long serialVersionUID = -8969770811914012645L;

    @Override
    public boolean add(Person arg0) {
	if (!this.contains(arg0))
	    return super.add(arg0);
	return false;
    }

    public void addPerson(String name, String age) {
	int ageInt = Integer.valueOf(age);
	add(new Person(name, ageInt));
    }

    public List<String> forSummary() {
	// List<String> list = new ArrayList<>();
	// for (Person person : this) {
	// list.add(person.toString());
	// }
	// return list;
	return stream().map(Person::toString).collect(Collectors.toList());
    }

}
