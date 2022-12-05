import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class CustomButton extends Button {

    String defaultBackground = "Img/ButtonImage.png";
    String onHoverBackground = "Img/ButtonImageHover.png";

    static String[] defaultClickSounds = {
            "ClickSound1.wav",
            "ClickSound2.wav",
            "ClickSound3.wav",
            "ClickSound4.wav"
    };

    public CustomButton(String text) {
        super(text);

        //Default Size
        setPrefSize(240, 80);

        setBackground(new Background(new BackgroundImage(new Image(defaultBackground, 240, 80, false, false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setBackground(new Background(new BackgroundImage(new Image(onHoverBackground, getPrefWidth(), getPrefHeight(), false, false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setBackground(new Background(new BackgroundImage(new Image(defaultBackground, getPrefWidth(), getPrefHeight(), false, false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
            }
        });
    }

    public void setDefaultBackground(String path) {
        defaultBackground = path;
        setBackground(new Background(new BackgroundImage(new Image(defaultBackground, getPrefWidth(), getPrefHeight(), false, false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }

    public void setOnHoverBackground(String path) {
        onHoverBackground = path;
    }
}
