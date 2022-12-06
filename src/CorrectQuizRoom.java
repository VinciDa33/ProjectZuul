import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.ArrayList;

public class CorrectQuizRoom extends QuizRoom{
    private ArrayList<Boolean> correct = new ArrayList<>();

    public CorrectQuizRoom(String roomDataPath){
        super(roomDataPath);
    }


    public void addAnswer(String answer, String response, boolean isCorrect){
        answers.add(answer);
        responses.add(response);
        correct.add(isCorrect);
    }
    @Override
    public void answerQuestion(int answer) {
        if (correct.get(answer)) {
            responseLabel.setText("\n[[ "+ FileReader.loadFile("Misc/Correct") + " ]]\n\n" + FileReader.loadFile(responses.get(answer)));
            questionCorrect = true;

            AudioClip correctSound = new AudioClip(this.getClass().getResource("Audio/CorrectSound.wav").toString());
            correctSound.play();
        }
        else {
            responseLabel.setText("\n[[ " + FileReader.loadFile("Misc/Incorrect") + " ]]\n\n" + FileReader.loadFile(responses.get(answer)));

            AudioClip incorrectSound = new AudioClip(this.getClass().getResource("Audio/IncorrectSound.wav").toString());
            incorrectSound.play();
        }

        questionAnswered = true;

        updateAnswerBox();
    }
}
