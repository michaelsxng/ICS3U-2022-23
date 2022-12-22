package Day3;


public class NestedLoops {
    public static void main(String[] args) {
        // box(6, 5);
        framingSquares(3,4,1,2);
}

    private static void framingSquares(int m, int n, int p, int q) {
        for (int j = 0; j < q; j++){
            for (int i = 0; i < 2*q+2*p+n; i++) {
                System.out.print("#");
            }
            System.out.println();
        }

        


            // Top matting
        for (int i = 0; i < q; i++) {
            System.out.print("#");
        }
        for (int i = 0; i < 2*p + n; i++) {
            System.out.print("+");
        }
        for (int i = 0; i < q; i++) {
            System.out.print("#");
        }
        System.out.println();



        for (int j = 0; j < m; j++) {
            for (int i = 0; i < q; i++) {
                System.out.print("#");
            }
            for (int i = 0; i < p; i++) {
                System.out.print("+");
            }
            for (int i = 0; i < n; i++) {
                System.out.print(".");
            }
            for (int i = 0; i < p; i++) {
                System.out.print("+");
            }
            for (int i = 0; i < q; i++) {
                System.out.print("#");
            }
           System.out.println();
        }



        for (int i = 0; i < q; i++) {
            System.out.print("#");
        }
        for (int i = 0; i < 2*p + n; i++) {
            System.out.print("+");
        }
        for (int i = 0; i < q; i++) {
            System.out.print("#");
        }
        System.out.println();



        for (int j = 0; j < q; j++){
            for (int i = 0; i < 2*q+2*p+n; i++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }


    








    private static void box(int width, int height) {
        for (int row = 0; row < height; row++){

            for(int cols = 0; cols < width; cols++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
