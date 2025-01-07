package backtracking;

public class SudokuSolver {
    private static final int GRID_SIZE = 9;
    private static final int BOX_SIZE = 3;
    private static final char EMPTY_CELL = '.';

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solve(board);
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Solves a 9x9 Sudoku puzzle using backtracking.
     *
     * @param board The 9x9 Sudoku board to solve
     */
    public static void solve(char[][] board) {
        solveFromPosition(board, 0);
    }

    /**
     * Recursive helper method that solves the Sudoku puzzle starting from a given position.
     * @param board The current state of the Sudoku board
     * @param position Current position (0-80) being evaluated
     * @return true if a solution is found from this position, false otherwise
     */
    private static boolean solveFromPosition(char[][] board, int position) {
        if (position >= GRID_SIZE * GRID_SIZE) {
            return true;
        }

        int row = position / GRID_SIZE;
        int col = position % GRID_SIZE;

        if (board[row][col] != EMPTY_CELL) {
            return solveFromPosition(board, position + 1);
        }

        for (int num = 1; num <= GRID_SIZE; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = (char) (num + '0');
                if (solveFromPosition(board, position + 1)) {
                    return true;
                }
                board[row][col] = EMPTY_CELL;
            }
        }

        return false;
    }

    /**
     * Checks if a number can be validly placed at the specified position.
     * @param board The current state of the Sudoku board
     * @param row Row index where number is to be placed
     * @param col Column index where number is to be placed
     * @param number Number to be placed (1-9)
     * @return true if the placement is valid, false otherwise
     */
    private static boolean isValidPlacement(char[][] board, int row, int col, int number) {
        char numChar = (char) (number + '0');

        // Check row
        for (int j = 0; j < GRID_SIZE; j++) {
            if (board[row][j] == numChar) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == numChar) {
                return false;
            }
        }

        // Check 3x3 box
        int boxStartRow = row - (row % BOX_SIZE);
        int boxStartCol = col - (col % BOX_SIZE);
        for (int i = 0; i < BOX_SIZE; i++) {
            for (int j = 0; j < BOX_SIZE; j++) {
                if (board[boxStartRow + i][boxStartCol + j] == numChar) {
                    return false;
                }
            }
        }

        return true;
    }
}
