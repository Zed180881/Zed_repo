package lesson01;

import java.util.List;

public class CommodityStatus {

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

    public List<Commodity> getGoods() {
        return commodities;
    }

    public void setGoods(List<Commodity> commodities) {
        this.commodities = commodities;
    }   
    
}