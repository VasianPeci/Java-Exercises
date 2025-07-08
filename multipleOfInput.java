import java.util.Scanner;

public class multipleOfInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int n1 = sc.nextInt();

        System.out.println("Enter second number: ");
        int n2 = sc.nextInt();

        if(n1 % n2 == 0) {
            System.out.println("Number " + n1 + " is a multiple of " + n2 + ".");
        } else {
            System.out.println("Number " + n1 + " is not a multiple of " + n2 + ".");
        }

        sc.close();
    }
}
