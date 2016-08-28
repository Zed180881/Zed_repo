package ua.form.filter;

public class UserFilter {

    private String fullName;

    private String mail;

    private String phone;

    private String address;

    public String getFullName() {
	return fullName;
    }

    public void setFullName(String fullName) {
	this.fullName = fullName;
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

    @Override
    public String toString() {
	return "UserFilter [fullName=" + fullName + ", mail=" + mail
		+ ", phone=" + phone + ", address=" + address + "]";
    }
}
