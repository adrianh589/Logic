import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Introduzca la dimension de la matriz: ");
        int length = Integer.parseInt(br.readLine());
        int[][] matrix = fillRandomMatrix(length );
        showMatrix(matrix);
        SpiralMatrixWithRecursion(matrix,0,0, matrix.length-1, matrix.length-1);
    }

    static void SpiralMatrixWithRecursion(int matrix[][], int iStart, int jStart, int iLimit, int jLimit){
        if(iStart == iLimit && jStart == jLimit){//base case if the matrix is even
            System.out.println(matrix[iStart][jStart]);
        }else if(iStart == matrix.length-1 && jStart == matrix.length-1){//base case for odd matrix
            return;
        }
        else{
            for (int j = jStart; j < jLimit; j++) {//left - right
                System.out.print(matrix[iStart][j] + " ");
            }
            for (int i = iStart; i < iLimit; i++) {//up - bottom
                System.out.print(matrix[i][jLimit] + " ");
            }
            for (int j = jLimit; j > jStart; j--) {//right - left
                System.out.print(matrix[iLimit][j] + " ");
            }
            for (int i = iLimit; i > iStart; i--) {//bottom - up
                System.out.print(matrix[i][jStart] + " ");
            }
            SpiralMatrixWithRecursion(matrix, iStart+1, jStart+1, iLimit-1, jLimit-1);
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
}
