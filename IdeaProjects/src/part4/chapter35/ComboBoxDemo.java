package part4.chapter35;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {
    ComboBox<String> comboBoxTransport;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ComboBox Demo");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 280, 120);
        primaryStage.setScene(myScene);
        response = new Label();

        ObservableList<String> transportTypes = FXCollections.observableArrayList("Train", "Car", "Airplane", "Bicycle", "Walking");
        comboBoxTransport = new ComboBox<>(transportTypes);
        comboBoxTransport.setValue("Train");

        response.setText("Selected transport is " + comboBoxTransport.getValue());

        comboBoxTransport.setOnAction(e -> response.setText("Selected transport is " + comboBoxTransport.getValue()));

        rootNode.getChildren().addAll(comboBoxTransport, response);
        primaryStage.show();
    }
}
