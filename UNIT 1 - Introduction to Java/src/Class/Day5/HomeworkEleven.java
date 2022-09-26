package Class.Day5;

import java.util.Scanner;

public class HomeworkEleven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Give the mass and speed of the object: ");

        double m = in.nextDouble();
        double v = in.nextDouble();

        double kineticenergy = 0.5*m*(v*v);

        System.out.println("The objects kinetic energy is: " + kineticenergy);

        in.close();

    }
}
