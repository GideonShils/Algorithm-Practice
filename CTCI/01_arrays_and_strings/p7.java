// Rotate NxN image matrix by 90 degrees where each pixel is 4 bytes.
import java.util.*;

public class p7 {
	static int[][] rotate(int[][] img) {
		// Iterate over layers (outer to inner)
		for (int i = 0; i < img.length/2; i++) {
			// Iterate over sections of 4 in top/left/bot/right
			for (int j = i; j < img.length - 1 - i; j++) {
				// Store top
				int temp = img[i][j];

				// Put left in top
				img[i][j] = img[img.length - 1 - j][i];

				// Put bottom in left
				img[img.length - 1 - j][i] = img[img.length - 1 - i][img.length - 1 - j];

				// Put right in bottom
				img[img.length - 1 - i][img.length - 1 - j] = img[j][img.length - 1 - i];

				// Put top in right
				img[j][img.length - 1 - i] = temp;
			}
		}

		return img;
	}

	public static void main(String args[]) {
		int[][] img = {{ 1,  2,  3,  4},
					   { 5,  6,  7,  8},
					   { 9, 10, 11, 12},
					   {13, 14, 15, 16}};

		img = rotate(img);
		for (int i = 0; i < img.length; i++) {
			System.out.println();
			for (int j = 0; j < img[i].length; j++) {
				System.out.print(img[i][j] + " ");
			}
		}
		System.out.println();
	}
}