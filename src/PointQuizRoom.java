import java.util.ArrayList;

public class PointQuizRoom extends QuizRoom{
    private ArrayList<Integer> points = new ArrayList<>();

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
        if (answer-1 >= points.size() || answer-1 < 0){
            System.out.println("Unknown Answer!");
            return;
        }
        if (points.get(answer-1) == 100){
            System.out.println("[[ 100 points ]]");
            System.out.println(responses.get(answer-1));
            questionCorrect = true;
        }
        else{
            System.out.println("[[ "+points.get(answer-1)+" points ]]");
            System.out.println(responses.get(answer-1));
        }
        PointScore.addPoints(points.get(answer-1));
        questionAnswered = true;
    }

}
