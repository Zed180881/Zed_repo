package lesson09;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final List<Item> items = new ArrayList<Item>();

    public void init() {
	items.add(new Item("Iphone", new Manufacturer("Apple", "USA"), 350.5,
		10, Category.INDUSTRY));
	items.add(new Item("Galaxy", new Manufacturer("Samsung", "Korea"),
		450.5, 25, Category.INDUSTRY));
	items.add(new Item("AK-47", new Manufacturer("Kalashnikov", "Russia"),
		200, 50, Category.WEARPONS));
	items.add(new Item("Colt", new Manufacturer("Colt", "USA"), 270, 65,
		Category.WEARPONS));
	items.add(new Item("Health Potion", new Manufacturer("Magic inc",
		"Narnia"), 20, 150, Category.ALCHEMY));
	items.add(new Item("Deadly Poison", new Manufacturer("Evil corp",
		"Narnia"), 276.15, 90, Category.ALCHEMY));
	items.add(new Item("Geforce 1080", new Manufacturer("Nvidia", "China"),
		650.6, 105, Category.INDUSTRY));
	items.add(new Item("Radeon 580X", new Manufacturer("AMD", "Korea"),
		550.10, 207, Category.INDUSTRY));
	items.add(new Item("Maysorubka", new Manufacturer("Babuska company",
		"Russia"), 20.3, 12, Category.INDUSTRY));
    }

    public void clear() {
	items.clear();
    }

    public int size() {
	return items.size();
    }

    public void addItem(String title, String manufacturerTitle, String country,
	    double price, int quantity, String categoryName) {
	Category category = Category.valueOf(categoryName);
	Manufacturer manufacturer = new Manufacturer(manufacturerTitle, country);
	Item item = new Item(title, manufacturer, price, quantity, category);
	items.add(item);
    }

    public void sellItem(String title, int quantity) {
	for (Item item : items) {
	    if (item.getTitle().equalsIgnoreCase(title)) {
		if (item.getQuantity() >= quantity) {
		    item.setQuantity(item.getQuantity() - quantity);
		    System.out.println("sell " + quantity + " items");
		} else
		    System.out.println("Not enough item");
	    }
	}
	removeIfSold();
    }

    private void removeIfSold() {
	items.removeIf((item) -> item.getQuantity() == 0);
    }

    public void sortByPrice() {
	items.sort((item1, item2) -> (int) (item1.getPrice() - item2.getPrice()));
    }

    public void increase(String categoryName, int percent) {
	Category category = Category.valueOf(categoryName);
	for (Item item : items) {
	    if (item.getCategory() == category) {
		item.setPrice(item.getPrice() * (100.0 + percent) / 100);
	    }
	}
    }

    public List<Item> getItems() {
	return items;
    }

}
