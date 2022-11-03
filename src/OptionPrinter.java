import java.util.HashMap;

public class OptionPrinter {
    public static void printHashmapOptions(HashMap<String, Room> options) {
        System.out.println("\n-- What do you want to do? --");
        for (String key : options.keySet()) {
            System.out.println("* " + key.substring(0,1).toUpperCase() + key.substring(1, key.length()));
        }
        System.out.println("* " + "Quit");
    }
}
