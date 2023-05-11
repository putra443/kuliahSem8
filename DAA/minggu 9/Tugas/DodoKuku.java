package Tugas;
import java.util.*;
public class DodoKuku{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Queue <String> nama = new LinkedList<String>(); 
        ArrayList<Integer> waktu_menunggu = new ArrayList<Integer>();
        int menit_datang = sc.nextInt();
        int counter_menit = 0;
        int selisih = 0;
        while(menit_datang!=-1){
            counter_menit=menit_datang;
            pq.add(menit_datang);
            String pelanggan = sc.next();
            menit_datang = sc.nextInt();
            if(!pelanggan.equals("END")){
                nama.add(pelanggan);
            }
            else{
                selisih = menit_datang-counter_menit;
                System.out.println(nama.poll() + " "+ selisih);
                pq.poll();
                pq.add(menit_datang);
            }

        }
    }
}