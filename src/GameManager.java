
public class GameManager {
    private static GameManager instance;

    private GameManager(){
        createRooms();
    }
    private InfoRoom pointScoreRoom;
    private Room activeRoom;

    public static GameManager getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new GameManager();
        return instance;
    }

    private void createRooms(){
        InfoRoom introductionRoom, hubRoom,
                computerInfoRoom1, computerInfoRoom2, computerInfoRoom3, computerInfoRoom4,
                solderingInfoRoom1, solderingInfoRoom2,
                cableInfoRoom1, cableInfoRoom2,
                recyclingInfoRoom1, recyclingInfoRoom2;

        CorrectQuizRoom computerQuizCRoom1, computerQuizCRoom2, solderingQuizCRoom1, cableQuizCRoom1, recyclingQuizCRoom1, recyclingQuizCRoom2;

        PointQuizRoom solderingQuizPRoom1, cableQuizPRoom1;

        InfoRoom testIntroduction;
        PointQuizRoom test1, test2, test3, test4;


        pointScoreRoom = new InfoRoom("Default Statement");
        pointScoreRoom.setImage("Img/Full2.png");
        pointScoreRoom.setPointScoreRoom(true);

        introductionRoom = new InfoRoom("Introduction");
        introductionRoom.setImage("Img/Full1.png");
        introductionRoom.setLanguageToggleRoom(true);

        hubRoom = new InfoRoom("Hub");
        hubRoom.setImage("Img/Full3.png");
        hubRoom.setLanguageToggleRoom(true);

        computerInfoRoom1 = new InfoRoom("Computer/ComputerInfo1");
        computerInfoRoom1.setImage("Img/Computer1.png");

        computerInfoRoom2 = new InfoRoom("Computer/ComputerInfo2");
        computerInfoRoom2.setImage("Img/Computer4.png");

        computerInfoRoom3 = new InfoRoom("Computer/ComputerInfo3");
        computerInfoRoom3.setImage("Img/Computer5.png");

        computerInfoRoom4 = new InfoRoom("Computer/ComputerInfo4");
        computerInfoRoom4.setImage("Img/Computer1.png");

        computerQuizCRoom1 = new CorrectQuizRoom("Computer/ComputerQuestion1");
        computerQuizCRoom1.addAnswer("Computer/ComputerAnswer11",
                "Computer/ComputerResponse11",
                false
        );
        computerQuizCRoom1.addAnswer("Computer/ComputerAnswer12",
                "Computer/ComputerResponse12",
                false
        );
        computerQuizCRoom1.addAnswer("Computer/ComputerAnswer13",
                "Computer/ComputerResponse13",
                true
        );
        computerQuizCRoom1.setImage("Img/Computer6Small.png");

        computerQuizCRoom2 = new CorrectQuizRoom("Computer/ComputerQuestion2");
        computerQuizCRoom2.addAnswer("Computer/ComputerAnswer21",
                "Computer/ComputerResponse21",
                false

        );
        computerQuizCRoom2.addAnswer("Computer/ComputerAnswer22",
                "Computer/ComputerResponse22",
                true
        );
        computerQuizCRoom2.addAnswer("Computer/ComputerAnswer23",
                "Computer/ComputerResponse23",
                false
        );
        computerQuizCRoom2.setImage("Img/Computer4Small.png");


        solderingInfoRoom1 = new InfoRoom("Soldering/SolderingInfo1");
        solderingInfoRoom1.setImage("Img/Solder1.png");

        solderingInfoRoom2 = new InfoRoom("Soldering/SolderingInfo2");
        solderingInfoRoom2.setImage("Img/Solder4.png");

        solderingQuizCRoom1 = new CorrectQuizRoom("Soldering/SolderingQuestion1");
        solderingQuizCRoom1.addAnswer("Soldering/SolderingAnswer11",
                "Soldering/SolderingResponse11",
                true
        );
        solderingQuizCRoom1.addAnswer("Soldering/SolderingAnswer12",
                "Soldering/SolderingResponse12",
                false
        );
        solderingQuizCRoom1.addAnswer("Soldering/SolderingAnswer13",
                "Soldering/SolderingResponse13",
                false
        );
        solderingQuizCRoom1.setImage("Img/Solder3Small.png");


        solderingQuizPRoom1 = new PointQuizRoom("Soldering/SolderingQuestion2");
        solderingQuizPRoom1.addAnswer("Soldering/SolderingAnswer21",
                "Soldering/SolderingResponse21",
                40
        );
        solderingQuizPRoom1.addAnswer("Soldering/SolderingAnswer22",
                "Soldering/SolderingResponse22",
                0
        );
        solderingQuizPRoom1.addAnswer("Soldering/SolderingAnswer23",
                "Soldering/SolderingResponse23",
                100
        );
        solderingQuizPRoom1.setImage("Img/Solder1Small.png");



        cableInfoRoom1 = new InfoRoom("Cables/CableInfo1");
        cableInfoRoom1.setImage("Img/Cable4.png");

        cableInfoRoom2 = new InfoRoom("Cables/CableInfo2");
        cableInfoRoom2.setImage("Img/Cable1.png");

        cableQuizCRoom1 = new CorrectQuizRoom("Cables/CableQuestion1");
        cableQuizCRoom1.addAnswer("Cables/CableAnswer11",
                "Cables/CableResponse11",
                false
        );
        cableQuizCRoom1.addAnswer("Cables/CableAnswer12",
                "Cables/CableResponse12",
                true
        );
        cableQuizCRoom1.setImage("Img/CableSmall1.png");


        cableQuizPRoom1 = new PointQuizRoom("Cables/CableQuestion2");
        cableQuizPRoom1.addAnswer("Cables/CableAnswer21",
                "Cables/CableResponse21",
                0
        );
        cableQuizPRoom1.addAnswer("Cables/CableAnswer22",
                "Cables/CableResponse22",
                50
        );
        cableQuizPRoom1.addAnswer("Cables/CableAnswer23",
                "Cables/CableResponse23",
                100
        );
        cableQuizPRoom1.setImage("Img/CableSmall2.png");


        recyclingInfoRoom1 = new InfoRoom("Recycling/RecyclingInfo1");
        recyclingInfoRoom1.setImage("Img/Recycle1.png");

        recyclingInfoRoom2 = new InfoRoom("Recycling/RecyclingInfo2");
        recyclingInfoRoom2.setImage("Img/Recycle2.png");

        recyclingQuizCRoom1 = new CorrectQuizRoom("Recycling/RecyclingQuestion1");
        recyclingQuizCRoom1.addAnswer("Recycling/RecyclingAnswer11",
                "Recycling/RecyclingResponse11",
                false
        );
        recyclingQuizCRoom1.addAnswer("Recycling/RecyclingAnswer12",
                "Recycling/RecyclingResponse12",
                true
        );
        recyclingQuizCRoom1.addAnswer("Recycling/RecyclingAnswer13",
                "Recycling/RecyclingResponse13",
                false
        );
        recyclingQuizCRoom1.setImage("Img/RecycleSmall1.png");

        recyclingQuizCRoom2 = new CorrectQuizRoom("Recycling/RecyclingQuestion2");
        recyclingQuizCRoom2.addAnswer("Recycling/RecyclingAnswer21",
                "Recycling/RecyclingResponse21",
                true
        );
        recyclingQuizCRoom2.addAnswer("Recycling/RecyclingAnswer22",
                "Recycling/RecyclingResponse22",
                false
        );
        recyclingQuizCRoom2.setImage("Img/RecycleSmall2.png");



        testIntroduction = new InfoRoom("TestIntroduction");
        testIntroduction.setImage("Img/Full2.png");

        test1 = new PointQuizRoom("Test/Test1");
        test1.setTest(true);
        test1.setSkipOnAnswer(true);
        test1.setImage("Img/Computer4Small.png");
        test1.addAnswer("Test/TestAnswer11",
                "Test/DefaultTestResponse", 0);
        test1.addAnswer("Test/TestAnswer12",
                "Test/DefaultTestResponse", 100);
        test1.addAnswer("Test/TestAnswer13",
                "Test/DefaultTestResponse", 50);

        test2 = new PointQuizRoom("Test/Test2");
        test2.setTest(true);
        test2.setSkipOnAnswer(true);
        test2.setImage("Img/Solder3Small.png");
        test2.addAnswer("Test/TestAnswer21",
                "Test/DefaultTestResponse", 100);
        test2.addAnswer("Test/TestAnswer22",
                "Test/DefaultTestResponse", 50);
        test2.addAnswer("Test/TestAnswer23",
                "Test/DefaultTestResponse", 0);

        test3 = new PointQuizRoom("Test/Test3");
        test3.setTest(true);
        test3.setSkipOnAnswer(true);
        test3.setImage("Img/CableSmall2.png");
        test3.addAnswer("Test/TestAnswer31",
                "Test/DefaultTestResponse", 50);
        test3.addAnswer("Test/TestAnswer32",
                "Test/DefaultTestResponse", 100);
        test3.addAnswer("Test/TestAnswer33",
                "Test/DefaultTestResponse", 0);

        test4 = new PointQuizRoom("Test/Test4");
        test4.setTest(true);
        test4.setSkipOnAnswer(true);
        test4.setImage("Img/RecycleSmall2.png");
        test4.addAnswer("Test/TestAnswer41",
                "Test/DefaultTestResponse", 50);
        test4.addAnswer("Test/TestAnswer42",
                "Test/DefaultTestResponse", 0);
        test4.addAnswer("Test/TestAnswer43",
                "Test/DefaultTestResponse", 100);


        introductionRoom.setExit("Navigation/ContinueButton", hubRoom);

        hubRoom.setExit("HubButtons/ComputerButton", computerInfoRoom1);
        hubRoom.setExit("HubButtons/SolderingButton", solderingInfoRoom1);
        hubRoom.setExit("HubButtons/CablesButton", cableInfoRoom1);
        hubRoom.setExit("HubButtons/RecycleButton", recyclingInfoRoom1);
        hubRoom.setExit("HubButtons/TestButton", testIntroduction);

        computerInfoRoom1.setExit("Navigation/ContinueButton", computerInfoRoom2);
        computerInfoRoom1.setExit("Navigation/BackButton", hubRoom);
        computerInfoRoom2.setExit("Navigation/ContinueButton", computerInfoRoom3);
        computerInfoRoom2.setExit("Navigation/BackButton", computerInfoRoom1);
        computerInfoRoom3.setExit("Navigation/ContinueButton", computerInfoRoom4);
        computerInfoRoom3.setExit("Navigation/BackButton", computerInfoRoom2);
        computerInfoRoom4.setExit("Navigation/ContinueButton", computerQuizCRoom1);
        computerInfoRoom4.setExit("Navigation/BackButton", computerInfoRoom3);
        computerQuizCRoom1.setExit("Navigation/ContinueButton", computerQuizCRoom2);
        computerQuizCRoom1.setExit("Navigation/BackButton", computerInfoRoom4);
        computerQuizCRoom2.setExit("Navigation/FinishButton", hubRoom);
        computerQuizCRoom2.setExit("Navigation/BackButton", computerQuizCRoom1);

        solderingInfoRoom1.setExit("Navigation/ContinueButton", solderingInfoRoom2);
        solderingInfoRoom1.setExit("Navigation/BackButton", hubRoom);
        solderingInfoRoom2.setExit("Navigation/ContinueButton", solderingQuizCRoom1);
        solderingInfoRoom2.setExit("Navigation/BackButton", solderingInfoRoom1);
        solderingQuizCRoom1.setExit("Navigation/ContinueButton", solderingQuizPRoom1);
        solderingQuizCRoom1.setExit("Navigation/BackButton", solderingInfoRoom2);
        solderingQuizPRoom1.setExit("Navigation/FinishButton", hubRoom);
        solderingQuizPRoom1.setExit("Navigation/BackButton", solderingQuizCRoom1);

        recyclingInfoRoom1.setExit("Navigation/ContinueButton", recyclingInfoRoom2);
        recyclingInfoRoom1.setExit("Navigation/BackButton", hubRoom);
        recyclingInfoRoom2.setExit("Navigation/ContinueButton", recyclingQuizCRoom1);
        recyclingInfoRoom2.setExit("Navigation/BackButton", recyclingInfoRoom1);
        recyclingQuizCRoom1.setExit("Navigation/ContinueButton", recyclingQuizCRoom2);
        recyclingQuizCRoom1.setExit("Navigation/BackButton", recyclingInfoRoom2);
        recyclingQuizCRoom2.setExit("Navigation/FinishButton", hubRoom);
        recyclingQuizCRoom2.setExit("Navigation/BackButton", recyclingQuizCRoom1);

        cableInfoRoom1.setExit("Navigation/ContinueButton", cableInfoRoom2);
        cableInfoRoom1.setExit("Navigation/BackButton", hubRoom);
        cableInfoRoom2.setExit("Navigation/ContinueButton", cableQuizCRoom1);
        cableInfoRoom2.setExit("Navigation/BackButton", cableInfoRoom1);
        cableQuizCRoom1.setExit("navigation/ContinueButton", cableQuizPRoom1);
        cableQuizCRoom1.setExit("Navigation/BackButton", cableInfoRoom2);
        cableQuizPRoom1.setExit("Navigation/FinishButton", hubRoom);
        cableQuizPRoom1.setExit("Navigation/BackButton", cableQuizCRoom1);



        testIntroduction.setExit("Navigation/ContinueButton", test1);
        testIntroduction.setExit("Navigation/BackButton", hubRoom);

        test1.setExit("Navigation/ContinueButton", test2);
        test2.setExit("Navigation/ContinueButton", test3);
        test3.setExit("Navigation/ContinueButton", test4);
        test4.setExit("Navigation/ContinueButton", pointScoreRoom);


        goToRoom(introductionRoom);
    }

    public void goToRoom(Room room){
        this.activeRoom = room;
        room.onEnterRoom();
    }

    public Room getActiveRoom() {
        return activeRoom;
    }

    public void updatePointScoreRoom() {
        pointScoreRoom.setDescription(FileReader.loadFile("PointScore/PointScore") + PointScore.getPoints() + "]");
    }
}
