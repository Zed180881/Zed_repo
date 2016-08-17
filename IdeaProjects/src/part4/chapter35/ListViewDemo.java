package part4.chapter35;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListView Demo");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 200, 120);
        primaryStage.setScene(myScene);
        response = new Label("Select Transport Type");

        ObservableList<String> transportTypes = FXCollections.observableArrayList("Train", "Car", "Airplane", "Bicycle", "Walking");
        final ListView<String> lvTransport = new ListView<>(transportTypes);
        lvTransport.setPrefSize(80, 80);
        MultipleSelectionModel<String> lvSelModel = lvTransport.getSelectionModel();
        lvSelModel.setSelectionMode(SelectionMode.MULTIPLE);
        lvSelModel.selectedItemProperty().addListener((changed, oldVal, newVal) -> {
            String selItems = "";
            ObservableList<String> selected = lvTransport.getSelectionModel().getSelectedItems();
            for (String s : selected) {
                selItems += "\n     " + s;
            }
            response.setText("All transports selected: " + selItems);
        });

        rootNode.getChildren().addAll(lvTransport, response);
        primaryStage.show();
    }
}
