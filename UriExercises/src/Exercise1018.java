import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise1018 {


    public static void main(String[] args) throws IOException {

        //Buffered para captura de datos del sistema
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Se crea para mostrar las monedas escogidas
        ArrayList<Integer> monedero = new ArrayList<Integer>();

        //Monedas en el inventario, son infinitas
        int [] monedas = {1,2,5,10,20,50,100};

        int devueltas = lectorEnteros("Introduzca la cantidad de devueltas", br);

        //Genero las devueltas
        monedero = devueltero(monedas,monedero,br,devueltas);

        //Imprimo las monedas seleccionadas
        imprimirMonedas(monedero, monedas);
    }

    /**
     * Metodo que permite calcular las devueltas vorazmente
     * @param monedas
     * @param monedero
     * @param br
     * @param devueltas
     * @return
     */
    static ArrayList devueltero(int[] monedas, ArrayList monedero, BufferedReader br, int devueltas){
        int almacenado = 0;
        for (int i = monedas.length-1; i >=0 ; ) {
            if(monedas[i] > devueltas){//Preguntamos si la moneda mayor es mayor que las devueltas
                i--;//Si lo es, cambiara a la moneda anterior
            }else{//Si no es mayor
                almacenado += monedas[i];//Agregamos ese valor a la variable almacenado
                if(almacenado > devueltas){//Preguntamos si almacenado es mayor que las devueltas
                    almacenado -= monedas[i];//Si es mayor, le quita ese precio
                    i--;//y vuelve a la moneda anterior
                }else{
                    if (almacenado == devueltas){//Preguntamos si lo almacenado es igual a las devueltas
                        monedero.add(monedas[i]);//Agregamos la moneda
                        break;//y el problema esta resuelto
                    }else{
                        monedero.add(monedas[i]);// Si no es mayor, simplemente agrega la moneda
                    }
                }
            }
        }
        return monedero;
    }

    /**
     * Metodo que imprime las monedas seleccionadas
     * @param monedero
     */
    static void imprimirMonedas(ArrayList<Integer> monedero, int[] monedas){
        int pos = monedas.length-1;
        int billeteActual = monedas[pos];
        int cantidad = 0;

        for (int i = 0; i < monedero.size(); i++) {

            if(monedero.get(i) == billeteActual){
                cantidad++;
            }else{
                pos--;
                System.out.println(cantidad + " nota(s) de R$ "+billeteActual);
                billeteActual = monedas[pos];
                cantidad = 0;
                cantidad++;
            }

        }
    }

    /**
     * Metodo que evita que el usuario ingrese letras o numeros invalidos
     * @param mensaje Mensaje que se imprimira
     * @return La variable entera
     * @throws IOException Excepcion para el Buffered
     */
    static int lectorEnteros(String mensaje, BufferedReader br) throws IOException {
        int variable = 0;
        do {
            try {
                System.out.println( mensaje );
                variable = Integer.parseInt(br.readLine());
            }catch(NumberFormatException e) {System.out.println("Numero invalido");}
        }while(variable == 0 || variable < 1);
        return variable;
    }


}
