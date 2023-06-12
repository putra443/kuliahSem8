import java.util.*;
public class DodoBatanganTebu{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rumah = sc.nextInt();
        int[] jumlahTebu = new int[rumah];
        
        for(int i=0; i<rumah;i++){
            jumlahTebu[i] = sc.nextInt();
        }
        int temp = 0;
        int counterLangkah = jumlahTebu[0];
        for(int i = 0; i< rumah; i++){
            if(i==0){
                temp = jumlahTebu[i];
            }
            else{
                int selisih = temp+jumlahTebu[i];
                counterLangkah+=selisih;
                jumlahTebu[i] = selisih;
                temp = jumlahTebu[i];
            }
        }
        if(counterLangkah<0){
            System.out.println(-(counterLangkah));
        }
        else{
            System.out.println(counterLangkah);
        }
    }
}
    
