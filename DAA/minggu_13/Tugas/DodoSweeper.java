import java.util.*;
public class DodoSweeper{
    static int[][] map;
    static int length;
    
    static void generateBS(int len){
        if(len==-1){
            for(int i=0; i<length;i++){
                for(int j=0; j<length;j++){
                    System.out.print(map[i][j] + " , ");
                }
                System.out.println();
            }
        }
        else{
            map[len][len]=0;
            if(map[len][len]==0){
                generateBS(len-1);
            }
            
            map[len][len]=-1;

            map[len][len]=1;
            if(map[len][len]==1){
                generateBS(len-1);
            }

            map[len][len]=-1;


            map[len][len]=2;
            if(map[len][len]==2){
                generateBS(len-1);
            }

            map[len][len]=-1;

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        map = new int[length][length];
        for (int[] row: map){
            Arrays.fill(row, -1);
        }
        generateBS(length-1);
    }
}