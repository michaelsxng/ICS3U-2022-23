package Day1;

public class TestReview {
    public static void main(String[] args) {
        int num = 72341;

        int num1 = num/10000;
        int num2 = num%1000/100;
        int num3 = num%10;


        double result = Math.sqrt(num1+num2+num3);
        System.out.println(result);
        
    }
}
