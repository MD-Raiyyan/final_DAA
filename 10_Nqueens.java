import java.util.*;

public class NQueens {

    static int n;
    static int board[][];
    static int count = 0;

    static boolean isSafe(int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    static void solve(int row) {

        if (row == n) {

            count++;
            System.out.println("\nSolution " + count + ":");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {

                board[row][col] = 1;

                solve(row + 1);

                // Backtrack
                board[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        n = sc.nextInt();

        board = new int[n][n];

        long start = System.nanoTime();

        solve(0);

        long end = System.nanoTime();

        if (count == 0)
            System.out.println("No Solution");
        else
            System.out.println("\nTotal Solutions = " + count);

        System.out.println("Execution Time = " + (end - start) + " ns");

        sc.close();
    }
}
