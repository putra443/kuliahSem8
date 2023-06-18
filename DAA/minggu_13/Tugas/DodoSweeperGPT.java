import java.util.Scanner;

public class DodoSweeperGPT {
    static int[][] grid;
    static int N, W, K;
    static int solutions = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        W = scanner.nextInt();
        K = scanner.nextInt();

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        findPossiblePositions(0, 0, W, K);

        System.out.println(solutions);

        scanner.close();
    }

    public static void findPossiblePositions(int row, int col, int remainingWombat, int remainingKapibara) {
        if (remainingWombat < 0 || remainingKapibara < 0) {
            return;
        }

        if (row >= N) {
            if (remainingWombat == 0 && remainingKapibara == 0) {
                solutions++;
            }
            return;
        }

        if (col >= N) {
            findPossiblePositions(row + 1, 0, remainingWombat, remainingKapibara);
            return;
        }

        if (grid[row][col] == 0) {
            int adjacentValue = getAdjacentValue(row, col);
            if (adjacentValue == 1) {
                findPossiblePositions(row, col + 1, remainingWombat - 1, remainingKapibara);
            } else if (adjacentValue == 2) {
                findPossiblePositions(row, col + 1, remainingWombat, remainingKapibara - 1);
            } else {
                findPossiblePositions(row, col + 1, remainingWombat - 1, remainingKapibara);
                findPossiblePositions(row, col + 1, remainingWombat, remainingKapibara - 1);
            }
        } else {
            findPossiblePositions(row, col + 1, remainingWombat, remainingKapibara);
            System.out.println("jmlWombat = " + remainingWombat + " , jmlKapibara = " + remainingKapibara);
        }
    }

    public static int getAdjacentValue(int row, int col) {
        int value = 0;

        if (row - 1 >= 0 && grid[row - 1][col] > 0) {
            value += grid[row - 1][col];
        }

        if (row + 1 < N && grid[row + 1][col] > 0) {
            value += grid[row + 1][col];
        }

        if (col - 1 >= 0 && grid[row][col - 1] > 0) {
            value += grid[row][col - 1];
        }

        if (col + 1 < N && grid[row][col + 1] > 0) {
            value += grid[row][col + 1];
        }

        return value;
    }
}