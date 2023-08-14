public class MazeSolver {

    private boolean[][] visited;
    private int[][] maze;

    public MazeSolver(int[][] maze) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze[0].length];
    }

    public boolean search(int curX, int curY) {
        if (curX < 0 || curX >= maze.length || curY < 0 || curY >= maze[0].length) {
            return false; // Cell is out of bounds
        }

        if (maze[curX][curY] == -1) {
            return true; // Exit found
        }

        if (visited[curX][curY]) {
            return false; // Cell has been visited before
        }

        visited[curX][curY] = true;

        // Check and recursively search in each direction
        if (curX - 1 >= 0 && !visited[curX - 1][curY] && search(curX - 1, curY)) {
            return true;
        }

        if (curX + 1 < maze.length && !visited[curX + 1][curY] && search(curX + 1, curY)) {
            return true;
        }

        if (curY - 1 >= 0 && !visited[curX][curY - 1] && search(curX, curY - 1)) {
            return true;
        }

        return curY + 1 < maze[0].length && !visited[curX][curY + 1] && search(curX, curY + 1);// Couldn't find a solution from this cell in any direction
    }

    public static void main(String[] args) {
        // Initialize maze and visited arrays
         int[][] maze = {
                {0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {-1, 0, 0, 1, 1, 1, 1, 1, 1, 1}
        };

        MazeSolver mazeSolver = new MazeSolver(maze);
        int startX = 0;
        int startY = 0;

        boolean isPathFound = mazeSolver.search(startX, startY);
        if (isPathFound) {
            System.out.println("Path to exit found!");
        } else {
            System.out.println("No path to exit found.");
        }
    }
}
