package part4.chapter34;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DirectDrawDemo extends Application {
    GraphicsContext graphicsContext;
    Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.BLACK};
    int colorIndex = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Draw directly to a Canvas.");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 450, 450);
        primaryStage.setScene(myScene);

        Canvas myCanvas = new Canvas(400, 400);
        graphicsContext = myCanvas.getGraphicsContext2D();

        Button buttonChangeColor = new Button("Change Color");
        buttonChangeColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                graphicsContext.setStroke(colors[colorIndex]);
                graphicsContext.setFill(colors[colorIndex]);
                graphicsContext.strokeLine(0, 0, 200, 200);
                graphicsContext.fillText("This is drawn on the canvas.", 60, 50);
                graphicsContext.fillRect(100, 320, 300, 40);
                colorIndex++;
                if (colorIndex == colors.length)
                    colorIndex = 0;
            }
        });
        graphicsContext.strokeLine(0, 0, 200, 200);
        graphicsContext.strokeOval(100, 100, 200, 200);
        graphicsContext.strokeRect(0, 200, 50, 200);
        graphicsContext.fillOval(0, 0, 20, 20);
        graphicsContext.fillRect(100, 320, 300, 40);

        graphicsContext.setFont(new Font(20));
        graphicsContext.fillText("This is drawn on the canvas.", 60, 50);

        rootNode.getChildren().addAll(myCanvas, buttonChangeColor);

        primaryStage.show();
    }
}
