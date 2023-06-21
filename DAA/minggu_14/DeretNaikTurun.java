import java.util.*;
public class DeretNaikTurun {
    public static int lds(int[] arr) {
        int n = arr.length;
        int[] arrLds = new int[n];
        Arrays.fill(arrLds, 1);
        String deretTurunMax = "";

        for (int i = n-2; i >-1; i--) {
            String deretTurunCurr = "";
            for (int j = n-1; j >-1; j--) {
                if (arr[j] > arr[i] && arrLds[j] + 1 > arrLds[i]) {
                    arrLds[i] = arrLds[j] + 1;
                    deretTurunCurr+=arr[j]+ " ";
                }
            }
            if(deretTurunCurr.length()>deretTurunMax.length()){
                deretTurunMax=deretTurunCurr;
            }
        }

        int longestLength = 0;
        for (int i = 0; i < n; i++) {
            if (arrLds[i] > longestLength) {
                longestLength = arrLds[i];
            }
        }
        System.out.println(deretTurunMax);
        return longestLength;
    }

    public static int lis(int[] arr) {
        int n = arr.length;
        int[] arrLis = new int[n];
        Arrays.fill(arrLis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i] && arrLis[j] + 1 > arrLis[i]) {
                    arrLis[i] = arrLis[j] + 1;
                }
            }
        }

        int longestLength = 0;
        for (int i = 0; i < n; i++) {
            if (arrLis[i] > longestLength) {
                longestLength = arrLis[i];
            }
        }
        return longestLength;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(lis(arr) + " , " + lds(arr));
    }
}
