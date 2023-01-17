public class solveKnight {
    static int N = 8;

    public static boolean solveKt() {
        int sol[][] = new int[8][8];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        // As the knigth from cell(0,0)
        sol[0][0] = 0;

        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("solution does not exist");
            return false;

        } else {
            printSolution(sol);
            return true;
        }
    }

    public static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        int k, nextx, nexty;
        if (movei == N * N) {
            return true;
        }
        for (k = 0; k < 8; k++) {
            nextx = x + xMove[k];
            nexty = y + yMove[k];

            if (isSafe(nextx, nexty, sol)) {
                sol[nextx][nexty] = movei;
            }
            if (solveKTUtil(nextx, nexty, movei + 1, sol, xMove, yMove)) {
                return true;
            }

            else {
                sol[nextx][nexty] = -1; // backtreking
            }
        }
        return false;
    }

    public static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y <= N && sol[x][y] == -1);
    }

    public static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveKt();

    }
}
