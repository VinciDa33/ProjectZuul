
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

        if (activeRoom instanceof QuizRoom && !((QuizRoom) activeRoom).HasAnsweredCorrect()) {
            QuizRoom qr = (QuizRoom) activeRoom;
            qr.Answer(command);
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
        Room info1;
        QuizRoom quiz1, quiz2;

        info1 = new InfoRoom("This is a test quiz!");
        quiz1 = new QuizRoom("What is 5 + 5");
        quiz2 = new QuizRoom("What is the velocity of an unladen swallow");

        info1.setExit("Continue", quiz1);

        quiz1.setExit("Continue", quiz2);
        quiz1.AddAnswer("10", true, "That is the correct answer!");
        quiz1.AddAnswer("7", false, "That is not the correct answer!");
        quiz1.AddAnswer("-30", false, "That is not the correct answer!");
        quiz1.AddAnswer("Fireball", false, "That is not the correct answer!");

        quiz2.setExit("Exit", info1);
        quiz2.AddAnswer("30 miles per hour", false, "No reason why, but you are wrong.");
        quiz2.AddAnswer("75 km per hour", false, "Get the reference bro.");
        quiz2.AddAnswer("An african or european swallow?", true, "A man of culture i see!");

        goToRoom(info1);
    }

    public void goToRoom(Room room) {
        activeRoom = room;
        activeRoom.OnEnterRoom();
    }
}
