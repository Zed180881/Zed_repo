package part4.chapter35;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate a TreeView");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 310, 460);
        primaryStage.setScene(myScene);
        response = new Label("No Selection");

        TreeItem<String> treeItemRoot = new TreeItem<>("Food");
        TreeItem<String> treeItemFruit = new TreeItem<>("Fruit");
        TreeItem<String> treeItemApples = new TreeItem<>("Apples");
        treeItemApples.getChildren().add(new TreeItem<>("Fuji"));
        treeItemApples.getChildren().add(new TreeItem<>("Winesap"));
        treeItemApples.getChildren().add(new TreeItem<>("Jonathan"));
        treeItemFruit.getChildren().add(treeItemApples);
        treeItemFruit.getChildren().add(new TreeItem<>("Pears"));
        treeItemFruit.getChildren().add(new TreeItem<>("Oranges"));

        treeItemRoot.getChildren().add(treeItemFruit);

        TreeItem<String> treeItemVegetables = new TreeItem<>("Vegetables");
        treeItemVegetables.getChildren().add(new TreeItem<>("Corn"));
        treeItemVegetables.getChildren().add(new TreeItem<>("Peas"));
        treeItemVegetables.getChildren().add(new TreeItem<>("Broccoli"));
        treeItemVegetables.getChildren().add(new TreeItem<>("Beans"));
        treeItemRoot.getChildren().add(treeItemVegetables);

        TreeItem<String> treeItemNuts = new TreeItem<>("Nuts");
        treeItemNuts.getChildren().add(new TreeItem<>("Walnuts"));
        treeItemNuts.getChildren().add(new TreeItem<>("Peanuts"));
        treeItemNuts.getChildren().add(new TreeItem<>("Pecans"));
        treeItemRoot.getChildren().add(treeItemNuts);

        TreeView<String> treeViewFood = new TreeView<>(treeItemRoot);
        MultipleSelectionModel<TreeItem<String>> treeViewSelModel = treeViewFood.getSelectionModel();
        treeViewSelModel.selectedItemProperty().addListener((changed, oldVal, newVal) -> {
            if (newVal != null) {
                String path = newVal.getValue();
                TreeItem<String> tmp = newVal.getParent();
                while (tmp != null) {
                    path = tmp.getValue() + " -> " + path;
                    tmp = tmp.getParent();
                }
                response.setText("Selection is " + newVal.getValue() + "\nComplete path is " + path);
            }
        });

        rootNode.getChildren().addAll(treeViewFood, response);
        primaryStage.show();
    }
}
