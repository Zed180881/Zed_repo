package part4.chapter35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RadioButtonDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate Radio Buttons");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 220, 120);
        primaryStage.setScene(myScene);
        response = new Label("");
        RadioButton radioButtonTrain = new RadioButton("Train");
        RadioButton radioButtonCar = new RadioButton("Car");
        RadioButton radioButtonPlane = new RadioButton("Airplane");

        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonTrain.setToggleGroup(toggleGroup);
        radioButtonCar.setToggleGroup(toggleGroup);
        radioButtonPlane.setToggleGroup(toggleGroup);

        /*radioButtonTrain.setOnAction(e -> response.setText("Transport selected is train."));
        radioButtonCar.setOnAction(e -> response.setText("Transport selected is car."));
        radioButtonPlane.setOnAction(e -> response.setText("Transport selected is airplane."));
        radioButtonTrain.fire();*/

        toggleGroup.selectedToggleProperty().addListener((changed, oldVal, newVal) -> response.setText("Transport selected is " + ((RadioButton) newVal).getText()));
        radioButtonTrain.setSelected(true);

        rootNode.getChildren().addAll(radioButtonTrain, radioButtonCar, radioButtonPlane, response);
        primaryStage.show();
    }
}
