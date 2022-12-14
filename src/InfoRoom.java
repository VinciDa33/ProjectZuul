import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
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

import java.util.Random;

public class InfoRoom extends Room{
    String description;
    private boolean isLanguageToggleRoom = false;
    private boolean isPointScoreRoom = false;

    public InfoRoom(String roomDataPath) {
        super(roomDataPath);
    }

    @Override
    public void onEnterRoom(){
        if (!isPointScoreRoom)
            description = FileReader.loadFile(roomDataPath);
        GUIManager.setScene(createGUI());

        if (PointScore.getPoints() >= 400) {
            AudioClip correctSound = new AudioClip(GameManager.getInstance().getClass().getResource("Audio/SuperSuccess.wav").toString());
            correctSound.play();
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Scene createGUI() {
        //Setting up the main boxes for holding components
        Group root = new Group();

        //Fade in and out animations for the scene
        Rectangle fadeRect = new Rectangle(0, 0, GUIManager.getSizeX(), GUIManager.getSizeY());
        fadeRect.setFill(Color.rgb(20, 20, 20));
        fadeRect.setDisable(true);

        FillTransition fadeInAnim = new FillTransition();
        fadeInAnim.setDuration(Duration.millis(800));
        fadeInAnim.setToValue(Color.rgb(20, 20, 20, 0));
        fadeInAnim.setShape(fadeRect);
        fadeInAnim.play();

        FillTransition fadeOutAnim = new FillTransition();
        fadeOutAnim.setDuration(Duration.millis(800));
        fadeOutAnim.setToValue(Color.rgb(20, 20, 20, 1));
        fadeOutAnim.setShape(fadeRect);

        //Box for containing the description of the room, as well as displaying a background image
        VBox leftBox = new VBox();
        leftBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));
        leftBox.setPrefSize(GUIManager.getSizeX()/4f*3, GUIManager.getSizeY());
        leftBox.setAlignment(Pos.TOP_LEFT);
        leftBox.setPadding(new Insets(50, 0, 0, 50));
        leftBox.setSpacing(20);

        if (imageString != null) {
            Image backImg = new Image(imageString, 960, 720, false, false);
            BackgroundImage bImg = new BackgroundImage(backImg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background bGround = new Background(bImg);
            leftBox.setBackground(bGround);
        }


        //Inner left box for containing info room descriptions
        VBox innerLeftBox = new VBox();
        innerLeftBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30, 0.75f), new CornerRadii(10), Insets.EMPTY)));
        innerLeftBox.setMaxWidth(GUIManager.getSizeX()/3f);
        if (description.length() > 250)
            innerLeftBox.setMaxWidth(GUIManager.getSizeX()/2f);
        innerLeftBox.setMaxHeight(GUIManager.getSizeY() * 0.85f);
        innerLeftBox.setAlignment(Pos.TOP_LEFT);
        innerLeftBox.setPadding(new Insets(50, 50, 50, 50));
        leftBox.getChildren().add(innerLeftBox);

        if (isLanguageToggleRoom) {
            CustomButton toggleButton = new CustomButton(FileReader.loadFile("ToggleButtonText"));
            toggleButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    description = null;
                    FileReader.toggleLanguage();
                }
            });
            toggleButton.setPrefSize(160, 80);
            toggleButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
            toggleButton.setTextFill(Color.rgb(220, 215, 180));
            toggleButton.setDefaultBackground("Img/ButtonImageSmall.png");
            toggleButton.setOnHoverBackground("Img/ButtonImageHoverSmall.png");
            leftBox.getChildren().add(toggleButton);
        }

        //Two animations for the slide in effect of the inner left box
        TranslateTransition textSlideInAnim = new TranslateTransition();
        textSlideInAnim.setDuration(Duration.seconds(1f));
        textSlideInAnim.setFromX(-1200);
        textSlideInAnim.setToX(50);
        textSlideInAnim.setNode(innerLeftBox);
        textSlideInAnim.play();

        TranslateTransition textSlideBounce = new TranslateTransition();
        textSlideBounce.setDuration(Duration.seconds(0.2f));
        textSlideBounce.setFromX(50);
        textSlideBounce.setToX(0);
        textSlideBounce.setNode(innerLeftBox);

        textSlideInAnim.setOnFinished(e -> textSlideBounce.play());

        //The label with the description, added to the inner left box
        Label descriptionLabel = new Label(description);
        descriptionLabel.setTextFill(Color.rgb(220, 220, 220));
        descriptionLabel.setWrapText(true);
        descriptionLabel.setFont(Font.font("Verdana", 24));
        if (description.length() > 700)
            descriptionLabel.setFont(Font.font("Verdana", 16));
        else if (description.length() > 500)
            descriptionLabel.setFont(Font.font("Verdana", 18));
        descriptionLabel.setTextAlignment(TextAlignment.LEFT);

        innerLeftBox.getChildren().add(descriptionLabel);

        //Right box containing the buttons for going to other rooms
        VBox rightBox = new VBox();
        rightBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), CornerRadii.EMPTY, Insets.EMPTY)));
        rightBox.setPrefSize(GUIManager.getSizeX()/4f, GUIManager.getSizeY());
        rightBox.setLayoutX(GUIManager.getSizeX()/4f*3);
        rightBox.setAlignment(Pos.CENTER);

        Image image = new Image("Img/NavigationBackground2.png", GUIManager.getSizeX()/4f, GUIManager.getSizeY(), false, false);
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bg = new Background(bgImage);
        rightBox.setBackground(bg);

        //Inner right box for correctly containing the buttons
        VBox innerRightBox = new VBox();
        innerRightBox.setPrefHeight(GUIManager.getSizeY() * 0.8f);
        innerRightBox.setAlignment(Pos.CENTER);
        innerRightBox.setSpacing(10);
        innerRightBox.setPadding(new Insets(0 ,0, 0, 20));
        rightBox.getChildren().add(innerRightBox);

        //Creates a button for each exit option in the room
        for (String key : exits.keySet()) {
            CustomButton button = new CustomButton(FileReader.loadFile(key));
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    fadeOutAnim.play();
                    fadeOutAnim.setOnFinished(e -> GameManager.getInstance().goToRoom(exits.get(key)));

                    //Sound handling
                    Random r = new Random();
                    AudioClip clickSound = new AudioClip(this.getClass().getResource("Audio/" + CustomButton.defaultClickSounds[r.nextInt(CustomButton.defaultClickSounds.length)]).toString());
                    clickSound.play();

                    //GameManager.getInstance().goToRoom(exits.get(key));
                }
            });
            button.setFont(Font.font("Verdana", FontWeight.BOLD, 26));
            button.setTextFill(Color.rgb(220, 215, 180));
            innerRightBox.getChildren().add(button);
        }

        //The quit game button
        CustomButton exitButton = new CustomButton(FileReader.loadFile("Navigation/QuitButton"));
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GUIManager.quitGame();
            }
        });
        exitButton.setFont(Font.font("Verdana", FontWeight.BOLD, 26));
        innerRightBox.getChildren().add(exitButton);


        //Adding components to main component and returning scene
        root.getChildren().add(leftBox);
        root.getChildren().add(rightBox);

        //fadeRect must be added last, to be shown on top of all other elements
        root.getChildren().add(fadeRect);

        return new Scene(root, GUIManager.getSizeX(), GUIManager.getSizeY());
    }

    public void setLanguageToggleRoom(boolean b) {
        isLanguageToggleRoom = b;
    }
    public void setPointScoreRoom(boolean b) {
        isPointScoreRoom = b;
    }
}
