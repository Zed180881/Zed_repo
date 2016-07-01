package lesson09;

public class Manufacturer {

    private final String title;
    private final String country;

    public Manufacturer(String title, String country) {
	super();
	this.title = title;
	this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
	return "Manufacturer ["
		+ (title != null ? "title=" + title + ", " : "")
		+ (country != null ? "country=" + country : "") + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
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
	Manufacturer other = (Manufacturer) obj;
	if (country == null) {
	    if (other.country != null)
		return false;
	} else if (!country.equals(other.country))
	    return false;
	if (title == null) {
	    if (other.title != null)
		return false;
	} else if (!title.equals(other.title))
	    return false;
	return true;
    }
    
    

}
