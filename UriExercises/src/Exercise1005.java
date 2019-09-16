import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1005 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.00000");
		double A = Double.parseDouble(br.readLine())*3.5, B = Double.parseDouble(br.readLine())*7.5, MEDIA = (A+B)/(3.5+7.5);
		System.out.println("MEDIA = "+df.format(MEDIA));

	}

}
