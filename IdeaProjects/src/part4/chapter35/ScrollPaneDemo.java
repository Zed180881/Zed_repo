package part4.chapter35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ScrollPaneDemo extends Application {
    ScrollPane scrollPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate a ScrollPane");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 200, 200);
        primaryStage.setScene(myScene);
        Label scrollLabel = new Label(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin\n" +
                        " dignissim arcu quis ante iaculis, in elementum dui mollis.\n" +
                        " Nulla molestie, tortor id ultricies ultrices, ante magna\n" +
                        " tempor quam, sed tempor leo felis eget turpis. Sed lorem\n" +
                        " magna, placerat eu enim eget, faucibus varius elit. Aenean\n" +
                        " tortor ipsum, aliquam sed iaculis a, pulvinar quis risus.\n" +
                        " Morbi erat orci, dignissim sollicitudin aliquam quis,\n" +
                        " dapibus sit amet risus. Nulla facilisi. Morbi finibus\n" +
                        " egestas tortor, at tristique purus semper sit amet. Ut\n" +
                        " ultrices ante non enim scelerisque, eget varius libero\n" +
                        " venenatis. Suspendisse ornare ultricies placerat. Vestibulum\n" +
                        " commodo quam quis justo ultrices malesuada. Fusce a luctus\n" +
                        " elit. Donec enim leo, luctus sit amet porttitor vel,\n" +
                        " lobortis ac massa. Cum sociis natoque penatibus et magnis\n" +
                        " dis parturient montes, nascetur ridiculus mus. Cras\n" +
                        " volutpat fringilla ipsum. Phasellus ut ante placerat,\n" +
                        " ultricies sapien eget, volutpat justo. Nunc sem massa,\n" +
                        " venenatis a sapien nec, vulputate malesuada metus. Interdum\n" +
                        " et malesuada fames ac ante ipsum primis in faucibus.\n" +
                        " Aliquam tincidunt faucibus neque, nec auctor diam vehicula\n");
        scrollPane = new ScrollPane(scrollLabel);
        scrollPane.setPrefViewportWidth(130);
        scrollPane.setPrefViewportHeight(80);
        scrollPane.setPannable(true);

        Button buttonReset = new Button("Reset ScrollBar positions");
        buttonReset.setOnAction(event -> {
            scrollPane.setVvalue(0);
            scrollPane.setHvalue(0);
        });

        rootNode.getChildren().addAll(scrollPane, buttonReset);
        primaryStage.show();
    }
}
