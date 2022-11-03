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
        System.out.print("Your final score was ");
        PointScore.printScore();
    }
    private void createRooms(){
        // Room creation
        InfoRoom introductionRoom, playedBeforeRoom, hubRoom, courseStartRoom, solderingInfoRoom,
                cableInfoRoom, computerInfoRoom, sortingInfoRoom,troubleshootInfoRoom, powerOutInfoRoom;
        CorrectQuizRoom solderingCorrectRoom, cableCorrectRoom, computerCorrectRoom, sortingCorrectRoom,
                troubleshootCorrectRoom, powerOutCorrectRoom;
        PointQuizRoom solderingPointRoom, cablePointRoom, computerPointRoom, sortingPointRoom,
                troubleshootPointRoom, powerOutPointRoom;

        // Info Rooms
        introductionRoom = new InfoRoom(
                "Welcome to this game called RepairZuul.\n" +
                "In this game you learn basic repair.\n" +
                "You will get options to each question\n" +
                        "where you will select the one you think is right.\n" +
                        "At the end you would be getting a score fitting for your answers",this, input);
        playedBeforeRoom = new InfoRoom("Have you played before?",this, input);
        hubRoom = new InfoRoom("Welcome to the learning hub",this, input);
        courseStartRoom = new InfoRoom("This is a short course, and it will teach you the basics of repairing", this, input);

        solderingInfoRoom = new InfoRoom("Info about Soldering", this, input);
        cableInfoRoom = new InfoRoom("", this,input);
        computerInfoRoom = new InfoRoom("", this,input);
        sortingInfoRoom = new InfoRoom("", this,input);
        troubleshootInfoRoom = new InfoRoom("", this,input);
        powerOutInfoRoom = new InfoRoom("", this,input);

        // Questions and point rooms
            // Right or Wrong
        solderingCorrectRoom = new CorrectQuizRoom("Something", this, input);
        cableCorrectRoom = new CorrectQuizRoom("Something", this, input);
        computerCorrectRoom = new CorrectQuizRoom("Something", this, input);
        sortingCorrectRoom = new CorrectQuizRoom("Something", this, input);
        troubleshootCorrectRoom = new CorrectQuizRoom("Something", this, input);
        powerOutCorrectRoom = new CorrectQuizRoom("Something", this, input);

            // Point giving
        solderingPointRoom = new PointQuizRoom("Something", this, input);
        cablePointRoom = new PointQuizRoom("Something", this, input);
        computerPointRoom = new PointQuizRoom("Something", this, input);
        sortingPointRoom = new PointQuizRoom("Something", this, input);
        troubleshootPointRoom = new PointQuizRoom("Something", this, input);
        powerOutPointRoom = new PointQuizRoom("Something", this, input);

        // Answers
            // Right or Wrong

            // Point giving
        

        // Navigation
        introductionRoom.setExit("continue", playedBeforeRoom);
        playedBeforeRoom.setExit("yes", hubRoom);
        playedBeforeRoom.setExit("no", courseStartRoom);
        courseStartRoom.setExit("back", playedBeforeRoom);

        // Hub Navigation
        hubRoom.setExit("soldering", solderingInfoRoom);
        hubRoom.setExit("cable", cableInfoRoom);
        hubRoom.setExit("computer", computerInfoRoom);
        hubRoom.setExit("sorting", sortingInfoRoom);
        hubRoom.setExit("troubleshoot", troubleshootInfoRoom);
        hubRoom.setExit("power", powerOutInfoRoom);

        // Exam Navigation

        // Go to Room
        goToRoom(introductionRoom);
    }
    public void goToRoom(Room room){
        this.activeRoom = room;
        activeRoom.onEnterRoom();
    }

    public void quitGame() {
        isPlaying = false;
    }
}
