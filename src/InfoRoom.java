import javafx.animation.FillTransition;
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
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.util.Random;

public class InfoRoom extends Room{
    String description;

    public InfoRoom(String description) {
        this.description = description;
    }

    @Override
    public void onEnterRoom(){
        GUIManager.setScene(createGUI());
    }

    @Override
    public Scene createGUI() {
        //Setting up the main boxes for holding components
        Group root = new Group();

        //Animation stuff
        Rectangle fadeRect = new Rectangle(0, 0, GUIManager.getSizeX(), GUIManager.getSizeY());
        fadeRect.setFill(Color.rgb(20, 20, 20));

        FillTransition fadeInAnim = new FillTransition();
        fadeInAnim.setDuration(Duration.millis(1000));
        fadeInAnim.setToValue(Color.rgb(20, 20, 20, 0));
        fadeInAnim.setShape(fadeRect);
        fadeInAnim.setOnFinished(e -> fadeRect.setDisable(true));
        fadeInAnim.play();

        FillTransition fadeOutAnim = new FillTransition();
        fadeOutAnim.setDuration(Duration.millis(1000));
        fadeOutAnim.setToValue(Color.rgb(20, 20, 20, 1));
        fadeOutAnim.setShape(fadeRect);

        VBox leftBox = new VBox();
        leftBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));
        leftBox.setPrefSize(GUIManager.getSizeX()/4f*3, GUIManager.getSizeY());
        leftBox.setLayoutX(0);
        leftBox.setAlignment(Pos.TOP_CENTER);

        if (imageString != null) {
            Image backImg = new Image(imageString, 960, 720, false, false);
            BackgroundImage bImg = new BackgroundImage(backImg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background bGround = new Background(bImg);
            leftBox.setBackground(bGround);
        }

        VBox rightBox = new VBox();
        rightBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), CornerRadii.EMPTY, Insets.EMPTY)));
        rightBox.setPrefSize(GUIManager.getSizeX()/4f, GUIManager.getSizeY());
        rightBox.setLayoutX(GUIManager.getSizeX()/4f*3);
        rightBox.setAlignment(Pos.CENTER);
        rightBox.setSpacing(10);

        //The label with the description
        Label descriptionLabel = new Label(description);
        descriptionLabel.setTextFill(Color.rgb(220, 220, 220));
        descriptionLabel.setWrapText(true);
        descriptionLabel.setPadding(new Insets(50, 0, 0, 0));
        descriptionLabel.setFont(Font.font("Verdana", 20));
        descriptionLabel.setTextAlignment(TextAlignment.CENTER);
        descriptionLabel.setPadding(new Insets(50, 100, 0, 100));

        leftBox.getChildren().add(descriptionLabel);

        //Creates a button for each exit option in the room
        for (String key : exits.keySet()) {
            Button button = new Button(key);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    fadeOutAnim.play();
                    fadeOutAnim.setOnFinished(e -> GameManager.getInstance().goToRoom(exits.get(key)));

                    //Sound handling
                    Random r = new Random();
                    AudioClip clickSound = new AudioClip(this.getClass().getResource("Audio/" + defaultClickSounds[r.nextInt(defaultClickSounds.length)]).toString());
                    clickSound.play();

                    //GameManager.getInstance().goToRoom(exits.get(key));
                }
            });
            button.setPrefSize(240, 80);
            button.setFont(Font.font("Verdana", 24));
            rightBox.getChildren().add(button);
        }

        //The quit game button
        Button exitButton = new Button("Quit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GUIManager.quitGame();
            }
        });
        exitButton.setPrefSize(240, 80);
        exitButton.setFont(Font.font("Verdana", 24));
        rightBox.getChildren().add(exitButton);


        //Adding components to main component and returning scene
        root.getChildren().add(leftBox);
        root.getChildren().add(rightBox);

        root.getChildren().add(fadeRect);

        return new Scene(root, GUIManager.getSizeX(), GUIManager.getSizeY());
    }
}
