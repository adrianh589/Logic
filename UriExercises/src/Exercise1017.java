import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercise1017 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("0.000");
        double tiempo = Integer.parseInt(br.readLine()), velocidad = Integer.parseInt(br.readLine()),
                litros = ( tiempo * velocidad ) / 12;
        System.out.println(df.format(litros));
    }

}
