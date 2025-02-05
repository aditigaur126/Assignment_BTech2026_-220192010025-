package dsa.games;

import java.util.LinkedList;
import java.util.Queue;

class MazeSolver {
    static int[][] maze = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 0, 1, 1, 1 } };
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static boolean solveMaze(int startX, int startY, int exitX, int exitY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { startX, startY });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            if (x == exitX && y == exitY) {
                System.out.println("Exit Found!");
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && maze[nx][ny] == 1) {
                    maze[nx][ny] = 0; // Mark as visited
                    q.add(new int[] { nx, ny });
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (!solveMaze(0, 0, 3, 3)) {
            System.out.println("No path found!");
        }
    }
}
