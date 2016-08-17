package part4.chapter35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ToggleButtonDemo extends Application {
    ToggleButton toggleButtonOnOff;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate a Toggle Button");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 220, 120);
        primaryStage.setScene(myScene);
        response = new Label("Push the Button.");
        toggleButtonOnOff = new ToggleButton("On/Off");
        toggleButtonOnOff.setOnAction(e -> {
            if (toggleButtonOnOff.isSelected())
                response.setText("Button is on.");
            else response.setText("Button is off.");
        });

        rootNode.getChildren().addAll(toggleButtonOnOff, response);
        primaryStage.show();
    }
}
