package com.example.tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AppManager.setDefaultSittings();

        Pane pane=new Pane();
        pane.setStyle("-fx-background-color: white;");
        pane.getChildren().addAll(AppManager.startPane,AppManager.singlePlayerPane,AppManager.multiPlayerPane
                ,AppManager.settingPane,AppManager.gamePane);

        AppManager.viewPane(AppManager.startPane);
        AppManager.startPane.setStyle( "-fx-background-color: white;");
        Scene scene = new Scene(pane, 380, 500);
        stage.setTitle("Tic Tac Toe!");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}