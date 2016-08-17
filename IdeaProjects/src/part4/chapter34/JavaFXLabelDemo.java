package part4.chapter34;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXLabelDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Demonstrate a JavaFX label.");
        FlowPane rootNode = new FlowPane();

        Scene myScene = new Scene(rootNode, 300, 200);
        primaryStage.setScene(myScene);
        Label myLabel = new Label("This is a JavaFX label");
        rootNode.getChildren().add(myLabel);
        primaryStage.show();
    }
}
