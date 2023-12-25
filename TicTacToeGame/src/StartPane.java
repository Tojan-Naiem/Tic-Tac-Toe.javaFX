package com.example.tictactoegame;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class StartPane extends Pane {

    Button singlePlayer=new Button("Single Player");
    Button multiPlayer=new Button("Multi Player");
    Button setting =new Button("Setting");
    Button about =new Button("About");
    Button exit=new Button("Exit");
    public StartPane()
    {
        //single palyer button
        singlePlayer.setLayoutX(80);
        singlePlayer.setLayoutY(230);
        singlePlayer.setPrefSize(200,30);
        singlePlayer.setStyle("-fx-background-color: red;");
        singlePlayer.setFont(new Font("times new roman", 17));
        //multi player button
        multiPlayer.setLayoutX(80);
        multiPlayer.setLayoutY(270);
        multiPlayer.setPrefSize(200,30);
        multiPlayer.setStyle("-fx-background-color: red;");
        //Setting button
        setting.setLayoutX(80);
        setting.setLayoutY(310);
        setting.setPrefSize(200,30);
        setting.setStyle("-fx-background-color: red;");
        //about button
        about.setLayoutX(80);
        about.setLayoutY(350);
        about.setPrefSize(200,30);
        about.setStyle("-fx-background-color: red;");
        //exit button
        exit.setLayoutX(80);
        exit.setLayoutY(390);
        exit.setPrefSize(200,30);
        exit.setStyle("-fx-background-color: red;");

        ImageView imageView=new ImageView(new Image(getClass().getResourceAsStream("/images/tic-tac-toe.png")));
        imageView.setLayoutX(100);
        imageView.setLayoutY(50);
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        getChildren().addAll(singlePlayer,multiPlayer,setting,about,exit,imageView);//adding all the button in the pane

        Alert alert=new Alert(Alert.AlertType.INFORMATION);//making alert to display about button when they enter it



        singlePlayer.setOnAction((Action)->{
            AppManager.viewPane(AppManager.singlePlayerPane);
        });
        multiPlayer.setOnAction((Action)->{
            AppManager.viewPane(AppManager.multiPlayerPane);
        });
        setting.setOnAction((Action)->{
            AppManager.viewPane(AppManager.settingPane);
        });




        about.setOnAction((Action)->{

            alert.setTitle("About Tic Tac Toi");
            alert.setHeaderText("About Tic Tac Toi");
            alert.setContentText("\"Prepared by Tojan Naiem\\n\\n\"\n" +
                    "                    + \"If you have any comments, ideas.. just let me know\\n\\n\"\n" +
                    "                    + \"Email:   tojan.naiem@gmail.com\\n\"\n" +
                    "                    + \"Note\\n\"\n" +
                    "                    + \"I used JDK 1.8 to compile the source code.\\n\\n\"\n" +
                    "                    + \"© Copyright 2023 Tojan.com - All Rights Reserved\"");
            alert.show();



        });

        exit.setOnAction((Action)->{
            System.exit(0);

        });



    }


}
