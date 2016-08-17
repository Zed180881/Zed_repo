package part4.chapter35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ImageDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Display an Image");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 200);
        primaryStage.setScene(myScene);

        Image hourglass = new Image("http://icons.iconarchive.com/icons/messbook/outdated/256/Hourglass-Sandclock-icon.png");
        ImageView hourglassIV = new ImageView(hourglass);
        rootNode.getChildren().add(hourglassIV);
        primaryStage.show();
    }
}
