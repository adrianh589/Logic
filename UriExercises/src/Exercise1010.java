import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.00");
		
		String product1 = br.readLine();
		String product2 = br.readLine();
		
		String total1[] = product1.split(" ");
		String total2[] = product2.split(" ");
		
		double final1 = Double.parseDouble(total1[1]) * Double.parseDouble(total1[2]);
		double final2 = Double.parseDouble(total2[1]) * Double.parseDouble(total2[2]);
		
		System.out.println("VALOR A PAGAR: R$ "+df.format(final1+final2));
	}

}
