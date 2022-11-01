public class InfoRoom extends Room{
    String description;

    @Override
    public void onEnterRoom(){
        System.out.println(description);


    }

    @Override
    public void update(){
        String userInput = input.getNextLine();
        for ( String key : exits.keySet() ){
            if (userInput.equals(key)){
                gm.goToRoom(exits.get(userInput));
                return;
            }
        }
        if (userInput.equals("Quit"))
            gm.quitGame();

        System.out.println("Unknown input!");


    }

}
