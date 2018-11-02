// Say you have a maze of c columns and r rows. A robot can either move right or down.
// If the starting point is the top left and the end point is the bottom right,
// determine if the robot can move from the start to the end and return the path
import java.util.*;

public class Robot {

    public static ArrayList<Point> robot(boolean[][] maze) {
        ArrayList<Point> path = new ArrayList<>();
        Set<Point> falseSet = new HashSet<>();  
        if (getPath(maze, maze.length-1, maze[0].length-1, path, falseSet)) {
            return path;
        } else {
            return null;
        }
    }

    public static boolean getPath(boolean[][] maze, int row, int col, List<Point> path, Set<Point> falseSet) {
        // If illegal spot or out of bounds, cant be reached
        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }

        Point point = new Point(row, col);
        if (falseSet.contains(point)) {
            return false;
        }

        boolean isBeginning = (row == 0) && (col == 0);

        if (isBeginning || getPath(maze, row-1, col, path, falseSet) || getPath(maze, row, col-1, path, falseSet)) {
            path.add(point);
            return true;
        }

        falseSet.add(point);
        return false;
    }

    public static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // Driver
    public static void main(String[] args) {
        boolean[][] maze = {
            {true, true, true, true},
            {true, false, false, true},
            {true, true, true, false},
            {false, true, true, true}
        };

        ArrayList<Point> path = robot(maze);

        for (Point p : path) {
            System.out.println("r:" + p.row + " c:" + p.col);
        }
    }
}