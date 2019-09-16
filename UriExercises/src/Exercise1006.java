import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1006 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.0");
		double A = Double.parseDouble(br.readLine())*2, B = Double.parseDouble(br.readLine())*3, C = Double.parseDouble(br.readLine())*5,MEDIA = (A+B+C)/(2+3+5);
		System.out.println("MEDIA = "+df.format(MEDIA));

	}

}
