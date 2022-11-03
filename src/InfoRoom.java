public class InfoRoom extends Room{
    String description;

    public InfoRoom(String description, GameManager gm, InputManager im) {
        this.description = description;
        this.gm = gm;
        this.input = im;
    }

    @Override
    public void onEnterRoom(){
        System.out.println("---------- Learning ----------");
        System.out.println(description);
        System.out.println("\n---------- oooooooo ----------");    }

    @Override
    public void update(){
        OptionPrinter.printHashmapOptions(exits);

        String userInput = input.getNextLine();
        if (exits.containsKey(userInput)) {
            gm.goToRoom(exits.get(userInput));
            return;
        }
        if (userInput.equals("quit")) {
            gm.quitGame();
            return;
        }

        System.out.println("Unknown input!");


    }

}
