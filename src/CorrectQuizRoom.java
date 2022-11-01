import java.util.ArrayList;

public class CorrectQuizRoom extends QuizRoom{
    private ArrayList<Boolean> correct;

    CorrectQuizRoom(){}

    public void addAnswer(String answer, String response, boolean isCorrect){
        answers.add(answer);
        responses.add(response);
        correct.add(isCorrect);
    }
    @Override
    public void answer(String answer) {

    }

    @Override
    public void onEnterRoom() {

    }

    @Override
    public void update() {

    }
}
