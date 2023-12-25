package com.example.tictactoegame;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class SinglePlayerPane extends Pane {

    Label name=new Label("Player Name");
    Button start =new Button("Start");
    Button back=new Button("Back");
    TextField textForName=new TextField();



    public SinglePlayerPane()
    {
        //player name
        name.setLayoutX(80);
        name.setLayoutY(170);
        name.setPrefSize(100,30);
        name.setFont(new Font("times new roman", 17));

        //text for name
        textForName.setLayoutX(190);
        textForName.setLayoutY(170);
        textForName.setPrefSize(130,30);


        //start Button
        start.setLayoutX(80);
        start.setLayoutY(220);
        start.setPrefSize(240,40);
        start.setStyle("-fx-background-color: red;");
        start.setFont(new Font("times new roman", 17));
        //back Button
        back.setLayoutX(80);
        back.setLayoutY(270);
        back.setPrefSize(240,40);
        back.setStyle("-fx-background-color: red;");
        back.setFont(new Font("times new roman", 17));

        getChildren().addAll(name,textForName,start,back);



        back.setOnAction((Action)->{
            AppManager.viewPane(AppManager.startPane);
        });
        start.setOnAction((Action)->{
            AppManager.gamePane.firstPlayerName.setText(textForName.getText());
            AppManager.gamePane.secondPlayerName.setText("Computer");
            AppManager.challengeComputer=true;

            AppManager.viewPane(AppManager.gamePane);
        });



    }
}
