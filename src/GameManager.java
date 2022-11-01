public class GameManager {
    private InputManager input;
    private Room activeRoom;
    private boolean isPlaying;
    GameManager(){
        input = new InputManager();
    }

    public void play(){
        if(isPlaying == true)
            return;
        while(true){
            activeRoom.update();
        }
    }
    private void createRooms(){
        // Coming soon
    }
    public void goToRoom(Room room){
        this.activeRoom = room;
        activeRoom.onEnterRoom();
    }
}
