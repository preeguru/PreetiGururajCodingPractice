import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMaze {

    // Directions array to move in four directions: up, down, left, right
    private static final int[][] DIRECTIONS = {
        {0, 1},  // Right
        {1, 0},  // Down
        {0, -1}, // Left
        {-1, 0}  // Up
    };

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 1, 1, 1},
            {1, 1, 0, 1, 0},
            {1, 1, 1, 1, 1}
        };

        int[] start = {0, 0};
        int[] destination = {4, 4};

        int shortestPathLength = findShortestPath(maze, start, destination);

        if (shortestPathLength != -1) {
            System.out.println("The shortest path length is: " + shortestPathLength);
        } else {
            System.out.println("No path exists from the start to the destination.");
        }
    }

    public static int findShortestPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0}); // x, y, distance

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // If we reach the destination, return the distance
            if (x == destination[0] && y == destination[1]) {
                return distance;
            }

            // Mark the current cell as visited
            visited[x][y] = true;

            // Explore all 4 possible directions
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check if the new position is within bounds and not visited and not a wall
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY, distance + 1});
                    visited[newX][newY] = true; // Mark as visited when adding to the queue
                }
            }
        }

        // If we exhaust the queue without finding the destination, return -1
        return -1;
    }
}