package part4.chapter35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CheckboxDemo extends Application {
    CheckBox checkBoxWeb;
    CheckBox checkBoxDesktop;
    CheckBox checkBoxMobile;
    Label response;
    Label allTargets;
    String targets = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate CheckBoxes");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 230, 140);
        primaryStage.setScene(myScene);
        Label heading = new Label("Select Deployment Options");
        response = new Label("No Deployment selected");
        allTargets = new Label("Target List: <none>");

        checkBoxWeb = new CheckBox("Web");
        checkBoxDesktop = new CheckBox("Desktop");
        checkBoxMobile = new CheckBox("Mobile");

        checkBoxWeb.setAllowIndeterminate(true);
        checkBoxDesktop.setAllowIndeterminate(true);
        checkBoxMobile.setAllowIndeterminate(true);

        checkBoxWeb.setTooltip(new Tooltip("Deploy to Web"));
        checkBoxDesktop.setTooltip(new Tooltip("Deploy to Desktop"));
        checkBoxMobile.setTooltip(new Tooltip("Deploy to Mobile"));

        checkBoxWeb.setOnAction(event -> {
            if (checkBoxWeb.isIndeterminate())
                response.setText("Web Deployment indeterminate.");
            else if (checkBoxWeb.isSelected())
                response.setText("Web Deployment selected.");
            else
                response.setText("Web Deployment cleared.");
            showAll();
        });
        checkBoxDesktop.setOnAction(event -> {
            if (checkBoxDesktop.isIndeterminate())
                response.setText("Desktop Deployment indeterminate.");
            else if (checkBoxDesktop.isSelected())
                response.setText("Desktop Deployment selected.");
            else
                response.setText("Desktop Deployment cleared.");
            showAll();
        });
        checkBoxMobile.setOnAction(event -> {
            if (checkBoxMobile.isIndeterminate())
                response.setText("Mobile Deployment indeterminate.");
            else if (checkBoxMobile.isSelected())
                response.setText("Mobile Deployment selected.");
            else
                response.setText("Mobile Deployment cleared.");
            showAll();
        });

        Separator separator = new Separator();
        separator.setPrefWidth(200);

        rootNode.getChildren().addAll(heading, separator, checkBoxWeb, checkBoxDesktop, checkBoxMobile, response, allTargets);
        primaryStage.show();
    }

    void showAll() {
        targets = "";
        if (checkBoxWeb.isSelected()) targets = "Web ";
        if (checkBoxDesktop.isSelected()) targets += "Desktop ";
        if (checkBoxMobile.isSelected()) targets += "Mobile";
        if (targets.equals("")) targets = "<none>";
        allTargets.setText("Target List: " + targets);
    }
}
