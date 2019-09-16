import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1008 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.00");
		int numberEmployee = Integer.parseInt(br.readLine()), 
			workHours = Integer.parseInt(br.readLine());
		double amountRecibed =  Double.parseDouble(br.readLine()) * workHours;
		
		System.out.println("NUMBER = "+numberEmployee+"\nSALARY = U$ "+df.format(amountRecibed));
	}

}
