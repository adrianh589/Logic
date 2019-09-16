import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.000");
		
		String numbers[] = br.readLine().split(" ");
		double A = Double.parseDouble(numbers[0]), B = Double.parseDouble(numbers[1]), C = Double.parseDouble(numbers[2]), pi = 3.14159;
		
		System.out.println("TRIANGULO: "+df.format(A * C / 2));
		System.out.println("CIRCULO: "+df.format(pi * Math.pow(C, 2)));
		System.out.println("TRAPEZIO: "+df.format( ( (A + B) * C)/2 ) );
		System.out.println("QUADRADO: "+df.format(B * B));
		System.out.println("RETANGULO: "+df.format(A * B));
	}

}
