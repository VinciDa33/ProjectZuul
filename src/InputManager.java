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
        return reader.nextInt();
    }
    public char getNextChar(){
        return reader.nextLine().charAt(0);
    }
    public double getNextDouble(){
        return reader.nextDouble();
    }
}
//Array og Arraylisten er to anderledes ting. Engang, hvor Array er oprettet, kan den ikke ændre mængden af pladserne eller array.længden.
//Hvorimod hvis Arraylisten kan ændre sit liste.
//Begge ting er to forskellige ting, med forskellige funktion men med samme hensigt.