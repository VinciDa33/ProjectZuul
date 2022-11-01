public class InfoRoom extends Abstract Room{
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
        System.out.println("Unkown error!");


    }

}
