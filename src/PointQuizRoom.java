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
        //REPLACED BY GUI
        /*
        if (answer == 0) {
            System.out.println("[[ Not Answered ]]");
            System.out.println("[[ If you do not know the answer, try having another look at the learning material. ]]");
            questionCorrect = true;
        }
        if (answer-1 >= points.size() || answer-1 < 0){
            System.out.println("Unknown Answer!");
            return;
        }

         */

        responseLabel.setText("\n[[ " + points.get(answer) + " points ]]\n\n" + responses.get(answer));
        if (points.get(answer) == 100) {
            questionCorrect = true;
        }

        //REPLACED BY GUI
        //System.out.println("[[ "+points.get(answer-1)+" points ]]");
        //System.out.println(responses.get(answer-1));

        if (isTest) {
            PointScore.addPoints(points.get(answer));
        }
        questionAnswered = true;

        updateAnswerBox();
    }
}
