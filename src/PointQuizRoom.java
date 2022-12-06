import javafx.scene.media.AudioClip;

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

    @Override
    public void answerQuestion(int answer) {
        responseLabel.setText("\n[[ " + points.get(answer) + " points ]]\n\n" + responses.get(answer));
        if (points.get(answer) == 100) {
            questionCorrect = true;

            AudioClip correctSound = new AudioClip(this.getClass().getResource("Audio/CorrectSound.wav").toString());
            correctSound.play();
        }
        else {
            AudioClip incorrectSound = new AudioClip(this.getClass().getResource("Audio/IncorrectSound.wav").toString());
            incorrectSound.play();
        }

        if (isTest) {
            PointScore.addPoints(points.get(answer));
            GameManager.getInstance().updatePointScoreRoom();
        }
        questionAnswered = true;

        updateAnswerBox();
    }
}
