package part4.chapter34;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXEventDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Demonstrate JavaFX Buttons and Events.");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 300, 100);
        primaryStage.setScene(myScene);

        response = new Label("Push a Button");
        Button buttonAlpha = new Button("Alpha");
        Button buttonBeta = new Button("Beta");
        buttonAlpha.setOnAction(e -> response.setText("Alpha was pressed."));
        buttonBeta.setOnAction(e -> response.setText("Beta was pressed."));

        rootNode.getChildren().addAll(buttonAlpha, buttonBeta, response);
        primaryStage.show();
    }
}
