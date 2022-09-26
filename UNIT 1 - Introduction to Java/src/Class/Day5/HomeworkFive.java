package Class.Day5;

public class HomeworkFive {
    public static void main(String[] args) {
        int wins = 110;
        int loses = 44;

        double percent = (double)110/(wins+loses);
        percent *= 100000;

        double percentage = Math.round(percent);
        percentage /= 1000;

        System.out.println("The NewYorkYankees win percentage is "+ percentage);

    }
}
