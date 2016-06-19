package lesson9Dz;

public class Pet {

    private String name;
    private String petType;

    public Pet(String name, String petType) {
	this.name = name;
	this.petType = petType;
    }

    public String getName() {
	return name;
    }

    public String getPetType() {
	return petType;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((petType == null) ? 0 : petType.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Pet other = (Pet) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (petType == null) {
	    if (other.petType != null)
		return false;
	} else if (!petType.equals(other.petType))
	    return false;
	return true;
    }
}