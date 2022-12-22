package Day2;

public class NestedIfStatements {
    public static void main(String[] args) {
        //nested means inside somthing
        // nested if statements - an if statement inside an if statement

        boolean isRed = true;
        boolean isBig = true;

        int x = 7;
        int y = 8;

        if (x>8) {
            if (isRed)
                y++;
        } else {
            y--;
        }

        // System.out.println(y);

        if (x>8 && isRed) {
            y++;
        } else {
            y--;
        }
    }
}
