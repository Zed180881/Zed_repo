package part4.chapter35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LabelImageDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Use an Image in a Label");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 200);
        primaryStage.setScene(myScene);
        ImageView hourglassIV = new ImageView("http://icons.iconarchive.com/icons/messbook/outdated/24/Hourglass-Sandclock-icon.png");
        Label hourglassLabel = new Label("Hourglass", hourglassIV);
        rootNode.getChildren().add(hourglassLabel);
        primaryStage.show();
    }
}
