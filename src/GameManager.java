public class GameManager {
    private InputManager input;
    private Room activeRoom;
    private boolean isPlaying = false;

    GameManager(){
        input = new InputManager();
        createRooms();
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
        CorrectQuizRoom testRoom = new CorrectQuizRoom("2 + 2",this,input);
        testRoom.addAnswer("9", "FALSE LOSER", false);
        testRoom.addAnswer("4", "True, still loser", true);
        CorrectQuizRoom testRoom2 = new CorrectQuizRoom("is School fun", this,input);
        testRoom2.addAnswer("9", "FALSE LOSER", false);
        testRoom2.addAnswer("Yes", "True, still loser", true);
        testRoom.setExit("Continue",testRoom2);
        testRoom2.setExit("Back",testRoom);
        goToRoom(testRoom);
    }
    public void goToRoom(Room room){
        this.activeRoom = room;
        activeRoom.onEnterRoom();
    }

    public void quitGame() {
        isPlaying = false;
    }
}
