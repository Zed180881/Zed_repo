package part4.chapter35;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class EffectsAndTransformsDemo extends Application {
    double angle = 0.0;
    double glowVal = 0.0;
    boolean shadow = false;
    double scaleFactor = 1.0;

    Glow glow = new Glow(0.0);
    InnerShadow innerShadow = new InnerShadow(10.0, Color.RED);
    Rotate rotate = new Rotate();
    Scale scale = new Scale(scaleFactor, scaleFactor);

    Button buttonRotate = new Button("Rotate");
    Button buttonGlow = new Button("Glow");
    Button buttonShadow = new Button("Shadow");
    Button buttonScale = new Button("Scale");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Effects and Transforms Demo");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 100);
        primaryStage.setScene(myScene);
        buttonGlow.setEffect(glow);
        buttonRotate.getTransforms().add(rotate);
        buttonScale.getTransforms().add(scale);

        buttonRotate.setOnAction(event -> {
            angle += 30.0;
            rotate.setAngle(angle);
            rotate.setPivotX(buttonRotate.getWidth() / 2);
            rotate.setPivotY(buttonRotate.getHeight() / 2);
        });
        buttonScale.setOnAction(event -> {
            scaleFactor += 0.1;
            if (scaleFactor > 1.0)
                scaleFactor = 0.4;
            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        });
        buttonGlow.setOnAction(event -> {
            glowVal += 0.1;
            if (glowVal > 1.0)
                glowVal = 0.0;
            glow.setLevel(glowVal);
        });
        buttonShadow.setOnAction(event -> {
            shadow = !shadow;
            if (shadow) {
                buttonShadow.setEffect(innerShadow);
                buttonShadow.setText("Shadow On");
            } else {
                buttonShadow.setEffect(null);
                buttonShadow.setText("Shadow Off");
            }
        });

        rootNode.getChildren().addAll(buttonRotate, buttonScale, buttonGlow, buttonShadow);
        primaryStage.show();
    }
}
