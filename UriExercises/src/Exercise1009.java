import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		DecimalFormat df = new DecimalFormat("0.00");
		
		String nameEmployee = br.readLine();
		double fixedSalary = Double.parseDouble(br.readLine()), totalSales = Double.parseDouble(br.readLine())*0.15;
		
		System.out.println("TOTAL = R$ "+(df.format(fixedSalary+totalSales)));

	}

}
