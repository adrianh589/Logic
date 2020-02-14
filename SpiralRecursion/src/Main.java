import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Introduzca la dimension de la matriz: ");
        int length = Integer.parseInt(br.readLine());
        int[][] matrix = fillRandomMatrix(length );
        showMatrix(matrix);
        try {
            printRecursiveSpiral(matrix);//Print in spiral form using recursion
        }catch (Exception e){
            System.out.println("\nLa matriz es par, por lo tanto no se puede dejar vacia");
        }
    }


    /**
     * Function to fill the matrix with random numbers
     *
     * @param length
     * @return
     */
    static int[][] fillRandomMatrix(int length) {
        Random rd = new Random();
        int matrix[][] = new int[length][length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = rd.nextInt(99);
            }
        }
        return matrix;
    }

    /**
     * Function to print a matrix
     *
     * @param matrix
     */
    static void showMatrix(int matrix[][]) {
        System.out.println("Matriz original: \n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]>=0 && matrix[i][j] <= 9 ) {
                    System.out.print("[0"+matrix[i][j] + "]");
                }else
                    System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    static void printRecursiveSpiral(int[][] matrix){
        if(matrix.length == 1) {//base case
            System.out.println(matrix[0][0]);
        }else {
            printLeftRight(matrix);
            matrix = deleteRow(matrix);

            printUpBottom(matrix);
            matrix = deleteColumn(matrix);

            printRightLeft(matrix);
            matrix = deleteReverseRow(matrix);

            printBottomUp(matrix);
            matrix = deleteReverseColumn(matrix);

            printRecursiveSpiral(matrix);//Recursion
        }
    }

    static void printLeftRight(int[][] matrix){
        for (int h = 0; h < matrix.length; h++) {
            System.out.print(matrix[0][h]+" ");
        }
    }

    static int[][] deleteRow(int[][] matrix){
        int[][] aux = new int[matrix.length-1][matrix[0].length];
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                aux[i][j] = matrix[i+1][j];
            }
        }
        return aux;
    }

    static void printUpBottom(int[][] matrix) {
        for (int y = 0; y < matrix.length; y++) {
            System.out.print(matrix[y][matrix.length]+" ");
        }
    }

    static int[][] deleteColumn(int[][] matrix){
        int[][] aux = new int[matrix.length][matrix[0].length-1];
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                aux[i][j] = matrix[i][j];
            }
        }
        return aux;
    }


    static void printRightLeft(int[][] matrix) {
        for (int h = matrix[0].length-1; h >= 0; h--) {
            System.out.print( matrix[matrix.length-1][h]+" ");
        }
    }

    static int[][] deleteReverseRow(int[][] matrix){
        int[][] aux = new int[matrix.length-1][matrix[0].length];
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                aux[i][j] = matrix[i][j];
            }
        }
        return aux;
    }


    static void printBottomUp(int[][] matrix) {
        for (int h = matrix.length-1; h >= 0; h--) {
            System.out.print(matrix[h][0]+" ");
        }
    }

    static int[][] deleteReverseColumn(int[][] matrix){
        int[][] aux = new int[matrix.length][matrix[0].length-1];
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                aux[i][j] = matrix[i][j+1];
            }
        }
        return aux;
    }

}
