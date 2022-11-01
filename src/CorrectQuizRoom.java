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
        System.out.println(question);
    }

    public void addAnswer(String answer, String response, boolean isCorrect){
        answers.add(answer);
        responses.add(response);
        correct.add(isCorrect);
    }
    @Override
    public void answer(int answer) {
        if (answer-1 >= correct.size()){
            System.out.println("Unknown Answer");
            return;
        }
        if (correct.get(answer-1) == true){
            System.out.println("Correct");
            System.out.println(responses.get(answer-1));
            questionDone = true;
        }
        else{
            System.out.println("Wrong");
            System.out.println(responses.get(answer-1));
        }
        questionAnswered = true;
    }

    @Override
    public void update() {
        if (questionAnswered && (questionDone || skipOnAnswer)){
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
        else{
            answer(input.getNextInt());
        }
    }
}
