public class Main {
    public static void main(String[] args) {
        InputManager.getInstance();
        GameManager gm = GameManager.getInstance();
        gm.play();
    }
}
