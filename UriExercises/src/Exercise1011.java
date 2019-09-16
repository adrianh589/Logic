import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.000");
		int R = Integer.parseInt(br.readLine());
		double pi = 3.14159, formula = (4/3.0) * pi * Math.pow(R, 3);
		System.out.println("VOLUME = "+df.format(formula));
	}

}
