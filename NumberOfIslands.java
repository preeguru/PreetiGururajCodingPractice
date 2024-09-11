public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
        };

        int numberOfIslands = countIslands(grid);
        System.out.println("Number of islands: " + numberOfIslands);
    }

    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, rows, cols);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int row, int col, int rows, int cols) {
        // Check for out of bounds or already visited or water cell
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || grid[row][col] == 0) {
            return;
        }

        // Mark the cell as visited
        visited[row][col] = true;

        // Visit all 4 adjacent cells (up, down, left, right)
        dfs(grid, visited, row - 1, col, rows, cols);
        dfs(grid, visited, row + 1, col, rows, cols);
        dfs(grid, visited, row, col - 1, rows, cols);
        dfs(grid, visited, row, col + 1, rows, cols);
    }
}