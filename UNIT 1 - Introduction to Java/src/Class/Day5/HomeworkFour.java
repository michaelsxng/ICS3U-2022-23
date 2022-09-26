package Class.Day5;

public class HomeworkFour {
    public static void main(String[] args) {
        int seconds = 365*24*60*60;
        double lightspeed = 3*Math.pow(10, 8);

        double distance = seconds*lightspeed;

        System.out.println("The distance that a light beam can travel in one year is "+distance+" meters.");

    }
}
