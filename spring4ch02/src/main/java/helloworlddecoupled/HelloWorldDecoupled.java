package main.java.helloworlddecoupled;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();

    }
}
