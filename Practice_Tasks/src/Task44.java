public class Task44 {
    static int N = 6;
    static int[][] board = new int[N][N];
    static int solutions = 0;
    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++)
        {
            if (board[i][col] == 1)
            {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
            {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
        {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    static void solve(int row) {
        if (row == N) {
            solutions++;
            if (solutions == 1) {
                printBoard();
            }
            return;
        }
        for (int col = 0; col < N; col++)
        {
            if (isSafe(row, col))
            {
                board[row][col] = 1;
                solve(row + 1);
                board[row][col] = 0;
            }
        }
    }
    static void printBoard() {
        System.out.println("One valid board:");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (board[i][j] == 1)
                {
                    System.out.print("Q ");
                }
                else
                {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solve(0);
        System.out.println("Total solutions: " + solutions);
    }
}