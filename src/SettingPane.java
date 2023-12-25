package com.example.tictactoegame;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SettingPane extends Pane {


    Label fontSize=new Label("Font Size");
    Button resetDefaultSetting=new Button("Reset Default Setting");
    Button back =new Button("Back");

    ComboBox fontSizeComboBox=new ComboBox();


    public SettingPane()
    {
    //    boardComboBox.getItems().addAll("Board 1", "Board 2", "Board 3", "Board 4");
        fontSizeComboBox.getItems().addAll("Small","Medium","Large");



        //font size
        fontSize.setLayoutX(80);
        fontSize.setLayoutY(190);
        fontSize.setPrefSize(100,30);
        //font size combobox
        fontSizeComboBox.setLayoutX(200);
        fontSizeComboBox.setLayoutY(190);
        fontSizeComboBox.setPrefSize(120,30);
        //reset
        resetDefaultSetting.setLayoutX(80);
        resetDefaultSetting.setLayoutY(250);
        resetDefaultSetting.setPrefSize(240,40);
        //back
        back.setLayoutX(80);
        back.setLayoutY(310);
        back.setPrefSize(240,40);

        getChildren().addAll(fontSize,fontSizeComboBox,resetDefaultSetting,back);


        fontSizeComboBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {

            String selectedFone=fontSizeComboBox.getSelectionModel().getSelectedItem().toString();
            int fontSize=0;
            switch(selectedFone)
            {
                case "Small":
                    fontSize=15;
                    break;
                case "Medium":
                    fontSize=16;
                    break;
                case "Large":
                    fontSize=17;
                    break;



            }
            AppManager.preferredFont= Font.font("Arial", FontWeight.BOLD, fontSize);
            AppManager.setFont();
        });

        resetDefaultSetting.setOnAction((Action)->{
            AppManager.setDefaultSittings();

                    fontSizeComboBox.getSelectionModel().select(1);
                }
                );

        back.setOnAction((Action)->{
            AppManager.viewPane(AppManager.startPane);
        });









    }
}
