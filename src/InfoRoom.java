public class InfoRoom extends Room{
    String description;

    public InfoRoom(String description) {
        this.description = description;
    }

    @Override
    public void OnEnterRoom() {
        System.out.println(description);
        System.out.println("_____ _____ _____ _____");

        String options = "";
        for (String key : exits.keySet()) {
            options += key + " : ";
        }
        System.out.println(options);
        System.out.println("What do you want to do?.\n>");
    }
}

