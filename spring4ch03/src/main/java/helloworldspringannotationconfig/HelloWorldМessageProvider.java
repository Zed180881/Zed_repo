package main.java.helloworldspringannotationconfig;

import org.springframework.stereotype.Service;

@Service("messageProvider")
public class HelloWorldМessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World ! ";
    }
}
