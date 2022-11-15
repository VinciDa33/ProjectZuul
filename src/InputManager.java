import java.util.Scanner;

public class InputManager {
    private static InputManager instance;

    private Scanner reader;

    private InputManager(){
        reader = new Scanner(System.in);
    }

    public String getNextLine(){
        return reader.nextLine().toLowerCase();
    }
    public int getNextInt(){
        String temp = reader.nextLine();
        try {
            return Integer.parseInt(temp);
        }
        catch (Exception e){
            return -101;
        }
    }
    public char getNextChar(){
        return reader.nextLine().toLowerCase().charAt(0);
    }

    public static InputManager getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new InputManager();
        return instance;
    }
}
