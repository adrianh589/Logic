import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		DecimalFormat d = new DecimalFormat("0.0000");
		double radio = Double.parseDouble(br.readLine()), pi = 3.14159, area = pi * Math.pow(radio, 2);
		System.out.println("A="+d.format(area));
	}

}
