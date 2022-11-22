import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
        HBox hBox = new HBox();
        hBox.setBackground(new Background(new BackgroundFill(Color.rgb(100,50,30), CornerRadii.EMPTY, Insets.EMPTY)));

        VBox leftBox = new VBox();
        VBox rightBox = new VBox();
        leftBox.setBackground(new Background(new BackgroundFill(Color.rgb(10,100,50), CornerRadii.EMPTY, Insets.EMPTY)));
        rightBox.setBackground(new Background(new BackgroundFill(Color.rgb(50,60,120), CornerRadii.EMPTY, Insets.EMPTY)));

        Label descriptionLabel = new Label(description);
        descriptionLabel.setTextFill(Color.rgb(10,10,10));

        leftBox.getChildren().add(descriptionLabel);

        for (String key : exits.keySet()){
            Button button = new Button(key);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    GameManager.getInstance().goToRoom(exits.get(key));
                }
            });
            rightBox.getChildren().add(button);
        }

        Button quitButton = new Button("quit");
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GUIManager.quitGame();
            }
        });
        rightBox.getChildren().add(quitButton);
        hBox.getChildren().addAll(leftBox,rightBox);

        return new Scene(hBox, GUIManager.getSizeX(), GUIManager.getSizeY());
    }

}
