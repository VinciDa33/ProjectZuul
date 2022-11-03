import javax.swing.text.html.Option;
import java.util.ArrayList;

public class CorrectQuizRoom extends QuizRoom{
    private ArrayList<Boolean> correct = new ArrayList<>();

    CorrectQuizRoom(String question, GameManager gm, InputManager im){
        this.question = question;
        this.gm = gm;
        this.input = im;
    }

    public void addAnswer(String answer, String response, boolean isCorrect){
        answers.add(answer);
        responses.add(response);
        correct.add(isCorrect);
    }
    @Override
    public void answer(int answer) {
        if (answer == 0) {
            System.out.println("[[ Not Answered ]]");
            System.out.println("[[ If you do not know the answer, try having another look at the learning material. ]]");
            questionCorrect = true;
        }
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
}
