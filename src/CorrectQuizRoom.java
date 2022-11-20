import javafx.scene.Group;
import javafx.scene.Scene;

import java.util.ArrayList;

public class CorrectQuizRoom extends QuizRoom{
    private ArrayList<Boolean> correct = new ArrayList<>();

    CorrectQuizRoom(String question){
        this.question = question;
    }

    public void addAnswer(String answer, String response, boolean isCorrect){
        answers.add(answer);
        responses.add(response);
        correct.add(isCorrect);
    }
    @Override
    public void answerQuestion(int answer) {
        /*
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
         */

        if (correct.get(answer)) {
            responseLabel.setText("\n[[ CORRECT ]]\n\n" + responses.get(answer));
            questionCorrect = true;
        }
        else {
            responseLabel.setText("\n[[ INCORRECT ]]\n\n" + responses.get(answer));
        }

        questionAnswered = true;

        updateAnswerBox();
    }
}
