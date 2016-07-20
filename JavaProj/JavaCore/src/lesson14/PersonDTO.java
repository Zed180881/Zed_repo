package lesson14;

public class PersonDTO {

    private String name;
    private int age;
    private String nickName;

    public String getNickName() {
	return nickName;
    }

    public void setNickName(String nickName) {
	this.nickName = nickName;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    @Override
    public String toString() {
	return "PersonDTO [name=" + name + ", age=" + age + ", nickName="
		+ nickName + "]";
    }
}
