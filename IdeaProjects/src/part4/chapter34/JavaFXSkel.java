package part4.chapter34;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXSkel extends Application {

    public static void main(String[] args) {
        System.out.println("Launch Java-FX application.");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("Into init() method.");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Into start() method.");
        primaryStage.setTitle("JavaFX Skeleton.");
        FlowPane rootNode = new FlowPane();

        Scene myScene = new Scene(rootNode, 300, 200);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Into stop() method.");
    }
}
