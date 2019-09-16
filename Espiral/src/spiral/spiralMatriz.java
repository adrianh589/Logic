package spiral;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 
 * @author Adrian Hoyos
 *
 */
public class spiralMatriz {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length;
		
		//matrix with ordered numbers
		System.out.println("Introduce dimension de la matriz (Se generara con numeros en orden): ");
		length = Integer.parseInt(br.readLine());
		int matrix[][] = fillOrderMatrix(length);
		showMatrix(matrix);
		spiralForm(matrix);

		//matrix with random numbers
		System.out.println("\n\nIntroduce dimension de la matriz (Se generara con numeros aleatorios): ");
		length = Integer.parseInt(br.readLine());
		int matrix2[][] = fillRandomMatrix(length);
		showMatrix(matrix2);
		spiralForm(matrix2);
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

	/**
	 * Function to print a matrix in spiral form
	 * 
	 * @param matrix
	 */
	static void spiralForm(int matrix[][]) {
		int savedPos[] = { 0, 0 },
			counter = 0,
			rightLimit = matrix.length,
			bottomLimit = matrix.length,
			leftLimit = 0,
			topLimit = 0;

		System.out.println("\nLa matriz en espiral es: \n");

		for (int h = 0; h < stop(matrix.length); h++) {

			switch (counter) {

			case 0:// left - right
				for (int i = savedPos[0]; i <= topLimit; i++) {
					for (int j = savedPos[1]; j < rightLimit; j++) {
						System.out.print(matrix[i][j] + " ");
						savedPos = actualPosition(i, j);
					}
				}

				counter++;
				topLimit++;

			case 1:// top - botom
				for (int i = savedPos[0] + 1; i < bottomLimit; i++) {
					for (int j = savedPos[1]; j < rightLimit; j++) {
						System.out.print(matrix[i][j] + " ");
						savedPos = actualPosition(i, j);
					}
				}

				counter++;
				rightLimit--;

			case 2:// right - left
				for (int i = savedPos[0]; i < bottomLimit; i++) {
					for (int j = savedPos[1] - 1; j >= leftLimit; j--) {
						System.out.print(matrix[i][j] + " ");
						savedPos = actualPosition(i, j);
					}
				}

				counter++;
				bottomLimit--;

			case 3:// bottom - top
				for (int i = savedPos[0] - 1; i >= topLimit; i--) {
					for (int j = savedPos[1]; j >= leftLimit; j--) {
						System.out.print(matrix[i][j] + " ");
						savedPos = actualPosition(i, j);
					}
				}

				counter++;
				leftLimit++;

				savedPos[1] = savedPos[1] + 1;
				counter = 0;

			}

		}
	}

	/**
	 * Function to save actual position
	 * 
	 * @param i position in i
	 * @param j position in j
	 * @return
	 */
	static int[] actualPosition(int i, int j) {
		int array[] = new int[2];
		array[0] = i;
		array[1] = j;
		return array;
	}

	/**
	 * Function to stop the bucle while
	 * 
	 * @param n dimension of the matrix
	 * @return i and j values
	 */
	static int stop(int n) {
		int stop = (n % 2 == 0) ?  n/2 :  n/2 + 1;
		return stop;
	}

}
