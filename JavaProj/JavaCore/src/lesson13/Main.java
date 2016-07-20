package lesson13;

public class Main {

    public static void main(String[] args) {
	Container<String> container = new Container<String>();
	container.setElement("Hello");
	System.out.println(container.getElement());
//	print(container);

    }

    static void print(Container<? super Number> container) {
	container.setElement(1);
	System.out.println(container.getElement());
    }

}
