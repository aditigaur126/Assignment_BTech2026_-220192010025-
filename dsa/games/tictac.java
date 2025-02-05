package dsa.games;

import java.util.*;

/**
 * public class tictac {
 * static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', '
 * ' } };
 * 
 * public static void printBoard() {
 * for (char[] row : board) {
 * System.out.println(Arrays.toString(row));
 * }
 * }
 * 
 * public static boolean isWin(char player) {
 * for (int i = 0; i < 3; i++) {
 * if ((board[i][0] == player && board[i][1] == player && board[i][2] == player)
 * ||
 * (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
 * return true;
 * }
 * }
 * return (board[0][0] == player && board[1][1] == player && board[2][2] ==
 * player) ||
 * (board[0][2] == player && board[1][1] == player && board[2][0] == player);
 * }
 * 
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * char player = 'X';
 * 
 * while (true) {
 * printBoard();
 * System.out.print("Enter row & column (0-2): ");
 * int r = sc.nextInt(), c = sc.nextInt();
 * if (board[r][c] == ' ') {
 * board[r][c] = player;
 * if (isWin(player)) {
 * printBoard();
 * System.out.println(player + " Wins!");
 * break;
 * }
 * player = (player == 'X') ? 'O' : 'X';
 * } else {
 * System.out.println("Cell occupied! Try again.");
 * }
 * }
 * sc.close();
 * }
 * }
 **/

public class tictac {
    public static void printboard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j]);

            }
            System.out.println();
        }
    }

    public static boolean won(char[][] board, char player) {
        for (int i = 0; i < 3; i++) { // row & col wise check
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player)
                    || (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        while (true) {
            printboard(board);
            System.out.println("enter row and column (0-2):");
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (board[r][c] == ' ') {
                board[r][c] = player;
                if (won(board, player)) {
                    printboard(board);
                    System.out.println("Player " + player + "won.");
                    break;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }

            } else {
                System.out.println("Invalid Choice");
            }

        }
        sc.close();
    }
}