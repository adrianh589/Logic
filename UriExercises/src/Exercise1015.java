import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.0000");
		
		double x1 = Double.parseDouble(br.readLine()),
			   y1 = Double.parseDouble(br.readLine()),
		       x2 = Double.parseDouble(br.readLine()),
			   y2 = Double.parseDouble(br.readLine());
		
		double formula = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		
		System.out.println(df.format(formula));

	}

}
