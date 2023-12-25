package com.example.tictactoegame;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MultiPlayerPane extends Pane{

    Label namePlayerX=new Label("Player X");
    Label namePlayerO=new Label("Player ○");
    TextField txtNamePlayerX=new TextField();
    TextField txtNamePlayerO=new TextField();
    Button start=new Button("Start");
    Button back=new Button("Back");

    public MultiPlayerPane()
    {
        // player 1
        namePlayerX.setLayoutX(80);
        namePlayerX.setLayoutY(130);
        namePlayerX.setPrefSize(70,30);

        //txt name player x
        txtNamePlayerX.setLayoutX(160);
        txtNamePlayerX.setLayoutY(130);
        txtNamePlayerX.setPrefSize(160,30);

        // player 2
        namePlayerO.setLayoutX(80);
        namePlayerO.setLayoutY(190);
        namePlayerO.setPrefSize(70,30);

        // txt name player o
        txtNamePlayerO.setLayoutX(160);
        txtNamePlayerO.setLayoutY(190);
        txtNamePlayerO.setPrefSize(160,30);
        //start button
        start.setLayoutX(80);
        start.setLayoutY(250);
        start.setPrefSize(240,40);
        start.setStyle("-fx-background-color: red;");
        //back button
        back.setLayoutX(80);
        back.setLayoutY(310);
        back.setPrefSize(240,40);
        back.setStyle("-fx-background-color: red;");

        getChildren().addAll(namePlayerX,namePlayerO,txtNamePlayerX,txtNamePlayerO,start,back);



        back.setOnAction((Action)->{
            AppManager.viewPane(AppManager.startPane);
        });

        start.setOnAction((Action)->{
            AppManager.gamePane.firstPlayerName.setText(txtNamePlayerX.getText());
            AppManager.gamePane.secondPlayerName.setText(txtNamePlayerO.getText());
            AppManager.challengeComputer=false;
            AppManager.viewPane(AppManager.gamePane);
        });




    }




}
