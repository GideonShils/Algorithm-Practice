// Write a method to compute all permutations of a string where the characters are not necessarily unique
// The resulting list should not have duplicates

import java.util.*;

public class PaintFill {

    public static void paintFill(char[][] canvas, int r, int c, char newColor){
        char oldColor = canvas[r][c];
        paintFill(canvas, r, c, newColor, oldColor);
    }

    public static void paintFill(char[][] canvas, int r, int c, char newColor, char oldColor) {
        if (canvas[r][c] != oldColor || r < 0 || c < 0 || r > canvas.length-1 || c > canvas[0].length - 1) {
            return;
        }

        canvas[r][c] = newColor;
        paintFill(canvas, r - 1, c, newColor, oldColor);
        paintFill(canvas, r, c - 1, newColor, oldColor);
        paintFill(canvas, r + 1, c, newColor, oldColor);
        paintFill(canvas, r, c + 1, newColor, oldColor);

        return;
    }

    // Driver
    public static void main(String[] args) {
        char[][] canvas = {
            {'g', 'g', 'g', 'g', 'g'},
            {'g', 'b', 'b', 'b', 'g'},
            {'g', 'b', 'b', 'b', 'g'},
            {'g', 'b', 'b', 'b', 'g'},
            {'g', 'g', 'g', 'g', 'g'}
        };

        paintFill(canvas, 2, 2, 'r');

        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                System.out.print(canvas[i][j] + " ");
            }
            System.out.println();
        }


    }
}