import java.util.*;

public class TopScore{

    public static int maxValue (int[]arrLevel, int n){
        int maxTurun = 0;
        for(int i =0; i<n;i++){
            int currTurun = 0;
            for(int j=i+1; j<n;j++){
                if(arrLevel[i]>arrLevel[j]){
                    currTurun++;
                }
            }
            if(maxTurun<currTurun){
                maxTurun=currTurun;
            }
        }
        return maxTurun;
    }

    public static int lds(int[] arr) {
        int n = arr.length;
        int[] arrLds = new int[n];
        Arrays.fill(arrLds, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && arrLds[j] + 1 > arrLds[i]) {
                    arrLds[i] = arrLds[j] + 1;
                }
            }
        }

        int longestLength = 0;
        for (int i = 0; i < n; i++) {
            if (arrLds[i] > longestLength) {
                longestLength = arrLds[i];
            }
        }
        System.out.println(Arrays.toString(arrLds));
        return longestLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arrLevel = new int[n];
        for(int i=0;i<n;i++){
            String input = sc.next();
            int level = 0 ;
            String [] arrInput = new String[input.length()];
            for(int j=0; j<input.length();j++){
                if(input.charAt(j)=='a'){
                    level+=1;
                }
                if(input.charAt(j)=='i'){
                    level+=10;
                }
                if(input.charAt(j)=='u'){
                    level+=100;
                }
                if(input.charAt(j)=='e'){
                    level+=1000;
                }
                if(input.charAt(j)=='o'){
                    level+=10000;
                }
                arrInput[j] = String.valueOf(input.charAt(j));
            }
            arrLevel[i] = level;    
            // System.out.println(Arrays.toString(arrInput));
        }
        // System.out.println(Arrays.toString(arrLevel));
        
        int max = lds(arrLevel);
        System.out.println(max*100);
    }
}