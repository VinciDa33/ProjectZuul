public class PointScore {
    private static int points;

    public static void addPoints(int pointScore){
        points += pointScore;
    }

    public static int getPoints(){
        return points;
    }

    public static void printScore(){
        System.out.println(points);
    }
}
