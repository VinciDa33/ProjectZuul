import java.util.ArrayList;

public class QuizRoom extends Room {
    String question;
    boolean answeredCorrect = false;

    ArrayList<String> answers = new ArrayList<String>();
    ArrayList<Boolean> correct = new ArrayList<Boolean>();
    ArrayList<String> responses = new ArrayList<String>();

    public QuizRoom(String question) {
        this.question = question;
    }

    public void AddAnswer(String answer, boolean isCorrect, String response) {
        answers.add(answer);
        correct.add(isCorrect);
        responses.add(response);
    }

    public void Answer(String answer) {
        int parsed = 0;
        try {
            parsed = Integer.parseInt(answer);
        }
        catch (Exception ignored) { }

        for (int i = 0; i < answers.size(); i++) {
            if (answer.equals(answers.get(i)) || parsed == i+1) {
                System.out.println(responses.get(i));
                if (correct.get(i)) {
                    answeredCorrect = true;

                    String options = "";
                    for (String key : exits.keySet()) {
                        options += key + " : ";
                    }
                    System.out.println(options);
                }
                return;
            }
        }
        System.out.println("Unknown answer");
    }

    @Override
    public void OnEnterRoom() {
        System.out.println("\n--- QUESTION ---");
        System.out.println(question + "\n");

        for (int i = 0; i < answers.size(); i++) {
            System.out.println((i+1) + ". " + answers.get(i));
        }
        System.out.println("Answer below:\n");
    }

    public boolean HasAnsweredCorrect() {
        return answeredCorrect;
    }
}
