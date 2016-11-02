package resourcesaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;

public class ResourceDemo {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();
        System.out.println(file.getPath());
//        Resource res1 = ctx.getResource("file://" + file.getPath());
//        displayinfo(res1);
//        Resource res2 = ctx.getResource("classpath:test.txt");
//        displayinfo(res2);
        Resource resЗ = ctx.getResource("https://www.google.com.ua");
        displayinfo(resЗ);
    }

    private static void displayinfo(Resource res) throws Exception {
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println("");
    }
}
