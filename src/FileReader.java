import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private static boolean inDanish = true;

    public static String loadFile(String fileName) {
        File file = new File("src/TextFiles/" + fileName + ".txt");
        if (!file.exists())
            return "File not found";

        try {
            Scanner reader = new Scanner(file);
            String text = "";

            while (reader.hasNextLine()) {
                text += reader.nextLine();
                if (reader.hasNextLine())
                    text += "\n";
            }
            reader.close();

            String[] languages = text.split("~");

            if (inDanish)
                return languages[0];
            return languages[1];
        }
        catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
            return "File not found";
        }
    }

    public static void toggleLanguage() {
        inDanish = !inDanish;
        GameManager.getInstance().getActiveRoom().onEnterRoom();
    }
}
