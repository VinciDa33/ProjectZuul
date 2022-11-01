import java.util.HashMap;

public abstract class Room {
    InputManager input;
    GameManager gm;
    HashMap<String, Room> exits = new HashMap<String, Room>();

    public void setExit(String key, Room room){
        exits.put(key,room);
    }
    public abstract void onEnterRoom();
    public abstract void update();

}

//Start med, at skrive dine metoder op!
//Derefter, skriv dine private