package part4.chapter36;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MenuDemo extends Application {
    private MenuBar menuBar;
    private EventHandler<ActionEvent> menuEventHandler;
    private ContextMenu menuEdit;
    private ToolBar toolBarDebug;
    private Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demonstrate Menus -- Final Version");

        BorderPane rootNode = new BorderPane();

        Scene myScene = new Scene(rootNode, 300, 300);
        primaryStage.setScene(myScene);
        response = new Label();

        menuEventHandler = event -> {
            String name = ((MenuItem) event.getTarget()).getText();
            if (name.equals("Exit"))
                Platform.exit();
            response.setText(name + " selected");
        };

        menuBar = new MenuBar();

        makeFileMenu();

        makeOptionsMenu();

        makeHelpMenu();

        makeContextMenu();

        TextField textField = new TextField();
        textField.setPrefColumnCount(20);
        textField.setContextMenu(menuEdit);

        makeToolBar();

        rootNode.setOnContextMenuRequested(event -> menuEdit.show(rootNode, event.getScreenX(), event.getScreenY()));

        rootNode.setTop(menuBar);

        FlowPane flowPaneRoot = new FlowPane(10, 10);
        flowPaneRoot.setAlignment(Pos.CENTER);

        Separator separator = new Separator();
        separator.setPrefWidth(260);

        flowPaneRoot.getChildren().addAll(response, separator, textField);

        rootNode.setBottom(toolBarDebug);
        rootNode.setCenter(flowPaneRoot);
        primaryStage.show();
    }


    private void makeFileMenu() {
        Menu menuFile = new Menu("_File");

        MenuItem open = new MenuItem("Open");
        MenuItem close = new MenuItem("Close");
        MenuItem save = new MenuItem("Save");
        MenuItem exit = new MenuItem("Exit");

        menuFile.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);

        open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
        close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
        save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
        exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));

        open.setOnAction(menuEventHandler);
        close.setOnAction(menuEventHandler);
        save.setOnAction(menuEventHandler);
        exit.setOnAction(menuEventHandler);

        menuBar.getMenus().add(menuFile);
    }

    private void makeOptionsMenu() {
        Menu menuOptions = new Menu("_Options");

        Menu menuColors = new Menu("Colors");
        CheckMenuItem red = new CheckMenuItem("Red");
        CheckMenuItem green = new CheckMenuItem("Green");
        CheckMenuItem blue = new CheckMenuItem("Blue");
        menuColors.getItems().addAll(red, green, blue);
        menuOptions.getItems().add(menuColors);
        green.setSelected(true);

        Menu menuPriority = new Menu("Priority");
        RadioMenuItem high = new RadioMenuItem("High");
        RadioMenuItem low = new RadioMenuItem("Low");
        ToggleGroup toggleGroup = new ToggleGroup();
        high.setToggleGroup(toggleGroup);
        low.setToggleGroup(toggleGroup);
        high.setSelected(true);
        menuPriority.getItems().addAll(high, low);
        menuOptions.getItems().add(menuPriority);
        menuOptions.getItems().add(new SeparatorMenuItem());
        MenuItem reset = new MenuItem("Reset");
        menuOptions.getItems().add(reset);

        red.setOnAction(menuEventHandler);
        green.setOnAction(menuEventHandler);
        blue.setOnAction(menuEventHandler);
        high.setOnAction(menuEventHandler);
        low.setOnAction(menuEventHandler);
        reset.setOnAction(menuEventHandler);

        toggleGroup.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            if (newVal == null)
                return;
            RadioMenuItem radioMenuItem = (RadioMenuItem) newVal;
            response.setText("Priority selected is " + radioMenuItem.getText());
        });

        menuBar.getMenus().add(menuOptions);
    }

    private void makeHelpMenu() {
        Menu menuHelp = new Menu("_Help");
        MenuItem about = new MenuItem("About", new ImageView("http://icons.iconarchive.com/icons/aha-soft/free-3d-glossy-interface/16/information-icon.png"));
        menuHelp.getItems().add(about);
        about.setOnAction(menuEventHandler);
        menuBar.getMenus().add(menuHelp);
    }

    private void makeContextMenu() {
        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");
        menuEdit = new ContextMenu(cut, copy, paste);
        cut.setOnAction(menuEventHandler);
        copy.setOnAction(menuEventHandler);
        paste.setOnAction(menuEventHandler);
    }

    private void makeToolBar() {
        Button buttonSet = new Button("Set Breakpoint", new ImageView("https://www.iconexperience.com/_img/v_collection_png/16x16/plain/breakpoint_selection.png"));
        Button buttonClear = new Button("Clear Breakpoint", new ImageView("https://www.iconexperience.com/_img/v_collection_png/16x16/plain/breakpoint_delete.png"));
        Button buttonResume = new Button("Resume", new ImageView("https://www.iconexperience.com/_img/v_collection_png/16x16/plain/breakpoint_run.png"));
        buttonSet.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        buttonClear.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        buttonResume.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        buttonSet.setTooltip(new Tooltip("Set a breakpoint."));
        buttonClear.setTooltip(new Tooltip("Clear a breakpoint."));
        buttonResume.setTooltip(new Tooltip("Resume execution."));

        toolBarDebug = new ToolBar(buttonSet, buttonClear, buttonResume);
        EventHandler<ActionEvent> buttonHandler = event -> response.setText(((Button) event.getTarget()).getText());
        buttonSet.setOnAction(buttonHandler);
        buttonClear.setOnAction(buttonHandler);
        buttonResume.setOnAction(buttonHandler);
    }
}
