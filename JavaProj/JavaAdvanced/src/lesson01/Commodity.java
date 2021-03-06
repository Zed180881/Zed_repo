package lesson01;

public class Commodity {
    
    private int id;
    
    private Category category;
    
    private String model;
    
    private Producer producer;
    
    private int quantity;
    
    private double price;
    
    private CommodityStatus status;
    
    private int warranty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CommodityStatus getStatus() {
        return status;
    }

    public void setStatus(CommodityStatus status) {
        this.status = status;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }    
   
    
}
