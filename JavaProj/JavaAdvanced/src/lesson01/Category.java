package lesson01;

import java.util.List;

public class Category {

    private int id;

    private String name;

    private List<Commodity> commodities;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<Commodity> getCommodities() {
	return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
	this.commodities = commodities;
    }

}
