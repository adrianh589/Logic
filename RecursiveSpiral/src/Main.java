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
		printRecursiveSpiral(matrix, new int[2], 0, 0, matrix.length, matrix.length);//Print in spiral form using recursion
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
	 * Function to fill a matrix in order numbers
	 * 
	 * @param length The length of the matrix
	 * @return The matrix with ordered numbers
	 */
	static int[][] fillOrderMatrix(int length) {
		int number = 1;
		int matriz[][] = new int[length][length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = number;
				number++;
			}
		}
		return matriz;
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
	
	static void printRecursiveSpiral(int[][] matrix,int pos[], int upLimit, int leftLimit, int bottomLimit, int rightLimit){
		if(upLimit == bottomLimit && leftLimit == rightLimit) {//base case
			System.out.println(matrix[leftLimit][upLimit]);
		}else {
			if( matrix[pos[0]][pos[1]] < matrix.length ) {//left-right
				
				int[] aux = printLeftRight(pos, rightLimit, matrix);
				printRecursiveSpiral(matrix, aux, upLimit+1, leftLimit, bottomLimit, rightLimit);
				
			}else if( matrix[pos[0+1]][pos[1]] != 0 ) {//up-bottom
				
				
				int[] aux = printUpBottom(pos, bottomLimit, matrix);
				printRecursiveSpiral(matrix, aux, upLimit, leftLimit, bottomLimit, rightLimit-1);
				
			}else if( matrix[pos[0]][pos[1-1]] != 0 ) {//right - left
				
				int[] aux = printRightLeft(pos, leftLimit, matrix);
				printRecursiveSpiral(matrix, aux, upLimit, leftLimit, bottomLimit-1, rightLimit);
				
			}else { //bottom-up
				
				int[] aux = printBottomUp(pos, upLimit, matrix);
				printRecursiveSpiral(matrix, aux, upLimit, leftLimit+1, bottomLimit, rightLimit);
				
			}
			
		}
	}
	
	static int[] printLeftRight(int pos[], int rightLimit, int[][] matrix){
		int aux[] = pos;
		for (int h = pos[0]; h < rightLimit; h++) {
			System.out.println(matrix[pos[0]][h]+" ");
			pos[0] = pos[0]; pos[1] = h; //save the pos
		}
		return aux;
	}
	
	static int[] printUpBottom(int pos[], int bottomLimit, int[][] matrix) {
		int aux[] = pos;
		for (int h = pos[0]; h < bottomLimit; h++) {
			System.out.println(matrix[h][pos[0]]+" ");
			pos[0] = pos[0]; pos[1] = h; //save the pos
		}
		return aux;
	}
	
	static int[] printRightLeft(int pos[], int leftLimit, int[][] matrix) {
		int aux[] = pos;
		for (int h = pos[0]; h > leftLimit; h--) {
			System.out.println(matrix[pos[0]][h]+" ");
			pos[0] = pos[0]; pos[1] = h; //save the pos
		}
		return aux;
	}
	
	static int[] printBottomUp(int pos[], int upLimit, int[][] matrix) {
		int aux[] = pos;
		for (int h = pos[0]; h > upLimit; h--) {
			System.out.println(matrix[h][pos[1]]+" ");
			pos[0] = pos[0]; pos[1] = h; //save the pos
		}
		return aux;
	}

}
