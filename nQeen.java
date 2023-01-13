public class nQeen {

    public static boolean isSafe(char board[][], int Row, int Col) {
        // vertical up
        for (int i = Row - 1; i >= 0; i--) {
            if (board[i][Col] == 'Q') {
                return false;
            }
        }
        // Diognal left up
        for (int i = Row - 1, j = Col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // diognal right up
        for (int i = Row - 1, j = Col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueen(char board[][], int row) {
        // BaseCase
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        // column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {

                board[row][j] = 'Q';
                nQueen(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("------Chess Board-------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static int gridway(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (i == n || j == m) {
            return 0;
        }
        int w1 = gridway(i + 1, j, n, m);
        int w2 = gridway(i, j + 1, n, m);

        return w1 + w2;
    }

    public static void main(String[] args) {
        /*
         * int n = 4;
         * char board[][] = new char[n][n];
         * for (int i = 0; i < n; i++) {
         * 
         * for (int j = 0; j < n; j++) {
         * board[i][j] = 'x';
         * }
         * }
         * nQueen(board, 0);
         * System.out.println("total ways " + count);
         * 
         */
        int n = 3, m = 3;
        System.out.println(gridway(0, 0, n, m));
    }
}
