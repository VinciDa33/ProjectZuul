import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIManager extends Application {
    private static Stage window;

    private final static int sizeX = 700;
    private final static int sizeY = 500;

    public static void main(String[] args) {
        launch(args);
    }

    public static void setScene(Scene scene){
        window.setScene(scene);
    }
    public static int getSizeX(){
        return sizeX;
    }
    public static int getSizeY(){
        return sizeY;
    }
    public static void quitGame(){
        Platform.exit();
    }
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        Scene scene = new Scene(new Group(), sizeX, sizeY);

        window.setResizable(false);
        window.setScene(scene);
        window.setTitle("Repair of Zuul");
        window.show();

        GameManager.getInstance();
    }
}
