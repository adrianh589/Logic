import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Exercise1001 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int X = A + B;
		
		sc.close();
		
		System.out.println("X = " + X);

	}

}
