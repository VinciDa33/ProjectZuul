import javafx.scene.Scene;

import java.util.HashMap;

public abstract class Room {
    HashMap<String, Room> exits = new HashMap<String, Room>();

    public void setExit(String key, Room room){
        exits.put(key,room);
    }

    public abstract void onEnterRoom();
    public abstract Scene createGUI();

}
