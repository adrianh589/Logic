import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1014 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.000");
		
		int X = Integer.parseInt(br.readLine());
		double Y = Double.parseDouble(br.readLine());
		
		System.out.println(df.format(X/Y)+" km/l");
	}

}
