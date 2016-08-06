package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CommodityStatus {

    private int id;

    private String commodityStatusName;

    private List<Commodity> commodities = new ArrayList<Commodity>();

    public CommodityStatus() {
    }

    public CommodityStatus(String commodityStatusName) {
	this.commodityStatusName = commodityStatusName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
	return id;
    }

    public String getCommodityStatusName() {
	return commodityStatusName;
    }

    @OneToMany(mappedBy = "commodityStatus")
    public List<Commodity> getCommodities() {
	return commodities;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setCommodityStatusName(String commodityStatusName) {
	this.commodityStatusName = commodityStatusName;
    }

    public void setCommodities(List<Commodity> commodities) {
	this.commodities = commodities;
    }
}
