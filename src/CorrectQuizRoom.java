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
       if (correct.get(answer)){
           responseLabel.setText("\n[Correct]\n\n"+responses.get(answer));
           questionCorrect = true;
       }
       else {
           responseLabel.setText("\n[Incorrect]\n\n"+responses.get(answer));
       }
       questionAnswered = true;
       updateAnswerBox();
    }
}
