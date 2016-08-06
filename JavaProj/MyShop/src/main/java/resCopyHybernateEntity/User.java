package resCopyHybernateEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

    private int id;

    private String fullName;

    private String login;

    private String password;

    private String mail;

    private String phone;

    private String address;

    private List<CommodityOrder> commodityOrders = new ArrayList<CommodityOrder>();

    public User() {
    }

    public User(String fullName, String login, String password, String mail,
	    String phone, String address) {
	this.fullName = fullName;
	this.login = login;
	this.password = password;
	this.mail = mail;
	this.phone = phone;
	this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
	return id;
    }

    public String getFullName() {
	return fullName;
    }

    public String getLogin() {
	return login;
    }

    public String getPassword() {
	return password;
    }

    public String getMail() {
	return mail;
    }

    public String getPhone() {
	return phone;
    }

    public String getAddress() {
	return address;
    }

    @OneToMany(mappedBy = "user")
    public List<CommodityOrder> getCommodityOrders() {
	return commodityOrders;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setFullName(String fullName) {
	this.fullName = fullName;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setMail(String mail) {
	this.mail = mail;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public void setCommodityOrders(List<CommodityOrder> commodityOrders) {
	this.commodityOrders = commodityOrders;
    }
}
