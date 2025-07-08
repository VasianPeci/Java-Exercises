import java.util.Scanner;

public class maxDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();

        int maxDivisor = 1;

        int limit = Math.min(n1, n2);
        for(int i = 1; i <= limit; i++) {
            if(n1 % i == 0 && n2 % i == 0) {
                maxDivisor = i;
            }
        }

        System.out.println("Max common divisor is: " + maxDivisor);
        sc.close();
    }
}
