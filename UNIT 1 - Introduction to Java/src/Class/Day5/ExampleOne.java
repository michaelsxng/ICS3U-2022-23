package Class.Day5;

import java.util.Scanner;

public class ExampleOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        double radius;

        System.out.print("Please enter the radius: ");
        radius = in.nextDouble();

        double area = Math.PI*radius*radius;

        System.out.println("The area of the cricle of radius " + radius + " is: " + area);

        in.close();

    }
}
