import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DodoSweeperGPT {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int W = input.nextInt();
        int K = input.nextInt();

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = input.nextInt();
            }
        }

        List<int[][]> solutions = new ArrayList<>();
        backtrack(0, 0, N, W, K, grid, new int[N][N], solutions);

        int numSolutions = solutions.size();
        System.out.println(numSolutions);
    }

    private static void backtrack(int row, int col, int N, int remainingWombats, int remainingKapibaras,
                                  int[][] grid, int[][] positions, List<int[][]> solutions) {
        if (remainingWombats == 0 && remainingKapibaras == 0) {
            solutions.add(positions);
            return;
        }

        if (col == N) {
            backtrack(row + 1, 0, N, remainingWombats, remainingKapibaras, grid, positions, solutions);
            return;
        }

        if (row == N) {
            return;
        }

        if (grid[row][col] == 0) {
            backtrack(row, col + 1, N, remainingWombats, remainingKapibaras, grid, positions, solutions);
            return;
        }

        if (positions[row][col] != 0) {
            backtrack(row, col + 1, N, remainingWombats, remainingKapibaras, grid, positions, solutions);
            return;
        }

        // Place a wombat
        if (remainingWombats > 0) {
            positions[row][col] = 1;
            backtrack(row, col + 1, N, remainingWombats - 1, remainingKapibaras, grid, positions, solutions);
            positions[row][col] = 0;
        }

        // Place a kapibara
        if (remainingKapibaras > 0) {
            positions[row][col] = 2;
            backtrack(row, col + 1, N, remainingWombats, remainingKapibaras - 1, grid, positions, solutions);
            positions[row][col] = 0;
        }
    }
}