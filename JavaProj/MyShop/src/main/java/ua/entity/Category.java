package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

    private int id;

    private String categoryName;

    private List<Commodity> commodities = new ArrayList<>();

    public Category() {
    }

    public Category(String categoryName) {
	this.categoryName = categoryName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
	return id;
    }

    public String getCategoryName() {
	return categoryName;
    }

    @OneToMany(mappedBy = "category")
    public List<Commodity> getCommodities() {
	return commodities;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
    }

    public void setCommodities(List<Commodity> commodities) {
	this.commodities = commodities;
    }
}
