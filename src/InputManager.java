import java.util.Scanner;

public class InputManager {
    Scanner reader;

    public InputManager() {
        reader = new Scanner(System.in);
    }

    public String getNextLine() {
        return reader.nextLine();
    }

    public int getNextInt() {
        return reader.nextInt();
    }

    public double getNextDouble() {
        return reader.nextDouble();
    }

    public char getNextChar() {
        return reader.nextLine().charAt(0);
    }


}
