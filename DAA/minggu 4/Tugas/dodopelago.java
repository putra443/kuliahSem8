package Tugas;
import java.util.*;
public class dodopelago {

    int numOfElements;      // jumlah element pada disjoint sets
    int[] parents;          // menyimpan parent dari setiap element
    int[] ranks;            // menyimpan rank dari setiap element

    /**
     * Constroctor dari kelas disjointSets. Jumlah elemen tidak 
     * dapat berubah. Versi yang lebih baik bisa berubah (gunakan vector).
     */
    dodopelago(int numOfElements){
        this.numOfElements = numOfElements;
        this.parents = new int[numOfElements];
        this.ranks = new int[numOfElements];

        for(int i =0; i<this.numOfElements;i++){
            this.parents[i]=i;      //parent dari setiap element adalah element itu sendiri
            this.ranks[i] = 0;      // rank dari setiap element adalah 0, tinggi pohon dengan root saja = 0
        }
    }
    /**
     * Method findSets mengembalikan representatif dari set dimana element berada.
     * Path-compression diimplementasikan saat melakukan pencarian element
     * @param element elemen yang hendak dicari representatifnya.
     * @return elemen representatif dan buat semua parent dari setiap element adalah root.
     */
    public int findSets(int element){
        int x = 0;
        if(this.parents[element]== element){                //jika parent dari element merupakan element itu sendiri == root
            x = this.parents[element];
        } 
        else if(this.parents[element]!=element){            //jika parent dari element bukan element itu sendiri
            // int counter = this.parents[element];            //counter untuk menyimpan curr element
            x = findSets(this.parents[element]);            //rekursif untuk mencari root
            this.parents[element]=x;                        //mengganti parent dari curr element dengan hasil recursif
        }
        return x;
    }

    /**
     * Method union menggabungkan sets di mana element1 dan element2 berada.
     * Union-by-rank diimplementasikan saat menggabungkan kedua sets (keduanya bisa saja sama)
     * @param element1 element pertama
     * @param element2 element kedua
     */
    public void union(int element1, int element2){
        int repE1 = findSets(element1);                     
        int repE2 = findSets(element2);
        if(repE1!=repE2){                                   //setelah find set e1 dan e2 dicek apakah representatif e1 = e2, jika tidak sama lakukan oprasi dibawah
            if(this.ranks[repE1]==this.ranks[repE2]){       //jika rep e1 =  rep e2 maka rep e1 dirubah menjadi rep e2 dan rep e2 ditambahkan 1
                this.parents[repE1]= repE2;
                this.ranks[repE2]+=1;
            }
            else if(this.ranks[repE1]>this.ranks[repE2]){   //jika rep e1>dari rep e2, maka rep e2 diganti dengan rep e1
                this.parents[repE2] = repE1;
            }
            else{
                this.parents[repE1] = repE2;
            }
        }
        
    }
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);

        int kota = sc.nextInt();
        int tol = sc.nextInt();

        dodopelago ds = new dodopelago(kota);

        for(int i =0; i<tol;i++){
            int kota1 = sc.nextInt();
            int kota2 = sc.nextInt();
            ds.union(kota1, kota2);
        }

        System.out.println(Arrays.toString(ds.parents));

        int element = 1;
        for(int i=0; i+1<kota;i++){
            if(ds.parents[i]!=ds.parents[i+1]){
                element+=1;
            }
        }
        

        int[] jumlah_kota = new int[element];

        for(int i=0; i<jumlah_kota.length;i++ ){
            for(int j=0; j<kota;j++){
                if(ds.parents[i]==ds.parents[j]){
                    jumlah_kota[i]+=1;
                }
            }
        } 
        // float max_count = 0;
        // int max_freq = 0;
        // for(int i =0; i<kota;i++){
        //     int count = 0;
        //     for(int k = 0; k<kota; k++){
        //         if(ds.parents[i]==ds.parents[k]){
        //             count++;
        //         }
        //     }
        //     if(count>max_count){
        //         max_count = count;
        //         max_freq = ds.parents[i];
        //     }
        // }
        
        // float kotatotal = kota;
        // float x = max_count/kotatotal;
        // int count_print =  (int)max_count;
        
        // if(x<=0.5){
        //     System.out.println("tidak dapat ditentukan");
        // }
        // else{
        //     System.out.println("pulau dengan "+count_print+" kota");
        // }
        
    }
}
