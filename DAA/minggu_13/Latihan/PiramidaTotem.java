import java.util.*;
public class PiramidaTotem {
    static int[][] piramida;
    static int length;
	static int globalMin = Integer.MAX_VALUE ;
    static int currMin ;
    static void generateBS(int baris, int ruang) {
        if(baris==length-1){
            System.out.println(currMin + " " + globalMin);
            if(currMin<globalMin){
                // System.out.println(currMin + " " + globalMin);
                globalMin = currMin;
            }
        }
        else{
            currMin = currMin + piramida[baris+1][ruang];
            if(currMin<globalMin){
                generateBS(baris+1,ruang);
            }
            currMin = currMin-piramida[baris+1][ruang];

            currMin = currMin+piramida[baris+1][ruang+1];
            if(currMin<globalMin){
                generateBS(baris+1,ruang+1);

            }
            currMin = currMin-piramida[baris+1][ruang+1];
        }
    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        length = n;
        piramida = new int[n][n];    
        for( int i =0; i<n; i++){
            for(int j=0; j<i+1;j++){
                int mumi = sc.nextInt();
                piramida[i][j] = mumi;
            }
        }
        currMin=piramida[0][0];
        generateBS(0, 0);
        System.out.println(globalMin);
    }

}
