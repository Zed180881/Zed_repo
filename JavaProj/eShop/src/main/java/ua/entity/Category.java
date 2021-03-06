package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(indexes = @Index(columnList = "categoryName"))
public class Category {

    private int id;

    private String categoryName;

    private String path;

    private int version;    

    private MultipartFile file;

    private List<Commodity> commodities = new ArrayList<>();

    public Category() {
    }

    public Category(String categoryName) {
	this.categoryName = categoryName;
    }

    public String getPath() {
	return path;
    }

    public void setPath(String path) {
	this.path = path;
    }

    public int getVersion() {
	return version;
    }

    public void setVersion(int version) {
	this.version = version;
    }
    @Transient
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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
