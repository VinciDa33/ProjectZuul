import java.util.ArrayList;

public abstract class QuizRoom extends Room{
    private String question;
    private boolean skipOnAnswer;
    private ArrayList<String> answers;
    private ArrayList<String> responses;

    public void setSkipOnAnswer(boolean skipOnAnswer){
        this.skipOnAnswer = skipOnAnswer;
    }
    public abstract void answer(String answer);
}