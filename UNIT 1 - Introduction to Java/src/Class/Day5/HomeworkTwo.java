package Class.Day5;

public class HomeworkTwo {
    public static void main(String[] args) {
        
        double length = 4.5;
        double width = 2.3;

        double area = width*length;
        double perimeter = (width+length)*2;

        double finalarea = Math.round(area*10);
        finalarea /= 10;
        double finalperimeter = Math.round(perimeter*10)/10;
        finalperimeter /= 10;

        System.out.println("The area of the rectangle is "+finalarea+". The perimeter of the rectangle is "+finalperimeter+".");

    }
}
