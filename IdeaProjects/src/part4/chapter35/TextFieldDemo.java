package part4.chapter35;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextFieldDemo extends Application {
    TextField textField;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate a TextField");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 230, 140);
        primaryStage.setScene(myScene);
        response = new Label("Search String: ");
        Button buttonGetText = new Button("Get Search String");
        textField = new TextField();
        textField.setPromptText("Enter Search String");
        textField.setPrefColumnCount(15);
        textField.setOnAction(event -> response.setText("Search String: " + textField.getText()));
        buttonGetText.setOnAction(event -> response.setText("Search String: " + textField.getText()));
        Separator separator = new Separator();
        separator.setPrefWidth(180);

        rootNode.getChildren().addAll(textField, buttonGetText, separator, response);
        primaryStage.show();
    }
}
