import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.0000");

        double[] primerPunto = punto(br),
                 segundoPunto = punto(br);
        double formula = Math.sqrt( Math.pow(segundoPunto[0] - primerPunto[0], 2) + Math.pow(segundoPunto[1] - primerPunto[1], 2) );
		System.out.println(df.format(formula));

	}

	static double[] punto(BufferedReader br) throws IOException {
        String[] capturar = br.readLine().split(" ");
        double[] xy = {Double.parseDouble(capturar[0]),  Double.parseDouble(capturar[1])};
        return xy;
    }

}
