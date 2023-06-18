import java.util.*;
public class DodoSweeper{
    static int[][] map;
    static int n,w,k;
    static int solusi = 0;
    
    static void generateBS(int baris, int kolom, int remainingW, int remainingK){
        if(baris==-1 && kolom==-1){
            solusi++;
        }
        else{
           
            map[baris-1][kolom] = 0;
            if(map[baris+1][kolom]==0){
                generateBS(baris, kolom, remainingW, remainingK);
            }

            map[baris-1][kolom] = -1;

            map[baris-1][kolom] = 1;
            if(map[baris+1][kolom]==1){
                generateBS(baris, kolom, remainingW-1, remainingK);
            }

            map[baris-1][kolom] = -1;

            map[baris-1][kolom] = 2;
            if(map[baris-1][kolom]==2){
                generateBS(baris, kolom, remainingW, remainingK-1);
            }
            map[baris-1][kolom] = -1;

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();
        map = new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = sc.nextInt();
            }
        }

        
        generateBS(n-1,n-1, w, k);
    }
}