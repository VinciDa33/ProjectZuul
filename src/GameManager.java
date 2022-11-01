public class GameManager {
    private InputManager input;
    private Room activeRoom;
    private boolean isPlaying = false;

    GameManager(){
        input = new InputManager();
    }

    public void play(){
        if(isPlaying)
            return;

        isPlaying = true;

        while(isPlaying){
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

    public void quitGame() {
        isPlaying = false;
    }
}
