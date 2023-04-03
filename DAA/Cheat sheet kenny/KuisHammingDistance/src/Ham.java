
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RamaFS
 */
public class Ham {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int[] arr = new int[N];
        generate(N, arr, 0);
    }

    public static void generate(int N, int arr[], int i) {
        if (i == N) {
            xor(arr, arr, N);
            return;
        }
        arr[i] = 0;
        generate(N, arr, i + 1);
        arr[i] = 1;
        generate(N, arr, i + 1);
    }

    public static void print(int arr[], int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void xor(int[] a, int[] b, int N){
        int[] c = new int[a.length];
        for (int i = 0; i<a.length; i++){
            if (a[i]==b[i]){
                c[i] = 0;
            }else{
                c[i] = 1;
            }
        }
        print(c, N); 
    }
}
