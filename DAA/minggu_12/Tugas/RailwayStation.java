import java.util.*;
public class RailwayStation{

    public static void sorting(int[] arr1, int[] arr2, int n){
        for(int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j=i+1; j<n;j++){
                if(arr1[j]< arr1[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr1[i];
            int temp2 = arr2[i];
            arr1[i] = arr1[minIndex];
            arr2[i] = arr2[minIndex];
            arr1[minIndex] = temp;
            arr2[minIndex] = temp2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counterMaxTumpuk = 0;
        int n = sc.nextInt();
        int[] waktuDatang = new int[n];
        int[] waktuPergi = new int [n];

        for(int i=0; i<n;i++){
            int jamDatang = sc.nextInt()*60;
            int menitDatang = sc.nextInt();
            int insertWaktuDatang = jamDatang+menitDatang;
            waktuDatang[i]= insertWaktuDatang;

            int jamPergi = sc.nextInt()*60;
            int menitPergi = sc.nextInt();
            int insertWaktuPergi = jamPergi+menitPergi;
            waktuPergi[i] = insertWaktuPergi;


        }

        sorting(waktuDatang, waktuPergi, n);

        // System.out.println(Arrays.toString(waktuDatang));
        // System.out.println(Arrays.toString(waktuPergi));
        
        for (int i=0; i<n-1; i++){
            if(waktuPergi[i]>=waktuDatang[i+1]){
                counterMaxTumpuk++;
            }
        }

        System.out.println(counterMaxTumpuk);

    }
        
    }
