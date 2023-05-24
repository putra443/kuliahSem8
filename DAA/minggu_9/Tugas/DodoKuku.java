// package Tugas;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
public class DodoKuku{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> list_menit_pengunjung = new PriorityQueue<Integer>();
        Queue<String> list_nama = new LinkedList<String>();
        PriorityQueue<Integer> list_menit_end = new PriorityQueue<Integer>();
        Queue<String> output = new LinkedList<String>();
        float total = 0;
        int counter = 0;
        int menit_datang = 0;
        String nama = "";
        list_menit_end.add(menit_datang);
        while(menit_datang>=0){
            menit_datang = sc.nextInt();
            if(menit_datang==-1){
                break;
            }
            nama = sc.next();
            if(!nama.equals("END")){
                list_menit_pengunjung.add(menit_datang);
                list_nama.add(nama);
                
            }
            else{
                counter+=1;
                list_menit_end.add(menit_datang);
                int head_end = list_menit_end.poll();
                int head_menit_pengunjung = list_menit_pengunjung.poll();
                int selisih = head_end-head_menit_pengunjung;
                if(selisih<=0){
                   output.add(list_nama.poll()+ " " + 0);
                }
                else{
                    output.add(list_nama.poll()+" "+selisih);
                    total+=selisih;
                }
            }
            
        }
        while(output.isEmpty()==false){
            System.out.println(output.poll());
        }
        
        double rata2 = total/counter;
        BigDecimal output2 = new BigDecimal(rata2).setScale(2,RoundingMode.DOWN);
        System.out.println(output2);
             
    }
}