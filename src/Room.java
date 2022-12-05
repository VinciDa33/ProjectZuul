import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Room {
    HashMap<String, Room> exits = new HashMap<String, Room>();
    String imageString;

    public void setExit(String key, Room room){
        exits.put(key,room);
    }

    public abstract void onEnterRoom();

    //REPLACED BY GUI - EVENT BASED EXECUTION
    //public abstract void update();

    public abstract Scene createGUI();

    public void setImage(String imageString) {
        this.imageString = imageString;
    }


}
