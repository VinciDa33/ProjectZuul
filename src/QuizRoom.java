import java.util.ArrayList;

public abstract class QuizRoom extends Room{
    String question;
    boolean skipOnAnswer;
    boolean questionCorrect;
    boolean questionAnswered;
    ArrayList<String> answers = new ArrayList<>();
    ArrayList<String> responses = new ArrayList<>();


    public void setSkipOnAnswer(boolean skipOnAnswer){
        this.skipOnAnswer = skipOnAnswer;
    }
    public abstract void answer(int answer);
}