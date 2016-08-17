package part4.chapter35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RadioButtonDemo2 extends Application {
    Label response;
    ToggleGroup toggleGroup;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate Radio Buttons");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 200, 140);
        primaryStage.setScene(myScene);
        Label choose = new Label("    Select a Transport Type    ");
        response = new Label("No transport confirmed");
        Button buttonConfim = new Button("Confirm Transport Selection");

        RadioButton radioButtonTrain = new RadioButton("Train");
        RadioButton radioButtonCar = new RadioButton("Car");
        RadioButton radioButtonPlane = new RadioButton("Airplane");

        toggleGroup = new ToggleGroup();
        radioButtonTrain.setToggleGroup(toggleGroup);
        radioButtonCar.setToggleGroup(toggleGroup);
        radioButtonPlane.setToggleGroup(toggleGroup);
        radioButtonTrain.setSelected(true);

        buttonConfim.setOnAction(event -> response.setText(((RadioButton) toggleGroup.getSelectedToggle()).getText() + " is confirmed."));

        Separator separator = new Separator();
        separator.setPrefWidth(180);

        rootNode.getChildren().addAll(choose, radioButtonTrain, radioButtonCar, radioButtonPlane, separator, buttonConfim, response);
        primaryStage.show();
    }
}
