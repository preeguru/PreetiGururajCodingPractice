import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        boolean playerX = true;
        Scanner scanner = new Scanner(System.in);

        // Game loop
        for (int i = 0; i < 9; i++) {
            // Print the board
            for (char[] row : board) {
                for (char cell : row) {
                    System.out.print(cell + " | ");
                }
                System.out.println();
            }

            // Determine current player
            char currentPlayer = playerX ? 'X' : 'O';

            // Get player input
            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter your row (0-2) and column (0-2): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');

            // Make a move
            board[row][col] = currentPlayer;

            // Check for a win
            if (checkWin(board, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Switch players
            playerX = !playerX;
        }

        scanner.close();
    }

    public static boolean checkWin(char[][] board, char player) {
        // Check rows, columns, and diagonals for win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
