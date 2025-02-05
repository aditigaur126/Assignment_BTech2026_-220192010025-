package dsa.games;

class SudokuSolver {
    static final int SIZE = 9; // Sudoku grid size

    // Function to print Sudoku grid
    static void printGrid(int[][] grid) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if placing num is valid
    static boolean isValid(int[][] grid, int row, int col, int num) {
        // Check row & column
        for (int i = 0; i < SIZE; i++) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // Backtracking function to solve Sudoku
    static boolean solveSudoku(int[][] grid) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) { // Find empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(grid, row, col, num)) {
                            grid[row][col] = num; // Place number
                            if (solveSudoku(grid)) {
                                return true;
                            }
                            grid[row][col] = 0; // Undo choice (Backtrack)
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Sudoku solved
    }

    public static void main(String[] args) {
        int[][] sudokuGrid = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        System.out.println("Original Sudoku:");
        printGrid(sudokuGrid);

        if (solveSudoku(sudokuGrid)) {
            System.out.println("\nSolved Sudoku:");
            printGrid(sudokuGrid);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
