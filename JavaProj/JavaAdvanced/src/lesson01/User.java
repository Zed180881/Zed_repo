package lesson01;

import java.util.List;

public class User {

    private int id;

    private String login;

    private String password;

    private String fio;

    private String mail;

    private String phone;

    private String address;

    private List<Order> orders;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getFio() {
	return fio;
    }

    public void setFio(String fio) {
	this.fio = fio;
    }

    public String getMail() {
	return mail;
    }

    public void setMail(String mail) {
	this.mail = mail;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public List<Order> getOrders() {
	return orders;
    }

    public void setOrders(List<Order> orders) {
	this.orders = orders;
    }
}
