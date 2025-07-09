import java.util.Scanner;

public class abcContained {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string;
        System.out.println("Enter a string: ");
        string = sc.nextLine();

        String new_string = "";

        for(int i = 1; i < string.length()-1; i++) {
            new_string += string.charAt(i);
        }

        if(new_string.contains("abc")) {
            System.out.println("The given string contains 'abc' in the middle!");
        } else {
            System.out.println("The given string does not contain 'abc' in the middle!");
        }
    }
}
