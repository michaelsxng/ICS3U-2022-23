package Class.Day5;

import java.util.Scanner;

public class HomeworkTen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Give the length and then the width of the rectangle: ");
        double x = in.nextDouble();
        double y = in.nextDouble();
        double area = x*y;
        double perimeter = (x+y)*2;
        System.out.println("The rectangles area is "+area+". The rectangles perimeter is "+perimeter);
        in.close();
    }
}
