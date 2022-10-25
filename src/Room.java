import java.util.HashMap;

public class Room {
    HashMap<String, Room> exits = new HashMap<>();

    public Room() {
    }

    public void setExit(String key, Room exit) {
        exits.put(key, exit);
    }

    public void OnEnterRoom() {

    }
}
