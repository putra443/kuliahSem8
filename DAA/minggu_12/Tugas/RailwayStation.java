import java.util.*;
public class RailwayStation{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] waktuMasuk = new int[n];
        int[] waktuKeluar = new int[n];

        for(int i=0; i<n; i++){
            int masuk = Integer.valueOf(sc.next()+sc.next());
            int keluar = Integer.valueOf(sc.next()+sc.next());
            waktuMasuk[i] = masuk;
            waktuKeluar[i] = keluar;
        }
        // System.out.println(Arrays.toString(waktuMasuk));
        // System.out.println(Arrays.toString(waktuKeluar));
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1;j++){
                if(waktuMasuk[j]>waktuMasuk[j+1]){
                    int temp = waktuMasuk[j];
                    waktuMasuk[j] = waktuMasuk[j+1];
                    waktuMasuk[j+1] = temp;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n-1;j++){
                if(waktuKeluar[j]>waktuKeluar[j+1]){
                    int temp = waktuKeluar[j];
                    waktuKeluar[j] = waktuKeluar[j+1];
                    waktuKeluar[j+1] = temp;
                }
            }
        }
        int counterMax = 1;
        for(int i=0; i<n-1; i++){
            int temp = waktuKeluar[i];
            int temp2 = waktuMasuk[i];
            int counterTemp= 1;
            for(int j=i+1; j<n;j++){
                if(temp>waktuMasuk[j]&& temp2<waktuKeluar[j]){
                    // System.out.println("keluar I = " + temp + " , masuk J = " + waktuMasuk[j]);
                    counterTemp++;
                }
            }
            if(counterTemp>counterMax){
                counterMax = counterTemp;
            }
        }
        // System.out.println(Arrays.toString(waktuMasuk));
        // System.out.println(Arrays.toString(waktuKeluar));
        System.out.println(counterMax);

    }
        
    }
