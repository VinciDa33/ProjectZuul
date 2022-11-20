import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class QuizRoom extends Room{
    String question;
    boolean skipOnAnswer;
    boolean questionCorrect;
    boolean questionAnswered;
    ArrayList<String> answers = new ArrayList<>();
    ArrayList<String> responses = new ArrayList<>();

    //GUI RELATED VARIABLES
    Label responseLabel;
    VBox answerBox;

    public void setSkipOnAnswer(boolean skipOnAnswer){
        this.skipOnAnswer = skipOnAnswer;
    }
    public abstract void answerQuestion(int answer);

    @Override
    public void onEnterRoom() {
        questionCorrect = false;
        questionAnswered = false;

        //REPLACED BY GUI
        /*
        System.out.println("---------- Question ----------");
        System.out.println(question);
        System.out.println("\n---------- oooooooo ----------\n");

        //Prints every answer option for the user
        for (int i = 0; i < answers.size(); i++) {
            System.out.println("[" + (i+1) + "]: " + answers.get(i));
        }
        System.out.println("[0] Skip Question: ");
        System.out.println("Write the number of the answer you wish to choose.");
         */

        GUIManager.setScene(createGUI());
    }

    //REPLACED BY GUI - EVENT BASED EXECUTION
    /*
    @Override
    public void update() {
        if (questionAnswered && (questionCorrect || skipOnAnswer)){
            printExitOptions();

            String userInput = InputManager.getInstance().getNextLine();
            if (exits.containsKey(userInput)) {
                GameManager.getInstance().goToRoom(exits.get(userInput));
                return;
            }
            if (userInput.equals("quit")) {
                //GameManager.getInstance().quitGame();
                return;
            }
            System.out.println("Unknown input!");
        }
        else{
            answer(InputManager.getInstance().getNextInt());
        }
    }
     */

    @Override
    public Scene createGUI() {
        //Setting up the main boxes for holding components
        HBox horBox = new HBox();
        horBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));

        VBox leftBox = new VBox();
        leftBox.setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));
        VBox rightBox = new VBox();
        rightBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), CornerRadii.EMPTY, Insets.EMPTY)));

        //The label with the description
        Label descriptionLabel = new Label("--- Question ---\n\n" + question);
        descriptionLabel.setTextFill(Color.rgb(220, 220, 220));
        leftBox.getChildren().add(descriptionLabel);

        responseLabel = new Label();
        responseLabel.setTextFill(Color.rgb(220, 220, 220));
        leftBox.getChildren().add(responseLabel);

        //Creates a label and a button for each answer option in the room
        for (int i = 0; i < answers.size(); i++) {
            Label answerOption = new Label(answers.get(i));
            answerOption.setTextFill(Color.rgb(220, 220, 220));
            rightBox.getChildren().add(answerOption);

            int index = i;
            Button button = new Button("Answer [" + i + "]");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    answerQuestion(index);
                }
            });
            rightBox.getChildren().add(button);
        }

        //The quit game button
        Button exitButton = new Button("Quit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GUIManager.quitGame();
            }
        });
        rightBox.getChildren().add(exitButton);


        //Adding components to main component and returning scene
        horBox.getChildren().add(leftBox);
        horBox.getChildren().add(rightBox);

        answerBox = rightBox;
        return new Scene(horBox, GUIManager.getSizeX(), GUIManager.getSizeY());
    }

    public void updateAnswerBox() {
        answerBox.getChildren().clear();

        if (questionCorrect || (questionAnswered && skipOnAnswer)) {
            //Creates a button for each exit option in the room
            for (String key : exits.keySet()) {
                Button button = new Button(key);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        GameManager.getInstance().goToRoom(exits.get(key));
                    }
                });
                answerBox.getChildren().add(button);
            }
        }
        else {
            //Creates a label and a button for each answer option in the room
            for (int i = 0; i < answers.size(); i++) {
                Label answerOption = new Label(answers.get(i));
                answerOption.setTextFill(Color.rgb(220, 220, 220));
                answerBox.getChildren().add(answerOption);

                int index = i;
                Button button = new Button("Answer [" + i + "]");
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        answerQuestion(index);
                    }
                });
                answerBox.getChildren().add(button);
            }
        }

        //The quit game button
        Button exitButton = new Button("Quit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GUIManager.quitGame();
            }
        });
        answerBox.getChildren().add(exitButton);
    }
}