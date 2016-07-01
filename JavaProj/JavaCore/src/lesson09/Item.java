package lesson09;

public class Item {

    private final String title;
    private final Manufacturer manufacturer;
    private double price;
    private int quantity;
    private final Category category;

    public Item(String title, Manufacturer manufacturer, double price,
	    int quantity, Category category) {
	super();
	this.title = title;
	this.manufacturer = manufacturer;
	this.price = price;
	this.quantity = quantity;
	this.category = category;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public String getTitle() {
	return title;
    }

    public Manufacturer getManufacturer() {
	return manufacturer;
    }

    public Category getCategory() {
	return category;
    }

    @Override
    public String toString() {
	return "Item ["
		+ (title != null ? "title=" + title + ", " : "")
		+ (manufacturer != null ? "manufacturer=" + manufacturer + ", "
			: "") + "price=" + price + ", quantity=" + quantity
		+ ", " + (category != null ? "category=" + category : "") + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((category == null) ? 0 : category.hashCode());
	result = prime * result
		+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + quantity;
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
	Item other = (Item) obj;
	if (category != other.category)
	    return false;
	if (manufacturer == null) {
	    if (other.manufacturer != null)
		return false;
	} else if (!manufacturer.equals(other.manufacturer))
	    return false;
	if (Double.doubleToLongBits(price) != Double
		.doubleToLongBits(other.price))
	    return false;
	if (quantity != other.quantity)
	    return false;
	if (title == null) {
	    if (other.title != null)
		return false;
	} else if (!title.equals(other.title))
	    return false;
	return true;
    }
    
    
}
