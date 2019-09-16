import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1013 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String numbers[] = br.readLine().split(" ");
		int a = Integer.parseInt(numbers[0]),
			b = Integer.parseInt(numbers[1]),
			c = Integer.parseInt(numbers[2]), 
			MaiorAB = (a + b + Math.abs( a - b ) ) / 2,
			MaiorBC = (MaiorAB + c + Math.abs( MaiorAB - c ) ) / 2,
			solution = (MaiorAB < MaiorBC) ? (solution = MaiorBC) : (solution = MaiorAB);
			
		System.out.println(solution + " eh o maior");
	}

}
