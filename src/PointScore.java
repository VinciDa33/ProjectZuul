public class PointScore {
    private static int points;

    public static void addPoints(int pointScore){
        this.points += pointScore;
    }

    public static int getPoints(){
        return points;
    }
}
