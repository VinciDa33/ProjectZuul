public class GameManager {
    private static GameManager instance;

    private Room activeRoom;
    private boolean isPlaying = false;

    private GameManager(){
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

    public static GameManager getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new GameManager();
        return instance;
    }

    private void createRooms(){
        // Room creation
        InfoRoom introductionRoom, playedBeforeRoom, hubRoom, courseStartRoom, solderingInfoRoom,
                cableInfoRoom, computerInfoRoom, sortingInfoRoom,troubleshootInfoRoom, powerOutInfoRoom;
        CorrectQuizRoom solderingCorrectRoom, cableCorrectRoom, computerCorrectRoom, sortingCorrectRoom,
                troubleshootCorrectRoom, powerOutCorrectRoom;
        PointQuizRoom solderingPointRoom, cablePointRoom, cablePointRoom2 ,computerPointRoom, sortingPointRoom,
                troubleshootPointRoom, powerOutPointRoom, powerOutPointRoom2, powerOutPointRoom3;
        PointQuizRoom exam1, exam2, exam3;

        // Info Rooms
        introductionRoom = new InfoRoom(
                "Welcome to this game called RepairZuul.\n" +
                "In this game you learn basic repair.\n" +
                "You will get options to each question\n" +
                        "where you will select the one you think is right.\n" +
                        "At the end you would be getting a score fitting for your answers");
        playedBeforeRoom = new InfoRoom("Have you played before?");
        hubRoom = new InfoRoom("Welcome to the learning hub");
        courseStartRoom = new InfoRoom("This is a short course, and it will teach you the basics of repairing");

        solderingInfoRoom = new InfoRoom("It could be a good idea to learn how to solder basic components since it is a versatile tool,\n " +
                                                    "which can save a lot of components from being thrown out.Soldering is a bit like welding, but easier and less dangerous.\n" +
                                                    "When soldering you join two ore more electronic parts together,\n" +
                                                    "using a metal alloy called 'solder', which is made of mostly tin and copper." +
                                                    "\nYou will need:" +
                                                    "\n- Soldering iron" +
                                                    "\n- Solder" +
                                                    "\n- Soldering station" +
                                                    "\n\nMake sure the soldering irons tip, is secured.\n" +
                                                    "Turn on the soldering station, and heat the iron to 400C.\n" +
                                                    "Hold the electrical components together [TURN OFF ALL COMPONENTS FIRST].\n" +
                                                    "Heat up the joint before applying solder. When the joint is heated,\n" +
                                                    "melt the solder on the joint, not on the iron. Let the solder cool and solidify,\n" +
                                                    "do not blow on the solder.\n- All done!");
        cableInfoRoom = new InfoRoom("When troubleshooting your computer or other components, one of the most common mistakes begins with the cables.\n" +
                                            "It can be all from not connecting your hardware to power or not enough power,\n" +
                                            "to outright faulty cables or misplacements, which can cause in the most extreme cases fires.\n" +
                                            "Therefore its important to keep the power clean and running with no faults.\n" +
                                            "\n\n\nA good practice is to always to keep your cables under as less tension as possible for them to not bend/break,\n" +
                                            "and to keep them clean and checking for no visible copper wires.");
        computerInfoRoom = new InfoRoom("This room will teach you to assemble a computer with all parts of the PC in the easiest order.\n" +
                "When building a computer it is easiest to assemble most of the components on the motherboard before mounting the motherboard in the case, \n" +
                "however it is possible to mount the motherboard in the case beforehand, but it be more difficult with the limited space in the case.\n" +
                "\n" +
                "Step 1:\n" +
                "The CPU is mounted on the motherboard along with the CPU cooler. Be sure to check if thermal paste is pre-applied to the cooler, \n" +
                "if not apply your own thermal paste.\n" +
                "\n" +
                "Step 2:\n" +
                "The RAM is clicked into place in the RAM slots to the right of the CPU slot. When mounting 2 RAM sticks in a motherboard with 4 RAM slots, be sure to check\n" +
                "the motherboard manual for the correct RAM slots to allow for dual channel for the best performance.\n" +
                "\n" +
                "Step 3:\n" +
                "Any M.2 SSDs are mounted in the M.2 slots on the motherboard and screwed in place, so the SSD is laying flat above the board with a standoff screw.\n" +
                "\n" +
                "Step 4:\n" +
                "Before mounting the motherboard in the case, make sure to screw in any standoff screws in the case, so that they line up with the holes on the motherboard.\n" +
                "Mount the I/O shield that comes with the motherboard if it is not pre-attached to the motherboard.\n" +
                "The motherboard is then placed on the standoffs and screwed into place.\n" +
                "\n" +
                "Step 5:\n" +
                "The power supply (PSU) is mounted in the bottom of the case, with the fan on the power supply facing the ventilation holes on the case.\n" +
                "It is screwed in place and the cables needed are plugged into the power supply.\n" +
                "\n" +
                "Step 6:\n" +
                "Any SATA drives are mounted in the drive storage and connected to the power supply. The SATA data cables are connected to the motherboard.\n" +
                "\n" +
                "Step 7:\n" +
                "Before mounting the GPU, make sure to unscrew the slot covers on the back of the case. Lower the GPU into the case and plug it into the top-most PCIe X16\n" +
                "slot (the long slots that go across the motherboard).\n" +
                "\n" +
                "Step 8:\n" +
                "Plug all the correct cables into the correct ports. Make sure to check your manual to make sure you are using the correct cables and ports.\n" +
                "The front I/O on the case needs to be plugged in to the motherboard as well. They will be the loose cables hanging from the top of the case.\n" +
                "\n" +
                "Step 9:\n" +
                "Turn on the PC to make sure everything works. If not double check that everything is mounted and plugged in correctly.\n" +
                "\n" +
                "Step 10:\n" +
                "It is a good idea to do some cable management to clear up some room the case. Most cases will have space in the back for cables.\n" +
                "Organizing these cables will also allow you to make changes easier later.\n" +
                "\n" +
                "Step 11:\n" +
                "Install the operating system and drivers for the components for optimal performance.");
        sortingInfoRoom = new InfoRoom("If you deem reparation too hard, but still want to recycle your electronics as best as possible,\n" +
                                                "there are still some options to keep in mind.\n" +
                                                "- Take it to a recycler" +
                                                "\n- Donate it" +
                                                "\n- Buyback" +
                                                "\n\nFor recycling you should look up a certified electronics recycler.\n'" +
                                                "A quick search should show places near you.\n\n" +
                                                "If your product still works, or has working parts you can donate it to charity or nonprofit organizations.\n\n" +
                                                "Buyback might be possible for some products. Larger companies may have programs, with rewards for bringing back E-waste.\n" +
                                                "Amazon for example offers gift cards for old electronics devices.\n\n" +
                                                "These options should be considered, if you are not keen to start repairing.");
        troubleshootInfoRoom = new InfoRoom("");
        powerOutInfoRoom = new InfoRoom("Usually when we plug something into an power outlet, then we are used to press the on/off button.\n" +
                                                "This is something a common man knows from the beginning of time with power outlets.\n" +
                                                "But when something goes wrong with our power outlets then we can extremely be concerned about fire.\n" +
                                                "So, in this case we will introduce the Questions, which relate to the things and tools which are required to fixing a power outlet.\n" +
                                                "Though in many cases it would be advised to contact professionals!");

        // Questions and point rooms
            // Right or Wrong
        solderingCorrectRoom = new CorrectQuizRoom("Where should you melt the solder?");
        cableCorrectRoom = new CorrectQuizRoom("When connecting some hardware (like a Graphical Processor Unit)\nto your computer and thereafter connecting the power cables to the GPU,\nis there anything you'll need to be extra careful around? and why?");
        computerCorrectRoom = new CorrectQuizRoom("What way should the fan on the PSU face?");
        sortingCorrectRoom = new CorrectQuizRoom("Something");
        troubleshootCorrectRoom = new CorrectQuizRoom("Something");
        powerOutCorrectRoom = new CorrectQuizRoom("Something");

            // Point giving
        solderingPointRoom = new PointQuizRoom("What is the most used alloy for soldering?");
        cablePointRoom = new PointQuizRoom("Before installing the cables in your new machine, what is a good practice to check beforehand?");
        cablePointRoom2 = new PointQuizRoom("When connecting the cables in your machine, what guidelines should you follow?");
        computerPointRoom = new PointQuizRoom("When do you mount the motherboard in the case?");
        sortingPointRoom = new PointQuizRoom("Something");
        troubleshootPointRoom = new PointQuizRoom("Something");
        powerOutPointRoom = new PointQuizRoom("What do you do when you see a colored outlet?");
        powerOutPointRoom2 = new PointQuizRoom("What would you do if your electrical cable comes easily out of the plug?");
        powerOutPointRoom3 = new PointQuizRoom("Which set of tools require for a power outlet to be changed with?");

            // Exam Rooms
        exam1 = new PointQuizRoom("When do you mount the motherboard in the case?");
        exam2 = new PointQuizRoom("What do you do when you see a colored outlet?");
        exam3 = new PointQuizRoom("Before installing the cables in your new machine, what is a good practice to check beforehand?");

        // Answers
            // Right or Wrong
                // Soldering
        solderingCorrectRoom.addAnswer("You apply the solder directly on the iron", "Incorrect, you should heat the joint and apply the solder directly on the components", false);
        solderingCorrectRoom.addAnswer("You apply the solder directly on the joint", "Correct", true);
        solderingCorrectRoom.addAnswer("You let it melt on the iron", "Incorrect, you should heat the joint and apply the solder directly on the components", false);
                // Cable
        cableCorrectRoom.addAnswer("No, why should there? The cables are built to be bend so they can definitely take it!", "Incorrect", false);
        cableCorrectRoom.addAnswer("Yes, Even though the cables are built for usage,\ntheres still a chance they will fail on the long run,\nor even break in the building process under too much tension.", "Correct", true);
                // Computer
        computerCorrectRoom.addAnswer("Outwards away from the case.", "Correct", true);
        computerCorrectRoom.addAnswer("Inwards towards the case.", "Incorrect, that would only kill the power-supply", false);

            // Point giving
                // Soldering
        solderingPointRoom.addAnswer("Mix of tin and copper", "Correct", 100);
        solderingPointRoom.addAnswer("Mix of tin and lead", "It has been used before,\nbut today the alloy mix of tin and copper are used,\nmainly for health issues", 30);
        solderingPointRoom.addAnswer("Mix of copper and lead", "Incorrect", 0);
                // Cable
        cablePointRoom.addAnswer("Nope you dont need to check anything just smack it into the machine", "Incorrect", 0);
        cablePointRoom.addAnswer("Its a good idea to see if the cables are damaged from transit, but you dont need to care furthermore", "Almost, if you see cables that are broken in anyway, always asses the problem", 50);
        cablePointRoom.addAnswer("Its a good idea to check if the cables are damaged from transit,\nand also keep the tension as little as possible when connecting them to the machine for less chance of bending/breaking","Correct",100);
                // Cable 2
        cablePointRoom2.addAnswer(" Its a good idea to follow the guidelines, since otherwise i might need to replace my new hardware.\nBut i dont need an antistatic wristband since i dont generate static electricity!", "Almost", 50);
        cablePointRoom2.addAnswer("Its a good idea to follow the guidelines for your hardware,\nand keep an antistatic wristband on for no chance of shorting your hardware", "Correct", 100);
        cablePointRoom2.addAnswer("None, since its my machine and nobody can tell me what to do!", "Incorrect", 0);
                // Computer
        computerPointRoom.addAnswer("After installing the GPU.", "Incorrect, that is the last thing you do", 0);
        computerPointRoom.addAnswer("After installing the CPU, cooler and RAM.", "Correct", 100);
        computerPointRoom.addAnswer("Before installing anything on the motherboard.", "You can, but it only makes it more difficult", 50);

                // Power outlet
        powerOutPointRoom.addAnswer("Contact an electrician and the outlet fixed", "Correct", 100);
        powerOutPointRoom.addAnswer("No need to worry, use the outlet until it is cooked off.", "Incorrect, you should always be vary miscolored outlet", 0);
        powerOutPointRoom.addAnswer("Remove the outlet, and use it again even though it might seem risky", "Almost", 40);
                // Power outlet 2
        powerOutPointRoom2.addAnswer("I would keep continuing the sample, until something BIG happens", "Incorrect", 0);
        powerOutPointRoom2.addAnswer("I would fix the outlet and change it out with another", "Correct, though if its too advance, always contact professionals", 100);
        powerOutPointRoom2.addAnswer("I would try and use some basic tools, where i would just take the outlet out without safety gloves", "Hardly, safety comes first", 30);
                // Power outlet 3
        powerOutPointRoom3.addAnswer("Screwdriver, electrical tape, non-contact voltage rester", "Correct", 100);
        powerOutPointRoom3.addAnswer("Screwdriver, hammer and normal tape", "In some cases they can be used", 40);
        powerOutPointRoom3.addAnswer("Normal tape, hammer and plastic gloves", "Incorrect, though plastic gloves might be useful sometimes", 0);

            // Exam
        exam1.addAnswer("After installing the GPU.", "Incorrect", 0);
        exam1.addAnswer("Before installing anything on the motherboard.", "Almost", 50);
        exam1.addAnswer("After installing the CPU, cooler and RAM.", "Correct", 100);

        exam2.addAnswer("No need to worry, use the outlet until it is cooked off.", "Incorrect", 0);
        exam2.addAnswer("Contact an electrician and the outlet fixed", "Correct", 100);
        exam2.addAnswer("Remove the outlet, and use it again even though it might seem risky", "Almost", 40);

        exam3.addAnswer("Nope you dont need to check anything just smack it into the machine", "Incorrect", 0);
        exam3.addAnswer("Its a good idea to check if the cables are damaged from transit,\nand also keep the tension as little as possible when connecting them to the machine for less chance of bending/breaking", "Correct", 100);
        exam3.addAnswer("Its a good idea to see if the cables are damaged from transit, but you dont need to care furthermore", "Almost", 50);

        // Navigation
        introductionRoom.setExit("continue", playedBeforeRoom);
        playedBeforeRoom.setExit("yes", hubRoom);
        playedBeforeRoom.setExit("no", courseStartRoom);
        courseStartRoom.setExit("back", playedBeforeRoom);
            // Soldering room
        solderingInfoRoom.setExit("continue", solderingCorrectRoom);
        solderingInfoRoom.setExit("back", hubRoom);
        solderingCorrectRoom.setExit("continue", solderingPointRoom);
        solderingCorrectRoom.setExit("back", solderingInfoRoom);
        solderingPointRoom.setExit("back", solderingCorrectRoom);
        solderingPointRoom.setExit("hub", hubRoom);
            // Cable room
        cableInfoRoom.setExit("continue", cableCorrectRoom);
        cableInfoRoom.setExit("back", hubRoom);
        cableCorrectRoom.setExit("continue", cablePointRoom);
        cableCorrectRoom.setExit("back", cableInfoRoom);
        cablePointRoom.setExit("hub", hubRoom);
        cablePointRoom.setExit("back", cableCorrectRoom);
        cablePointRoom.setExit("continue", cablePointRoom2);
            // Cable room 2
        cablePointRoom2.setExit("back", cablePointRoom);
        cablePointRoom2.setExit("hub", hubRoom);
            // Computer
        computerInfoRoom.setExit("continue", computerCorrectRoom);
        computerInfoRoom.setExit("back", hubRoom);
        computerCorrectRoom.setExit("continue", computerPointRoom);
        computerCorrectRoom.setExit("back", computerInfoRoom);
        computerPointRoom.setExit("hub", hubRoom);
        computerPointRoom.setExit("back", computerCorrectRoom);
            // Sorting
        sortingInfoRoom.setExit("continue", sortingCorrectRoom);
        sortingInfoRoom.setExit("back", hubRoom);
        sortingCorrectRoom.setExit("continue", sortingPointRoom);
        sortingCorrectRoom.setExit("back", sortingInfoRoom);
        sortingPointRoom.setExit("hub", hubRoom);
        sortingPointRoom.setExit("back", sortingCorrectRoom);

            // Power outlet
        powerOutPointRoom.setExit("continue", powerOutPointRoom2);
        powerOutPointRoom.setExit("back", powerOutInfoRoom);
        powerOutPointRoom2.setExit("continue", powerOutPointRoom3);
        powerOutPointRoom2.setExit("hub", hubRoom);
        powerOutPointRoom2.setExit("back", powerOutPointRoom);
        powerOutPointRoom3.setExit("hub", hubRoom);
        powerOutPointRoom3.setExit("back", powerOutPointRoom2);
            // Test
        exam1.setTest(true);
        exam2.setTest(true);
        exam3.setTest(true);

        exam1.setSkipOnAnswer(true);
        exam2.setSkipOnAnswer(true);
        exam3.setSkipOnAnswer(true);

        // Hub Navigation
        hubRoom.setExit("soldering", solderingInfoRoom);
        hubRoom.setExit("cable", cableInfoRoom);
        hubRoom.setExit("computer", computerInfoRoom);
        hubRoom.setExit("sorting", sortingInfoRoom);
        hubRoom.setExit("troubleshoot", troubleshootInfoRoom);
        hubRoom.setExit("power", powerOutInfoRoom);

        // Exam Navigation
        hubRoom.setExit("exam", exam1);
        exam1.setExit("continue", exam2);
        exam2.setExit("continue", exam3);

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
