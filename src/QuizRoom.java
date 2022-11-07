import java.util.ArrayList;

public abstract class QuizRoom extends Room{
    String question;
    boolean skipOnAnswer;
    boolean questionCorrect;
    boolean questionAnswered;
    ArrayList<String> answers = new ArrayList<>();
    ArrayList<String> responses = new ArrayList<>();


    public void setSkipOnAnswer(boolean skipOnAnswer){
        this.skipOnAnswer = skipOnAnswer;
    }
    public abstract void answer(int answer);

    @Override
    public void onEnterRoom() {
        System.out.println("---------- Question ----------");
        System.out.println(question);
        System.out.println("\n---------- oooooooo ----------\n");

        //Prints every answer option for the user
        for (int i = 0; i < answers.size(); i++) {
            System.out.println("[" + (i+1) + "]: " + answers.get(i));
        }
        System.out.println("Write the number of the answer you wish to choose.");
    }
    @Override
    public void update() {
        if (questionAnswered && (questionCorrect || skipOnAnswer)){
            printExitOptions();

            String userInput = input.getNextLine();
            for (String key : exits.keySet()) {
                if (userInput.equals(key)){
                    gm.goToRoom(exits.get(userInput));
                    return;
                }
            }
            if (userInput.equals("Quit")) {
                gm.quitGame();
                return;
            }
            System.out.println("Unknown input!");
        }
        else{
            answer(input.getNextInt());
        }
    }
}