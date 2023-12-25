package com.example.tictactoegame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.util.Random;

public class GamePane extends Pane {

    Label firstPlayerName=new Label();
    Label secondPlayerName=new Label();
    Label firstPlayerScore=new Label("0");
    Label secondPlayerScore=new Label("0");
    Label currentPlayerSymbol=new Label();
    Button back=new Button("Back");
    Button newGame=new Button("New Game");
    Button boardButton[]=new Button[9];
    GridPane gridPane=new GridPane();
    private boolean isGameEnd=false;
    private int counter=0;
    private boolean isFirstPlayerTurn=true;
    ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/images/board_4.png")));




    private void creatGameBoard()
    {
        int row=0,column=0;
        for(int i=0;i<boardButton.length;i++)
        {
            boardButton[i]=new Button();
            boardButton[i].setPrefSize(90,90);
            GridPane.setMargin(boardButton[i],new Insets(5));
            boardButton[i].setFont(Font.font("Arial", FontWeight.BOLD, 40));
            gridPane.add(boardButton[i],column,row);
            column++;
            if(column>=3){
                row++;
                column=0;
            }


        }

    }

    private void checkWinner()
    {
        //0 1 2
        //3 4 5
        //6 7 8
        for(int i=0;i<9;i+=3)
        {
            if(!(boardButton[i].getText().toString().equals(""))&&
                    !(boardButton[i+1].getText().toString().equals(""))&&
                    !(boardButton[i+2].getText().toString().equals(""))&&
                    (boardButton[i].getText().toString().equals(boardButton[i+1].getText().toString()))&&
                    (boardButton[i].getText().toString().equals(boardButton[i+2].getText().toString())))
            {
                isGameEnd=true;
                colorBackgroundWinnerButtons(boardButton[i],boardButton[i+1],boardButton[i+2]);
            }
        }
        for(int i=0;i<3;i++)
        {
            if (!(boardButton[i].getText().toString().equals(""))&&
                    !(boardButton[i+3].getText().toString().equals(""))&&
                    !(boardButton[i+6].getText().toString().equals(""))&&
            ((boardButton[i].getText().toString().equals(boardButton[i+3].getText().toString()))&&
                    (boardButton[i].getText().toString().equals(boardButton[i+6].getText().toString()))))
            {
                isGameEnd=true;
                colorBackgroundWinnerButtons(boardButton[i],boardButton[i+3],boardButton[i+6]);
            }
        }
        if
        (!(boardButton[0].getText().toString().equals(""))&&
                !(boardButton[4].getText().toString().equals(""))&&
                !(boardButton[8].getText().toString().equals(""))&&
                ((boardButton[0].getText().toString().equals(boardButton[4].getText().toString()))&&
                (boardButton[0].getText().toString().equals(boardButton[8].getText().toString()))))
        {
            isGameEnd=true;
            colorBackgroundWinnerButtons(boardButton[0],boardButton[4],boardButton[8]);
        }
        if(!(boardButton[2].getText().toString().equals(""))&&
                !(boardButton[4].getText().toString().equals(""))&&
                !(boardButton[6].getText().toString().equals(""))&&
                ((boardButton[2].getText().toString().equals(boardButton[4].getText().toString()))&&
                (boardButton[2].getText().toString().equals(boardButton[6].getText().toString()))))
        {
            isGameEnd=true;
            colorBackgroundWinnerButtons(boardButton[2],boardButton[4],boardButton[6]);
        }

        if(counter>=9)
        {
            isGameEnd=true;
            isFirstPlayerTurn=true;
            counter=0;
        }


        if(isGameEnd)
        {
            if(isFirstPlayerTurn)
            {
                if(!firstPlayerScore.getText().equals(""))
                firstPlayerScore.setText((Integer.parseInt(firstPlayerScore.getText())+1)+"");
                else firstPlayerScore.setText(1+"");
            }
            else
            {
                if(!secondPlayerScore.getText().equals(""))
                    secondPlayerScore.setText((Integer.parseInt(secondPlayerScore.getText())+1)+"");
                else secondPlayerScore.setText(1+"");

            }
            counter=0;
            newGame.requestFocus();
            gameEnd();

        }
    }
    private void colorBackgroundWinnerButtons(Button b1, Button b2, Button b3)
    {
        b1.setStyle("-fx-background-color: yellow;");
        b2.setStyle("-fx-background-color: yellow;");
        b3.setStyle("-fx-background-color: yellow;");
    }
    private void startNewGame()
    {
        for(Button boardButton:boardButton)
        {
            boardButton.addEventHandler(ActionEvent.ACTION,eventHandler);
        }
        isGameEnd=false;
        isFirstPlayerTurn=true;
        for (Button boardButton : boardButton) {
            boardButton.setText("");
            boardButton.setStyle("-fx-background-color: none; -fx-cursor: hand;");


        }
    }
    EventHandler<ActionEvent> eventHandler=(ActionEvent e)->{
        actionPerformed(e);

    };
    private void gameEnd()
    {
        for(Button boardButton:boardButton)
        {
            boardButton.removeEventHandler(ActionEvent.ACTION,eventHandler);
        }

    }


    private void actionPerformed(ActionEvent e)
    {
        Button clicked=(Button)e.getSource();
        if(clicked.getText().equals("")&&!isGameEnd)
        {
            if(!AppManager.challengeComputer)
            {
                if(isFirstPlayerTurn)
                {
                    clicked.setTextFill(Color.RED);
                    clicked.setText("X");
                }
                else
                {
                    clicked.setTextFill(Color.BLUE);
                    clicked.setText("○");

                }
                checkWinner();
                isFirstPlayerTurn=!isFirstPlayerTurn;
                counter++;

            }
            else if(AppManager.challengeComputer)
            {

                if(isFirstPlayerTurn)
                {
                    clicked.setTextFill(Color.RED);
                    clicked.setText("X");
                    counter++;
                    checkWinner();
                    isFirstPlayerTurn=false;
                    if(isGameEnd==false)
                    computerMove();
                }

            }
        }
    }
    private void computerMove()
    {
        for(Button boardButton:boardButton)
    {
        boardButton.removeEventHandler(ActionEvent.ACTION,eventHandler);

    }
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(0.5),event->{


            Random random=new Random();
            int randomNumber;
            for(int i=0;i<9;i++)
            {
                randomNumber=random.nextInt(9);
                if(boardButton[randomNumber].getText().isEmpty())
                {
                    boardButton[randomNumber].setTextFill(Color.BLUE);
                    boardButton[randomNumber].setText("○");
                    counter++;
                    break;
                }
            }

            for(Button boardButton:boardButton)
            {
                boardButton.addEventHandler(ActionEvent.ACTION,eventHandler);
            }
            checkWinner();
            isFirstPlayerTurn=true;

        }));
        timeline.play();




    }



    public GamePane()
    {
        //first player
        firstPlayerName.setLayoutX(50);
        firstPlayerName.setLayoutY(10);
        firstPlayerName.setPrefSize(150,30);
        firstPlayerName.setFont(new Font("times new roman", 17));

        //second player
        secondPlayerName.setLayoutX(250);
        secondPlayerName.setLayoutY(10);
        secondPlayerName.setPrefSize(150,30);
        secondPlayerName.setFont(new Font("times new roman", 17));

        //first player score
        firstPlayerScore.setLayoutX(70);
        firstPlayerScore.setLayoutY(40);
        firstPlayerScore.setPrefSize(150,30);

        //second player score
        secondPlayerScore.setLayoutX(270);
        secondPlayerScore.setLayoutY(40);
        secondPlayerScore.setPrefSize(150,30);

        //current player symbol
        currentPlayerSymbol.setLayoutX(120);
        currentPlayerSymbol.setLayoutY(50);
        currentPlayerSymbol.setPrefSize(150,30);

        //grid pane
        gridPane.setLayoutX(45);
        gridPane.setLayoutY(105);
        gridPane.setPrefSize(300,300);

        //back button
        back.setLayoutX(20);
        back.setLayoutY(455);
        back.setPrefSize(140,30);
        back.setStyle("-fx-background-color: red;");
        back.setFont(new Font("times new roman", 17));

        //new Game button
        newGame.setLayoutX(230);
        newGame.setLayoutY(455);
        newGame.setPrefSize(140,30);
        newGame.setStyle("-fx-background-color: red;");
        newGame.setFont(new Font("times new roman", 15));

        //background
        background.setLayoutX(45);
        background.setLayoutY(105);
        background.setFitWidth(300);
        background.setFitHeight(300);


        creatGameBoard();
        for (Button button : boardButton) {
            button.setOnAction(eventHandler);
        }

//        firstPlayerName.setAlignment(Pos.CENTER);
//        secondPlayerName.setAlignment(Pos.CENTER);
//        firstPlayerScore.setAlignment(Pos.CENTER);
//        secondPlayerScore.setAlignment(Pos.CENTER);


        getChildren().addAll(firstPlayerName,firstPlayerScore,secondPlayerName,secondPlayerScore,currentPlayerSymbol
        ,gridPane,back,newGame,background);

        newGame.setOnAction((Action)->{
            startNewGame();

                });

        back.setOnAction((Action)->{
            secondPlayerScore.setText("0");
            firstPlayerScore.setText("0");
            startNewGame();

            if(AppManager.challengeComputer) AppManager.viewPane(AppManager.singlePlayerPane);
            else AppManager.viewPane(AppManager.multiPlayerPane);

                });





    }




}
