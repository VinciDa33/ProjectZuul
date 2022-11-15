public class InfoRoom extends Room{
    String description;

    public InfoRoom(String description) {
        this.description = description;
    }

    @Override
    public void onEnterRoom(){
        System.out.println("---------- Learning ----------");
        System.out.println(description);
        System.out.println("\n---------- oooooooo ----------");    }

    @Override
    public void update(){
        printExitOptions();

        String userInput = InputManager.getInstance().getNextLine();
        if (exits.containsKey(userInput)) {
            GameManager.getInstance().goToRoom(exits.get(userInput));
            return;
        }
        if (userInput.equals("quit")) {
            GameManager.getInstance().quitGame();
            return;
        }

        System.out.println("Unknown input!");


    }

}
