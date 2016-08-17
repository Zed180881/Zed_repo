package part4.chapter35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonImageDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Use Images with Buttons");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 250, 450);
        primaryStage.setScene(myScene);
        response = new Label("Push a Button");
        Button buttonHourglass = new Button("Hourglass", new ImageView("http://icons.iconarchive.com/icons/messbook/outdated/24/Hourglass-Sandclock-icon.png"));
        Button buttonAnalogClock = new Button("Analog Clock", new ImageView("http://icons.iconarchive.com/icons/hopstarter/soft-scraps/24/Clock-icon.png"));
        buttonHourglass.setContentDisplay(ContentDisplay.TOP);
        buttonAnalogClock.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        buttonHourglass.setOnAction(e -> response.setText("Hourglass pressed"));
        buttonAnalogClock.setOnAction(e -> response.setText("Analog Clock pressed"));

        rootNode.getChildren().addAll(buttonHourglass, buttonAnalogClock, response);
        primaryStage.show();
    }
}
