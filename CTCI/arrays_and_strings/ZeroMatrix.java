// If an element in a matrix is 0, zero out the full row / col
// O(N) runtime, O(N + M) space
import java.util.*;

public class ZeroMatrix {
	static int[][] zero(int[][] matrix) {
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];

		// Find zeros
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		// Make rows zero
		for (int i = 0; i < rows.length; i++) {
			if (rows[i]) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// Make cols zero
		for (int i = 0; i < cols.length; i++) {
			if (cols[i]) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		return matrix;
	}

	public static void main(String args[]) {
		int[][] matrix = {{ 1,  2,  3,  4},
					      { 5,  0,  7,  8},
					      { 9, 10, 11,  12}};

		matrix = zero(matrix);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
		System.out.println();
	}
}