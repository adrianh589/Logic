import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1004  {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		int A = Integer.parseInt(br.readLine()), B = Integer.parseInt(br.readLine()), PROD = A * B;
		System.out.println("PROD = "+PROD);
	}
}
