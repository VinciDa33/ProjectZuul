import java.util.Scanner;

public class InputManager {
    private Scanner reader;

    public InputManager(){
        reader = new Scanner(System.in);
    }

    public String getNextLine(){
        return reader.nextLine();
    }
    public int getNextInt(){
        String temp = reader.nextLine();
        try {
            return Integer.parseInt(temp);
        }
        catch (Exception e){
            return -100;
        }
    }
    public char getNextChar(){
        return reader.nextLine().charAt(0);
    }
    public double getNextDouble(){
        return reader.nextDouble();
    }
}
