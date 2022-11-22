import javafx.scene.Scene;

import java.util.ArrayList;

public class PointQuizRoom extends QuizRoom{
    private ArrayList<Integer> points = new ArrayList<>();
    private boolean isTest = false;

    PointQuizRoom(String question){
        this.question = question;
    }


    public void addAnswer(String answer, String response, int score){
        answers.add(answer);
        responses.add(response);
        points.add(score);
    }

    public void setTest(boolean b) {
        isTest = b;
    }
    public boolean isTest() {
        return isTest;
    }

    @Override
    public void answerQuestion(int answer) {
        responseLabel.setText("\n [Points: "+points.get(answer)+"]\n\n"+responses.get(answer));

        if (points.get(answer) == 100){
            questionCorrect = true;
        }

        if (isTest) {
            PointScore.addPoints(points.get(answer - 1));
        }
        questionAnswered = true;
        updateAnswerBox();
    }
}
