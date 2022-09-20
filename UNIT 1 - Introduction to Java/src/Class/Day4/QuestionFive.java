package Class.Day4;

public class QuestionFive {
    public static void main(String[] args) {
        double pennies = 8;
        double nickels = 2;
        double dimes = 1;
        double quarters = 7;
        double loonies = 1;
        double toonies = 24;

        double money = pennies*0.01 + nickels*0.05 + dimes*0.1 + quarters*0.25 + loonies + toonies*2;

        System.out.println("I have $" + money);

    }
}
