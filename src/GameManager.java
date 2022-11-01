public class GameManager {
    private final InputManager input;
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
        CorrectQuizRoom testRoom, testRoom2;
        InfoRoom room3;

        testRoom = new CorrectQuizRoom("2 + 2",this, input);
        testRoom.addAnswer("9", "Unfortunately, that answer is wrong, 2+2 is not 9.", false);
        testRoom.addAnswer("4", "Well done, you answered that correctly", true);

        testRoom2 = new CorrectQuizRoom("is School fun",this, input);
        testRoom2.addAnswer("No", "You are could be right, but we don't think so.", false);
        testRoom2.addAnswer("Yes", "Big win right there!", true);

        room3 = new InfoRoom("This is learning material: Schools is not fun, now continue to the next question.",this, input);

        testRoom.setExit("Continue",room3);
        room3.setExit("Continue", testRoom2);
        room3.setExit("Back", testRoom);
        testRoom2.setExit("Back",room3);

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
