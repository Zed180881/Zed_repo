package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Producer {

    private int id;

    private String producerName;

    private List<Commodity> commodities = new ArrayList<Commodity>();

    public Producer() {
    }

    public Producer(String producerName) {
	this.producerName = producerName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
	return id;
    }

    public String getProducerName() {
	return producerName;
    }

    @OneToMany(mappedBy = "producer")
    public List<Commodity> getCommodities() {
	return commodities;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setProducerName(String producerName) {
	this.producerName = producerName;
    }

    public void setCommodities(List<Commodity> commodities) {
	this.commodities = commodities;
    }
}
