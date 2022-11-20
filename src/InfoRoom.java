import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.security.cert.Certificate;

public class InfoRoom extends Room{
    String description;

    public InfoRoom(String description) {
        this.description = description;
    }
    @Override
    public void onEnterRoom(){
        //REPLACED BY GUI
        //System.out.println("---------- Learning ----------");
        //System.out.println(description);
        //System.out.println("\n---------- oooooooo ----------");

        GUIManager.setScene(createGUI());
    }

    @Override
    public Scene createGUI() {
        //Setting up the main boxes for holding components
        HBox horBox = new HBox();
        horBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));

        VBox leftBox = new VBox();
        leftBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));
        VBox rightBox = new VBox();
        rightBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), CornerRadii.EMPTY, Insets.EMPTY)));

        //The label with the description
        Label descriptionLabel = new Label(description);
        descriptionLabel.setTextFill(Color.rgb(220, 220, 220));

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
        rightBox.getChildren().add(exitButton);


        //Adding components to main component and returning scene
        horBox.getChildren().add(leftBox);
        horBox.getChildren().add(rightBox);

        return new Scene(horBox, GUIManager.getSizeX(), GUIManager.getSizeY());

    }

    //REPLACED BY GUI - EVENT BASED EXECUTION
    /*
    @Override
    public void update(){
        printExitOptions();

        String userInput = InputManager.getInstance().getNextLine();
        if (exits.containsKey(userInput)) {
            GameManager.getInstance().goToRoom(exits.get(userInput));
            return;
        }
        if (userInput.equals("quit")) {
            //GameManager.getInstance().quitGame();
            return;
        }

        System.out.println("Unknown input!");
    }
     */

}
