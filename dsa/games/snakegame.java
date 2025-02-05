package dsa.games;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SnakeGame {
    Queue<int[]> snake = new LinkedList<>();
    int[][] board;
    int foodX, foodY;
    int[] head = { 0, 0 };

    public SnakeGame(int size) {
        board = new int[size][size];
        snake.add(new int[] { 0, 0 });
        spawnFood();
    }

    public void spawnFood() {
        foodX = (int) (Math.random() * board.length);
        foodY = (int) (Math.random() * board.length);
        board[foodX][foodY] = 1;
    }

    public boolean move(String dir) {
        switch (dir) {
            case "W":
                head[0]--;
                break;
            case "S":
                head[0]++;
                break;
            case "A":
                head[1]--;
                break;
            case "D":
                head[1]++;
                break;
            default:
                return false;
        }

        if (head[0] < 0 || head[1] < 0 || head[0] >= board.length || head[1] >= board.length)
            return false; // Collision with wall

        if (board[head[0]][head[1]] == 1) { // Eats food
            snake.add(new int[] { head[0], head[1] });
            spawnFood();
        } else { // Normal move
            snake.poll();
            snake.add(new int[] { head[0], head[1] });
        }
        return true;
    }

    public void display() {
        System.out.println("Snake Length: " + snake.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SnakeGame game = new SnakeGame(5);

        while (true) {
            game.display();
            System.out.print("Move (WASD): ");
            String move = sc.next();
            if (!game.move(move)) {
                System.out.println("Game Over!");
                break;
            }
        }
        sc.close();
    }
}
