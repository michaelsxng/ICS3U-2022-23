package Class.Day5;

import java.util.Scanner;

public class HomeworkNine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Number of items sold: ");
        double x = in.nextDouble();

        double money = x*0.27;

        System.out.println("The ammount of pay due is "+ money);

        in.close();
    }
}
