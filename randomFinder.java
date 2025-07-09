import java.util.Random;
import java.util.Scanner;

public class randomFinder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int nr, random;
		
		do {
			System.out.println("Give a number in the range 1-10: ");
			nr = sc.nextInt();
		} while(!(nr >= 1 && nr <= 10));
		
		do {
			random = r.nextInt(10)+1;
			System.out.println("Generated Number: " + random);
		} while(random != nr);
		
		sc.close();
	}

}
