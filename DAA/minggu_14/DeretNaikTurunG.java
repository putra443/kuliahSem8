import java.util.ArrayList;
import java.util.Scanner;

public class DeretNaikTurunG {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] deret = new int[N];
        for (int i = 0; i < N; i++) {
            deret[i] = input.nextInt();
        }

        int[] lis = longestIncreasingSubsequence(deret);
        int[] lds = longestDecreasingSubsequence(deret);

        int maxLength = 0;
        ArrayList<Integer> subsequence = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (lis[i] > 1 && lds[i] > 1 && lis[i] + lds[i] - 1 > maxLength) {
                maxLength = lis[i] + lds[i] - 1;
                subsequence.clear();
                for (int j = i - lis[i] + 1; j < i + lds[i]; j++) {
                    subsequence.add(deret[j]);
                }
            }
        }

        System.out.println(maxLength);
        for (int num : subsequence) {
            System.out.print(num + " ");
        }
    }

    public static int[] longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        return lis;
    }

    public static int[] longestDecreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] lds = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && lds[j] + 1 > lds[i]) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        return lds;
    }
}