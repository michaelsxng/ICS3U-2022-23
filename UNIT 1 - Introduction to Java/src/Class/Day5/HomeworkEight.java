package Class.Day5;

import java.util.Scanner;

public class HomeworkEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Give a positive number: ");
        double x = in.nextDouble();

        double squareroot = Math.sqrt(x);
        double square = Math.pow(x, 2);

        System.out.println("The square of the number is "+square+". 9The square root of the number is "+squareroot);

        in.close();
    }
}
