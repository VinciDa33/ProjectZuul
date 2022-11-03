import java.util.ArrayList;

public class PointQuizRoom extends QuizRoom{
    private ArrayList<Integer> points = new ArrayList<>();
    boolean isTest = false;
    PointQuizRoom(String question, GameManager gm, InputManager im){
        this.question = question;
        this.gm = gm;
        this.input = im;
    }


    public void addAnswer(String answer, String response, int score){
        answers.add(answer);
        responses.add(response);
        points.add(score);
    }
    @Override
    public void answer(int answer) {
        if (answer == 0) {
            System.out.println("[[ Not Answered ]]");
            System.out.println("[[ If you do not know the answer, try having another look at the learning material. ]]");
            questionCorrect = true;
        }
        if (answer-1 >= points.size() || answer-1 < 0){
            System.out.println("Unknown Answer!");
            return;
        }
        if (points.get(answer-1) == 100){
            System.out.println("[[ 100 points]]");
            System.out.println(responses.get(answer-1));
            questionCorrect = true;
        }
        else{
            System.out.println("[[ "+points.get(answer-1)+" points ]]");
            System.out.println(responses.get(answer-1));
        }

        if (isTest) {
            PointScore.addPoints(points.get(answer - 1));
        }
        questionAnswered = true;
    }

    public void SetTest(boolean b) {
        isTest = b;
    }

}
