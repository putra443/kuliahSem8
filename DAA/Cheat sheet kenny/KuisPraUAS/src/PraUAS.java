import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
NPM : 6181801051 
Nama : Rama Fauzi Setiawan 
Metode yang digunakan: Dynamic Programming 
*/

public class PraUAS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i<N; i++){
            for (int j = 0; j<i+1; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(minSumPath(arr));
        
    }
    
    public static int minSumPath(int[][] arr){ 
        int []memo = new int[arr.length]; 
        int n = arr.length - 1; 
        for (int i = 0; i < arr[n].length; i++){
            memo[i] = arr[n][i];
        }
        for (int i = arr.length - 2; i >= 0; i--){
            for (int j = 0; j < arr[i].length-1; j++){
                memo[j] = arr[i][j] + (int)Math.min(memo[j], memo[j + 1]);
            }
        }
        return memo[0]; 
    }
}
