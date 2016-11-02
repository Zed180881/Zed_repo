package main.java.helloworlddecoupledwithfactory;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }

}
