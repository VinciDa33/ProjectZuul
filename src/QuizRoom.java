import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.util.ArrayList;

public abstract class QuizRoom extends Room{
    String question;
    boolean skipOnAnswer;
    boolean questionCorrect;
    boolean questionAnswered;
    ArrayList<String> answers = new ArrayList<>();
    ArrayList<String> responses = new ArrayList<>();

    //GUI RELATED VARIABLES
    Label responseLabel;
    VBox answerLabelBox;
    HBox answerBox;

    //GUI ANIMATION
    TranslateTransition swipeOutAnim;

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
    public Scene createGUI() {
        //Setting up the main boxes for holding components
        Group root = new Group();

        //Animation stuff
        Rectangle swipeRect = new Rectangle(0, 0, GUIManager.getSizeX(), GUIManager.getSizeY());
        swipeRect.setFill(Color.rgb(20, 20, 20));

        TranslateTransition swipeInAnim = new TranslateTransition();
        swipeInAnim.setDuration(Duration.millis(1000));
        swipeInAnim.setByY(-GUIManager.getSizeY());
        swipeInAnim.setNode(swipeRect);
        swipeInAnim.play();

        swipeOutAnim = new TranslateTransition();
        swipeOutAnim.setDuration(Duration.millis(1000));
        swipeOutAnim.setFromY(GUIManager.getSizeY());
        swipeOutAnim.setByY(-GUIManager.getSizeY());
        swipeOutAnim.setNode(swipeRect);

        HBox topBox = new HBox();
        topBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));
        topBox.setPrefHeight(GUIManager.getSizeY()/4f*3);

        HBox bottomBox = new HBox();
        bottomBox.setBackground(new Background(new BackgroundFill(Color.rgb(40, 40, 40), CornerRadii.EMPTY, Insets.EMPTY)));
        bottomBox.setPrefHeight(GUIManager.getSizeY()/4f);
        bottomBox.setPrefWidth(GUIManager.getSizeX());
        bottomBox.setLayoutY(GUIManager.getSizeY() * 0.75f);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setSpacing(10);

        VBox leftBox = new VBox();
        leftBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), CornerRadii.EMPTY, Insets.EMPTY)));
        leftBox.setPrefWidth(GUIManager.getSizeX()/2f);
        leftBox.setAlignment(Pos.TOP_CENTER);

        if (imageString != null) {
            Image backImg = new Image(imageString, 640, 540, false, false);
            BackgroundImage bImg = new BackgroundImage(backImg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background bGround = new Background(bImg);
            leftBox.setBackground(bGround);
        }

        VBox rightBox = new VBox();
        rightBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), CornerRadii.EMPTY, Insets.EMPTY)));
        rightBox.setPrefWidth(GUIManager.getSizeX()/2f);
        rightBox.setAlignment(Pos.TOP_CENTER);
        rightBox.setSpacing(15);
        rightBox.setPadding(new Insets(50, 0, 0, 0));

        answerBox = bottomBox;
        answerLabelBox = rightBox;

        //The label with the description
        Label questionLabel = new Label("--- Question ---\n\n" + question);
        questionLabel.setTextFill(Color.rgb(220, 220, 220));
        questionLabel.setPadding(new Insets(50, 0, 0, 0));
        questionLabel.setFont(Font.font("Verdana", 28));
        questionLabel.setTextAlignment(TextAlignment.CENTER);
        questionLabel.setWrapText(true);
        leftBox.getChildren().add(questionLabel);

        responseLabel = new Label();
        responseLabel.setTextFill(Color.rgb(220, 220, 220));
        responseLabel.setPadding(new Insets(50, 0, 0, 0));
        responseLabel.setFont(Font.font("Verdana", 22));
        responseLabel.setTextAlignment(TextAlignment.CENTER);
        responseLabel.setWrapText(true);
        leftBox.getChildren().add(responseLabel);

        //Creates a label and a button for each answer option in the room
        updateAnswerBox();


        //Adding components to main component and returning scene
        topBox.getChildren().add(leftBox);
        topBox.getChildren().add(rightBox);

        root.getChildren().add(topBox);
        root.getChildren().add(bottomBox);
        root.getChildren().add(swipeRect);

        return new Scene(root, GUIManager.getSizeX(), GUIManager.getSizeY());
    }

    public void updateAnswerBox() {
        answerBox.getChildren().clear();
        answerLabelBox.getChildren().clear();

        if (questionCorrect || (questionAnswered && skipOnAnswer)) {
            //Creates a button for each exit option in the room
            for (String key : exits.keySet()) {
                Button button = new Button(key);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        swipeOutAnim.play();
                        Timeline exitTimer = new Timeline(
                                new KeyFrame(swipeOutAnim.getDuration(), event -> GameManager.getInstance().goToRoom(exits.get(key)))
                        );
                        exitTimer.play();
                    }
                });
                button.setPrefSize(160, 80);
                button.setFont(Font.font("Verdana", 18));
                answerBox.getChildren().add(button);
            }
        }
        else {
            //Creates a label and a button for each answer option in the room
            for (int i = 0; i < answers.size(); i++) {
                Label answerLabel = new Label("[" + (i+1) + "] " + answers.get(i));
                answerLabel.setTextFill(Color.rgb(220, 220, 220));
                answerLabel.setFont(Font.font("Verdana", 18));
                answerLabel.setTextAlignment(TextAlignment.CENTER);
                answerLabel.setWrapText(true);
                answerLabelBox.getChildren().add(answerLabel);

                int index = i;
                Button button = new Button("Answer #" + (i+1));
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        answerQuestion(index);
                    }
                });
                button.setPrefSize(160, 80);
                button.setFont(Font.font("Verdana", 18));
                answerBox.getChildren().add(button);
            }
        }

        //The quit game button
        Button exitButton = new Button("Quit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GUIManager.quitGame();
            }
        });
        exitButton.setPrefSize(160, 80);
        exitButton.setFont(Font.font("Verdana", 24));
        answerBox.getChildren().add(exitButton);
    }
}