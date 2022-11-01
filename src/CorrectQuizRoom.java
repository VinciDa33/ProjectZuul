import javax.swing.text.html.Option;
import java.util.ArrayList;

public class CorrectQuizRoom extends QuizRoom{
    private ArrayList<Boolean> correct = new ArrayList<>();

    CorrectQuizRoom(String q, GameManager gm, InputManager im){
        question = q;
        this.gm = gm;
        this.input = im;
    }

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

    public void addAnswer(String answer, String response, boolean isCorrect){
        answers.add(answer);
        responses.add(response);
        correct.add(isCorrect);
    }
    @Override
    public void answer(int answer) {
        if (answer-1 >= correct.size() || answer-1 < 0){
            System.out.println("Unknown Answer!");
            return;
        }
        if (correct.get(answer-1) == true){
            System.out.println("[[ Correct ]]");
            System.out.println(responses.get(answer-1));
            questionCorrect = true;
        }
        else{
            System.out.println("[[ Wrong ]]");
            System.out.println(responses.get(answer-1));
        }
        questionAnswered = true;
    }

    @Override
    public void update() {
        if (questionAnswered && (questionCorrect || skipOnAnswer)){
            OptionPrinter.printHashmapOptions(exits);

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
