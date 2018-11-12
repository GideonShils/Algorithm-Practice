// Return all possible ways to place 8 queens on a chess board

import java.util.*;

public class EightQueens {
    // For each row, go column by column checking validity
    public static void eightQueens(Integer[] rows, int rowNum, ArrayList<Integer[]> boards) {
        
        // If we've gone through every row, add the solution
        if (rowNum > rows.length - 1) {
            boards.add(rows);
            return;
        }

        // Try placing a queen in every column of the row
        for (int col = 0; col < rows.length; col++) {
            // If valid, recurse
            if (isValid(rows, rowNum, col)) {
                rows[rowNum] = col;
                eightQueens(rows, rowNum + 1, boards);
            }
        }
    }

    public static boolean isValid(Integer[] rows, int rowNum, int col) {
        // Iterate through rows
        for (int i = 0; i < rows.length; i++) {
            // If any other row has a queen in the same col, return false
            if (rows[i] == col && i != rowNum) {
                return false;
            }

            // If there is another queen on the diagonal, return false
            int col2 = rows[i];

            // Calculate difference between rows and cols. If the distanes are the same,
            // there's a queen on the same diagonal
            int diffCols = Math.abs(col2 - col);
            int diffRows = Math.abs(rowNum - i);

            if (diffCols == diffRows) {
                return false;
            }
        }
        return true;
    }

    // Driver
    public static void main(String[] args) {
        // Store board as a list of Integer arrays where each
        // integer arary represents a list of rows.
        // Let the index represent the row num and the value represent the column num
        //
        // e.g. row[5] = 2 means that a queen is placed in row 5, column 2
        Integer[] rows = new Integer[8];
        Arrays.fill(rows, -1);

        ArrayList<Integer[]> boards = new ArrayList<>();

        eightQueens(rows, 0, boards);

        for (int i = 0; i < boards.size(); i++) {
            System.out.println("Board " + i  + ":");
            Integer[] currBoard = boards.get(i);
            for (int j = 0; j < currBoard.length; j++) {
                System.out.println("Row: " + j);
                System.out.println("Col: " + rows[j]);
            }
        }
    }
}