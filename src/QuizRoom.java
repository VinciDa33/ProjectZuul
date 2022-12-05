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
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public abstract class QuizRoom extends Room{
    String question;
    boolean skipOnAnswer;
    boolean questionCorrect;
    boolean questionAnswered;
    ArrayList<String> answers = new ArrayList<>();
    ArrayList<String> responses = new ArrayList<>();

    //GUI RELATED VARIABLES
    Label responseLabel;

    HBox answerBox;
    VBox answerLabelBox;
    HBox activeBottomBox;

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
        swipeInAnim.setDuration(Duration.millis(800));
        swipeInAnim.setByY(-GUIManager.getSizeY());
        swipeInAnim.setNode(swipeRect);
        swipeInAnim.play();

        swipeOutAnim = new TranslateTransition();
        swipeOutAnim.setDuration(Duration.millis(800));
        swipeOutAnim.setFromY(GUIManager.getSizeY());
        swipeOutAnim.setByY(-GUIManager.getSizeY());
        swipeOutAnim.setNode(swipeRect);

        HBox topBox = new HBox();
        topBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));
        topBox.setPrefHeight(GUIManager.getSizeY()/4f*3);


        answerLabelBox = new VBox();
        answerLabelBox.setBackground(new Background(new BackgroundFill(Color.rgb(185, 170, 125), CornerRadii.EMPTY, Insets.EMPTY)));
        answerLabelBox.setPrefWidth(GUIManager.getSizeX()/2f);
        answerLabelBox.setAlignment(Pos.TOP_LEFT);
        answerLabelBox.setSpacing(15);
        answerLabelBox.setPadding(new Insets(50, 0, 0, 50));


        //Answer panel
        answerBox = new HBox();
        answerBox.setBackground(new Background(new BackgroundFill(Color.rgb(40, 40, 40, 0), CornerRadii.EMPTY, Insets.EMPTY)));
        answerBox.setPrefHeight(GUIManager.getSizeY()/4f);
        answerBox.setPrefWidth(GUIManager.getSizeX());
        answerBox.setLayoutY(GUIManager.getSizeY() * 0.75f);
        answerBox.setAlignment(Pos.CENTER);
        answerBox.setSpacing(10);

        Image image = new Image("Img/QuestionAnswerBackground.png", GUIManager.getSizeX(), Math.round(GUIManager.getSizeY()/4f), false, false);
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bg = new Background(bgImage);
        answerBox.setBackground(bg);

        //Creates a label and a button for each answer option in the room
        for (int i = 0; i < answers.size(); i++) {
            VBox labelContainer = new VBox();
            labelContainer.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30, 0.75f), new CornerRadii(10), Insets.EMPTY)));
            labelContainer.setMaxWidth(GUIManager.getSizeX() / 2f * 0.8f);
            labelContainer.setAlignment(Pos.TOP_LEFT);
            labelContainer.setPadding(new Insets(30, 50, 30, 50));

            Label answerLabel = new Label("[" + (i+1) + "] " + answers.get(i));
            answerLabel.setTextFill(Color.rgb(220, 220, 220));
            answerLabel.setFont(Font.font("Verdana", 18));
            answerLabel.setTextAlignment(TextAlignment.LEFT);
            answerLabel.setWrapText(true);
            labelContainer.getChildren().add(answerLabel);

            TranslateTransition offset = new TranslateTransition();
            offset.setDuration(Duration.millis(1));
            offset.setFromX(0);
            offset.setToX(1000);
            offset.setNode(labelContainer);
            offset.play();

            TranslateTransition labelAnim = new TranslateTransition();
            labelAnim.setDuration(Duration.seconds(1));
            labelAnim.setFromX(1000);
            labelAnim.setToX(0);
            labelAnim.setNode(labelContainer);
            Timeline delay = new Timeline(new KeyFrame(Duration.seconds(0.3 * (i+1)), e -> labelAnim.play()));
            delay.play();
            answerLabelBox.getChildren().add(labelContainer);

            int index = i;
            CustomButton button = new CustomButton("Answer [" + (i+1) + "]");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answerQuestion(index);

                    //Sound handling
                    Random r = new Random();
                    AudioClip clickSound = new AudioClip(this.getClass().getResource("Audio/" + CustomButton.defaultClickSounds[r.nextInt(CustomButton.defaultClickSounds.length)]).toString());
                    clickSound.play();
                }
            });
            button.setPrefSize(160, 80);
            button.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            button.setTextFill(Color.rgb(220, 215, 180));
            button.setDefaultBackground("Img/ButtonImageSmall.png");
            button.setOnHoverBackground("Img/ButtonImageHoverSmall.png");
            answerBox.getChildren().add(button);
        }

        //The quit game button
        CustomButton exitButton = new CustomButton("Quit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GUIManager.quitGame();
            }
        });
        exitButton.setPrefSize(160, 80);
        exitButton.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        exitButton.setDefaultBackground("Img/ButtonImageSmall.png");
        exitButton.setOnHoverBackground("Img/ButtonImageHoverSmall.png");
        answerBox.getChildren().add(exitButton);


        VBox leftBox = new VBox();
        leftBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), CornerRadii.EMPTY, Insets.EMPTY)));
        leftBox.setPrefWidth(GUIManager.getSizeX()/2f);
        leftBox.setAlignment(Pos.TOP_CENTER);
        leftBox.setPadding(new Insets(0, 50, 0, 50));

        if (imageString != null) {
            Image backImg = new Image(imageString, 640, 540, false, false);
            BackgroundImage bImg = new BackgroundImage(backImg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background bGround = new Background(bImg);
            leftBox.setBackground(bGround);
        }

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
        topBox.getChildren().add(answerLabelBox);

        activeBottomBox = answerBox;

        root.getChildren().add(topBox);
        root.getChildren().add(activeBottomBox);
        root.getChildren().add(swipeRect);

        return new Scene(root, GUIManager.getSizeX(), GUIManager.getSizeY());
    }

    public void updateAnswerBox() {
        if (questionCorrect || (questionAnswered && skipOnAnswer)) {
            answerBox.getChildren().clear();

            //Creates a button for each exit option in the room
            for (String key : exits.keySet()) {
                CustomButton button = new CustomButton(key);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        swipeOutAnim.play();
                        swipeOutAnim.setOnFinished(e -> GameManager.getInstance().goToRoom(exits.get(key)));

                        //Sound handling
                        Random r = new Random();
                        AudioClip clickSound = new AudioClip(this.getClass().getResource("Audio/" + CustomButton.defaultClickSounds[r.nextInt(CustomButton.defaultClickSounds.length)]).toString());
                        clickSound.play();
                    }
                });
                button.setPrefSize(160, 80);
                button.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
                button.setTextFill(Color.rgb(220, 215, 180));
                button.setDefaultBackground("Img/ButtonImageSmall.png");
                button.setOnHoverBackground("Img/ButtonImageHoverSmall.png");
                answerBox.getChildren().add(button);
            }

            //The quit game button
            CustomButton exitButton = new CustomButton("Quit");
            exitButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    GUIManager.quitGame();
                }
            });
            exitButton.setPrefSize(160, 80);
            exitButton.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
            exitButton.setDefaultBackground("Img/ButtonImageSmall.png");
            exitButton.setOnHoverBackground("Img/ButtonImageHoverSmall.png");
            answerBox.getChildren().add(exitButton);
        }
    }
}