import javafx.scene.media.AudioClip;

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
        if (correct.get(answer)) {
            responseLabel.setText("\n[[ CORRECT ]]\n\n" + responses.get(answer));
            questionCorrect = true;

            AudioClip correctSound = new AudioClip(this.getClass().getResource("Audio/CorrectSound.wav").toString());
            correctSound.play();
        }
        else {
            responseLabel.setText("\n[[ INCORRECT ]]\n\n" + responses.get(answer));

            AudioClip incorrectSound = new AudioClip(this.getClass().getResource("Audio/IncorrectSound.wav").toString());
            incorrectSound.play();
        }

        questionAnswered = true;

        updateAnswerBox();
    }
}
