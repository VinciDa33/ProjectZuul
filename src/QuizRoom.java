import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class QuizRoom extends Room{
    String question;
    boolean skipOnAnswer;
    boolean questionCorrect;
    boolean questionAnswered;
    ArrayList<String> answers = new ArrayList<>();
    ArrayList<String> responses = new ArrayList<>();
    Label responseLabel;
    VBox answerBox;


    public void setSkipOnAnswer(boolean skipOnAnswer){
        this.skipOnAnswer = skipOnAnswer;
    }
    public abstract void answerQuestion(int answer);

    @Override
    public void onEnterRoom() {
        questionCorrect = false;
        questionAnswered = false;
        GUIManager.setScene(createGUI());
    }
    @Override
    public Scene createGUI(){
        HBox hBox = new HBox();
        hBox.setBackground(new Background(new BackgroundFill(Color.rgb(100,50,30), CornerRadii.EMPTY, Insets.EMPTY)));

        VBox leftBox = new VBox();
        VBox rightBox = new VBox();
        leftBox.setBackground(new Background(new BackgroundFill(Color.rgb(10,100,50), CornerRadii.EMPTY, Insets.EMPTY)));
        rightBox.setBackground(new Background(new BackgroundFill(Color.rgb(50,60,120), CornerRadii.EMPTY, Insets.EMPTY)));

        Label questionLabel = new Label("------Question-----\n\n"+question);
        questionLabel.setTextFill(Color.rgb(10,10,10));
        leftBox.getChildren().add(questionLabel);

        responseLabel = new Label();
        responseLabel.setTextFill(Color.rgb(10,10,10));
        
        leftBox.getChildren().add(responseLabel);

        for (int i = 0; i < answers.size(); i++){
            Label answerLabel = new Label(answers.get(i));
            rightBox.getChildren().add(answerLabel);

            int index = i;
            Button button = new Button("Answer nr. "+i+1);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answerQuestion(index);
                }
            });
            rightBox.getChildren().add(button);
        }
        Button quitButton = new Button("Quit");
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GUIManager.quitGame();
            }
        });
        rightBox.getChildren().add(quitButton);
        hBox.getChildren().addAll(leftBox,rightBox);
        answerBox = rightBox;
        return new Scene(hBox, GUIManager.getSizeX(), GUIManager.getSizeY());
    }
    public void updateAnswerBox(){
        answerBox.getChildren().clear();
        if (questionCorrect || (questionAnswered && skipOnAnswer)){
            for (String key : exits.keySet()){
                Button button = new Button(key);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        GameManager.getInstance().goToRoom(exits.get(key));
                    }
                });
                answerBox.getChildren().add(button);
            }
        }
        else {
            for (int i = 0; i < answers.size(); i++){
                Label answerLabel = new Label(answers.get(i));
                answerBox.getChildren().add(answerLabel);

                int index = i;
                Button button = new Button("Answer nr. "+i);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        answerQuestion(index);
                    }
                });
            }
            Button quitButton = new Button("Quit");
            quitButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    GUIManager.quitGame();
                }
            });
            answerBox.getChildren().add(quitButton);
        }
    }
}