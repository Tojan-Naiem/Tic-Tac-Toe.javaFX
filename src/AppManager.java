package com.example.tictactoegame;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class AppManager {

    static StartPane startPane=new StartPane();
    static SinglePlayerPane singlePlayerPane=new SinglePlayerPane();
    static  MultiPlayerPane multiPlayerPane=new MultiPlayerPane();
    static SettingPane settingPane=new SettingPane();
    static GamePane gamePane=new GamePane();
    static int preferredBoard=1;
    static Font preferredFont;

    static boolean challengeComputer=false;


    public static void viewPane(Pane pane)
    {
        startPane.setVisible(false);
        multiPlayerPane.setVisible(false);
        singlePlayerPane.setVisible(false);
        settingPane.setVisible(false);
        gamePane.setVisible(false);
        pane.setVisible(true);


    }
    //in the setting page we change everything that suit
    public static void setDefaultSittings()
    {
        settingPane.fontSizeComboBox.getSelectionModel().select(1);
        setFont();

    }

    public static void setFont()
    {
        //start pane

        startPane.singlePlayer.setFont(preferredFont);
        startPane.multiPlayer.setFont(preferredFont);
        startPane.setting.setFont(preferredFont);
        startPane.about.setFont(preferredFont);
        startPane.exit.setFont(preferredFont);

        singlePlayerPane.name.setFont(preferredFont);
        singlePlayerPane.start.setFont(preferredFont);
        singlePlayerPane.back.setFont(preferredFont);
        singlePlayerPane.textForName.setFont(preferredFont);

        multiPlayerPane.namePlayerX.setFont(preferredFont);
        multiPlayerPane.back.setFont(preferredFont);
        multiPlayerPane.namePlayerO.setFont(preferredFont);
        multiPlayerPane.txtNamePlayerX.setFont(preferredFont);
        multiPlayerPane.txtNamePlayerO.setFont(preferredFont);
        multiPlayerPane.start.setFont(preferredFont);


        settingPane.fontSize.setFont(preferredFont);
        settingPane.resetDefaultSetting.setFont(preferredFont);
        settingPane.back.setFont(preferredFont);

        settingPane.fontSizeComboBox.setStyle(
                "-fx-font-family:" + preferredFont.getName() + ";"
                        +"-fx-font-size: " + preferredFont.getSize() +"px;"
                        +"-fx-font-weight: bold;"
        );







    }




}
