import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import javax.sound.sampled.Line;

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
        HBox horBox = new HBox();

        VBox leftBox = new VBox();
        leftBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));
        leftBox.setPrefWidth(GUIManager.getSizeX()/4f*3);
        leftBox.setAlignment(Pos.TOP_CENTER);

        if (imageString != null) {
            Image backImg = new Image(imageString, 960, 720, false, false);
            BackgroundImage bImg = new BackgroundImage(backImg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background bGround = new Background(bImg);
            leftBox.setBackground(bGround);
        }

        VBox rightBox = new VBox();
        rightBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), CornerRadii.EMPTY, Insets.EMPTY)));
        rightBox.setPrefWidth(GUIManager.getSizeX()/4f);
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
                    GameManager.getInstance().goToRoom(exits.get(key));
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
        horBox.getChildren().add(leftBox);
        horBox.getChildren().add(rightBox);

        return new Scene(horBox, GUIManager.getSizeX(), GUIManager.getSizeY());
    }
}
