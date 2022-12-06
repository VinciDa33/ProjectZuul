
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
                cableInfoRoom1,
                recyclingInfoRoom1, recyclingInfoRoom2;

        CorrectQuizRoom computerQuizCRoom1, computerQuizCRoom2, solderingQuizCRoom1, cableQuizCRoom1, recyclingQuizCRoom1;

        PointQuizRoom solderingQuizPRoom1, cableQuizPRoom1, recyclingQuizPRoom1;

        InfoRoom testIntroduction;
        PointQuizRoom test1, test2, test3, test4, test5;




        pointScoreRoom = new InfoRoom("Default Statement");
        pointScoreRoom.setImage("Img/Full2.png");

        introductionRoom = new InfoRoom("Introduction");
        introductionRoom.setImage("Img/Full1.png");
        introductionRoom.setLanguageToggleRoom(true);

        hubRoom = new InfoRoom("Hub");
        hubRoom.setImage("Img/Full3.png");
        hubRoom.setLanguageToggleRoom(true);

        computerInfoRoom1 = new InfoRoom("ComputerInfo1");
        computerInfoRoom1.setImage("Img/Computer1.png");

        computerInfoRoom2 = new InfoRoom(
                "Step 1:\n" +
                        "The CPU is mounted on the motherboard along with the CPU cooler. Be sure to check if thermal paste is pre-applied to the cooler, " +
                        "if not apply your own thermal paste." +
                        "\n\nStep 2:\n" +
                        "The RAM is clicked into place in the RAM slots to the right of the CPU slot. When mounting 2 RAM sticks in a motherboard with 4 RAM slots, be sure to check " +
                        "the motherboard manual for the correct RAM slots to allow for dual channel for the best performance." +
                        "\n\nStep 3:\n" +
                        "Any M.2 SSDs are mounted in the M.2 slots on the motherboard and screwed in place, so the SSD is laying flat above the board with a standoff screw." +
                        "\n\nStep 4:\n" +
                        "Before mounting the motherboard in the case, make sure to screw in any standoff screws in the case, so that they line up with the holes on the motherboard. " +
                        "Mount the I/O shield that comes with the motherboard if it is not pre-attached to the motherboard." +
                        "\nThe motherboard is then placed on the standoffs and screwed into place."

        );
        computerInfoRoom2.setImage("Img/Computer4.png");

        computerInfoRoom3 = new InfoRoom(
                "Step 5:\n" +
                        "The power supply (PSU) is mounted in the bottom of the case, with the fan on the power supply facing the ventilation holes on the case. " +
                        "It is screwed in place and the cables needed are plugged into the power supply." +
                        "\n\nStep 6:\n" +
                        "Any SATA drives are mounted in the drive storage and connected to the power supply. The SATA data cables are connected to the motherboard." +
                        "\n\nStep 7:\n" +
                        "Before mounting the GPU, make sure to unscrew the slot covers on the back of the case. Lower the GPU into the case and plug it into the top-most PCIe X16 " +
                        "slot (the long slots that go across the motherboard)." +
                        "\n\nStep 8:\n" +
                        "Plug all the correct cables into the correct ports. Make sure to check your manual to make sure you are using the correct cables and ports. " +
                        "The front I/O on the case needs to be plugged in to the motherboard as well. They will be the loose cables hanging from the top of the case."
        );
        computerInfoRoom3.setImage("Img/Computer5.png");

        computerInfoRoom4 = new InfoRoom(
                "Step 9:\n" +
                        "Turn on the PC to make sure everything works. If not double check that everything is mounted and plugged in correctly." +
                        "\n\nStep 10:\n" +
                        "It is a good idea to do some cable management to clear up some room the case. Most cases will have space in the back for cables. " +
                        "Organizing these cables will also allow you to make changes easier later, as well as optimize airflow." +
                        "\n\nStep 11:\n" +
                        "Install the operating system and drivers for the components for optimal performance."
        );
        computerInfoRoom4.setImage("Img/Computer1.png");

        computerQuizCRoom1 = new CorrectQuizRoom(
                "What components should be mounted on the motherboard before inserting the motherboard in the PC?"
        );
        computerQuizCRoom1.addAnswer("Power supply, CPU and RAM sticks",
                "The power supply most often has a specific slot in the case itself, therefore it should never be mounted on the motherboard.",
                false
        );
        computerQuizCRoom1.addAnswer("CPU-cooler, SATA drives, M.2 SSD and GPU",
                "The CPU-cooler should never be mounted before the CPU, SATA drives are not installed on the motherboard, " +
                        "and the GPU is fastened to both the motherboard and PC case, therefore it should be mounted after the motherboard after its inserted in the case",
                false
        );
        computerQuizCRoom1.addAnswer("CPU, CPU-cooler, RAM sticks and M.2 SSD",
                "Well done, these are the correct components, which are all easier to mount outside the case.",
                true
        );
        computerQuizCRoom1.setImage("Img/Computer6Small.png");

        computerQuizCRoom2 = new CorrectQuizRoom("Why should you spend time on cable management?");
        computerQuizCRoom2.addAnswer("It looks better and is more effective when showing off your new build",
                "Proper cable management is not for showing off, but for airflow and to make future changes and repairs easier.",
                false

        );
        computerQuizCRoom2.addAnswer("It makes future changes and repairs easier, and also creates better airflow",
                "Exactly, when problems arise in the future it will be easier to fix.",
                true
        );
        computerQuizCRoom2.addAnswer("It's to ensure the cables won't interfere with each other and shortcircuit",
                "All cables are already insulated, so it is highly unlikely that cables would interfere with each other.",
                false
        );
        computerQuizCRoom2.setImage("Img/Computer4Small.png");

        solderingInfoRoom1 = new InfoRoom(
                "It could be a good idea to learn how to solder basic components since it is a versatile tool, " +
                        "which can save a lot of components from being thrown out. Soldering is a bit like welding, but easier and less dangerous." +
                        "\nWhen soldering you join two ore more components or electronic parts together, " +
                        "using a metal alloy called 'solder', which is made of mostly tin and copper." +
                        "\n\nYou will need:" +
                        "\n- Soldering iron" +
                        "\n- Solder" +
                        "\n- Soldering station"
        );
        solderingInfoRoom1.setImage("Img/Solder1.png");

        solderingInfoRoom2 = new InfoRoom(
                "Make sure the soldering irons tip, is secured." +
                        "\nTurn on the soldering station, and heat the iron to 400C. " +
                        "\nHold the electrical components together \n\n[TURN OFF ALL COMPONENTS FIRST]." +
                        "\n\nHeat up the joint before applying solder. When the joint is heated, " +
                        "melt the solder on the joint, not on the iron. Let the solder cool and solidify, " +
                        "do not blow on the solder.\n\n- All done!"
        );
        solderingInfoRoom2.setImage("Img/Solder4.png");

        solderingQuizCRoom1 = new CorrectQuizRoom("Where should you melt the solder?");
        solderingQuizCRoom1.addAnswer("You heat the joint with the iron, then apply the solder directly to the joint.",
                "Thats right, the solder should not be melted directly by the iron",
                true
        );
        solderingQuizCRoom1.addAnswer("You melt the solder directly on the iron.",
                "The solder should be applied on the heated joint, not directly on the iron.",
                false
        );
        solderingQuizCRoom1.addAnswer("You hold the solder on the joint, melt it by pressing the iron on it.",
                "The joint should be heated before applying the solder so that the iron does not have to melt the solder.",
                false
        );
        solderingQuizCRoom1.setImage("Img/Solder3Small.png");

        solderingQuizPRoom1 = new PointQuizRoom("What is the most used alloy for soldering?");
        solderingQuizPRoom1.addAnswer("A mix of tin and lead.",
                "It has been used in the past, but due to lead fumes being toxic to inhale, it is no longer used.",
                40
        );
        solderingQuizPRoom1.addAnswer("A mix of copper and lead.",
                "Copper and lead is not used in solder, lead fumes are toxic, so another mix is better suited.",
                0
        );
        solderingQuizPRoom1.addAnswer("A mix of tin and copper.",
                "Tin and copper is the most common alloy for soldering.",
                100
        );
        solderingQuizPRoom1.setImage("Img/Solder1Small.png");

        cableInfoRoom1 = new InfoRoom(
                "When troubleshooting your computer or other components, one of the most common mistakes begins with the cables." +
                        "\n\nIt can be all from not connecting your hardware to power or not enough power, " +
                        "to outright faulty cables or misplacement, which can cause in the most extreme cases fires." +
                        "\n\nTherefore its important to keep the power clean and running with no faults. " +
                        "A good practice is to always to keep your cables under as less tension as possible for them to not bend/break, " +
                        "and to keep them clean and checking for no visible copper wires."
        );
        cableInfoRoom1.setImage("Img/Cable4.png");

        recyclingInfoRoom1 = new InfoRoom(
                "If you deem reparation too hard, but still want to recycle your electronics as best as possible, " +
                        "there are still some options to keep in mind." +
                        "\n\n- Take it to a recycler" +
                        "\n- Donate it" +
                        "\n- Buyback"
        );
        recyclingInfoRoom1.setImage("Img/Recycle1.png");

        recyclingInfoRoom2 = new InfoRoom(
                "For recycling you should look up a certified electronics recycler. " +
                        "A quick search should show places near you." +
                        "\n\n For donations there are multiple organizations that will put your old products to good use." +
                        "\n\nIf your product still works, or has working parts you can donate it to charity or nonprofit organizations. " +
                        "Buyback might be possible for some products. Larger companies may have programs, with rewards for bringing back E-waste. " +
                        "Amazon for example offers gift cards for old electronics devices." +
                        "\n\nThese options should be considered, if you are not keen to start repairing."
        );
        recyclingInfoRoom2.setImage("Img/Recycle2.png");



        testIntroduction = new InfoRoom("TestIntroduction");
        testIntroduction.setImage("Img/Full2.png");

        test1 = new PointQuizRoom("Test1");
        test1.setTest(true);
        test1.setSkipOnAnswer(true);
        test1.setImage("Img/Computer4Small.png");
        test1.addAnswer("After installing the GPU.",
                "The GPU is the last thing you install", 0);
        test1.addAnswer("After installing the CPU, cooler and RAM.",
                "This is the best practice, and the easiest way to do it", 100);
        test1.addAnswer("Before installing anything on the motherboard.",
                "You can do it this way, though it is highly inconvenient.", 50);

        test2 = new PointQuizRoom("What tools will you need when soldering?");
        test2.setTest(true);
        test2.setSkipOnAnswer(true);
        test2.setImage("Img/Solder3Small.png");
        test2.addAnswer("Solder, soldering iron and a soldering station.",
                "Well done, These are the 3 main tools you will need.", 100);
        test2.addAnswer("Solder, soldering iron and a power supply.",
                "You should use a dedicated soldering station, not a power supply, though they both are meant for supplying power.", 50);
        test2.addAnswer("Soldering iron, Copper wire and a power supply",
                "You should use a dedicated soldering station instead of a power supply, and definitely no copper wire.", 0);


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
        computerQuizCRoom2.setExit("Navigation/BackButton", computerQuizCRoom2);

        solderingInfoRoom1.setExit("Navigation/ContinueButton", solderingInfoRoom2);
        solderingInfoRoom1.setExit("Navigation/BackButton", hubRoom);
        solderingInfoRoom2.setExit("Navigation/ContinueButton", solderingQuizCRoom1);
        solderingInfoRoom2.setExit("Navigation/BackButton", solderingInfoRoom1);
        solderingQuizCRoom1.setExit("Navigation/ContinueButton", solderingQuizPRoom1);
        solderingQuizCRoom1.setExit("Navigation/BackButton", solderingInfoRoom2);
        solderingQuizPRoom1.setExit("Navigation/FinishButton", hubRoom);
        solderingQuizPRoom1.setExit("Navigation/BackButton", solderingQuizCRoom1);

        recyclingInfoRoom1.setExit("Navigation/ContinueButton", recyclingInfoRoom2);

        testIntroduction.setExit("Navigation/ContinueButton", test1);
        testIntroduction.setExit("Navigation/BackButton", hubRoom);

        test1.setExit("Navigation/ContinueButton", test2);
        test2.setExit("Navigation/ContinueButton", pointScoreRoom);

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
        System.out.println("!");
        pointScoreRoom.setDescription(FileReader.loadFile("PointScore/PointScore") + PointScore.getPoints() + "]");
    }
}
