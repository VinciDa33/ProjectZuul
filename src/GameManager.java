
public class GameManager {
    Room activeRoom;
    InputManager input;

    boolean gameOver = false;

    public GameManager() {
        input = new InputManager();
        createRooms();
    }

    public void play() {
        while(!gameOver) {
            InterpretInput(input.getNextLine());
        }
    }

    private void InterpretInput(String command) {
        if (command.equals("Exit")) {
            gameOver = true;
            return;
        }

        for ( String key : activeRoom.exits.keySet() ) {
            if (command.equals(key)) {
                goToRoom(activeRoom.exits.get(command));
                return;
            }
        }
        System.out.println("Unknown command!");
    }

    public void createRooms() {
        Room test1, test2, test3;

        test1 = new InfoRoom("We are going on an adventure!");
        test2 = new InfoRoom("Somewhere far away!");
        test3 = new InfoRoom("Now go back!");

        test1.setExit("Continue", test2);
        test2.setExit("Continue", test3);
        test2.setExit("Back", test1);
        test3.setExit("Back", test2);

        goToRoom(test1);
    }

    public void goToRoom(Room room) {
        activeRoom = room;
        activeRoom.OnEnterRoom();
    }
}
