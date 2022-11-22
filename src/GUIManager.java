import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIManager extends Application {
    private static Stage mainWindow;
    private final static int sizeX = 1280;
    private final static int sizeY = 720;

    public static void main(String[] args) {
        launch(args);
        //gm.play();
    }

    @Override
    public void start(Stage window) throws Exception {
        mainWindow = window;

        Scene tempScene = new Scene(new Group(), sizeX, sizeY);
        tempScene.setFill(Color.rgb(30, 30, 30));
        mainWindow.setScene(tempScene);

        mainWindow.setResizable(false);
        mainWindow.setTitle("Repair Zuul");
        mainWindow.show();

        //InputManager.getInstance();
        GameManager.getInstance();
    }

    public static void setScene(Scene scene) {
        mainWindow.setScene(scene);
    }

    public static int getSizeX() {
        return sizeX;
    }

    public static int getSizeY() {
        return sizeY;
    }

    public static void quitGame() {
        Platform.exit();
    }
}
