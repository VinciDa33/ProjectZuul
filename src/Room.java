import java.util.HashMap;

public abstract class Room {
    InputManager input;
    GameManager gm;
    HashMap<String, Room> exits = new HashMap<String, Room>();

    public void setExit(String key, Room room){
        exits.put(key,room);
    }

    public void printExitOptions() {
        System.out.println("\n-- What do you want to do? --");
        for (String key : exits.keySet()) {
            System.out.println("* " + key.substring(0,1).toUpperCase() + key.substring(1));
        }
        System.out.println("* " + "Quit");
    }

    public abstract void onEnterRoom();
    public abstract void update();

}

//Start med, at skrive dine metoder op!
//Derefter, skriv dine private