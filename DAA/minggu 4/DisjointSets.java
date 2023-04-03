import java.util.Scanner;
import java.util.*;

/**
 * Kelas Disjoint Sets
 * Implementasi dair disjoint sets dengan array
 * Prosedur findsets dengan path-compression dan prosedur union dengan union-by-rank.
 */
public class DisjointSets{
    int numOfElements;      // jumlah element pada disjoint sets
    int[] parents;          // menyimpan parent dari setiap element
    int[] ranks;            // menyimpan rank dari setiap element

    /**
     * Constroctor dari kelas disjointSets. Jumlah elemen tidak 
     * dapat berubah. Versi yang lebih baik bisa berubah (gunakan vector).
     */
    DisjointSets(int numOfElements){
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

    /**
     * Main program untuk mencoba kelas DisjointSets
     */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);                                                //
        int make_set = sc.nextInt();                                                        //input pertama untuk make set sebanyak n kali
        String[] arrayOutputs = new String[1000];                                           //array untuk menyimpan output
        int i = 1;                                                                          //idx yang nanti digunakan untuk iterasi satu per satu pada arrayOutputs
        arrayOutputs[0] = "make-set "+make_set+" times";                                    //masukkan output pertama yang menunjukkan berapa kali melakukan make set
        // System.out.println("make-set "+make_set+" times");

        DisjointSets ds = new DisjointSets(make_set);                                       //inisialisasi object DisjointSets
        String input = sc.next();                                                           //untuk input pertama setelah make set
        
        while(!input.equals("x")){                                                     //untuk looping selama input tidak sama dengan x
            if(input.equals("f")){                                                     // jika input == f, maka lakukan oprasi findset
                int idx = sc.nextInt();                                                         //param untuk findset
                int findSetsRes = ds.findSets(idx);                                             //pemanggilan method findset
                // System.out.println("representative of "+idx+" is " + findSetsRes);           
                arrayOutputs[i] = "representative of "+idx+" is " + findSetsRes;                //masukkan output hasi findset ke arrayOutput
                i++;                                                                            
            }
            else if(input.equals("u")){                                                 //jika input ==u lakukan oprasi union
                int element1 = sc.nextInt();                                                     //param 1 untuk union
                int element2 = sc.nextInt();                                                     //param 2 untuk union 
                ds.union(element1,element2);                                                     //pemanggilan method union
                // System.out.println("union between "+ element1 +" and "+ element2);
                arrayOutputs[i] = "union between "+ element1 +" and "+ element2;                 //masukkan hasil oprasi union ke arrayOutput
                i++;
            }
            else if(input.equals("t")){                                                 //jika input = t, print list of parents
                String array_parents = Arrays.toString(ds.parents);                              //method untuk membuat array menjadi string
                // System.out.println("list of parents: "+array_parents);
                arrayOutputs[i] = "list of parents: "+array_parents;                             //masukkan output string parents ke arrayOutput
                i++;
            }
            else if(input.equals("k")){                                                 //jika input == k print list of ranks
                String array_ranks = Arrays.toString(ds.ranks);                                  //method untuk membuat array menjadi string   
                // System.out.println("list of ranks: "+array_ranks);   
                arrayOutputs[i] = "list of ranks  : "+array_ranks;                               //masukkan output string ranks ke arrayOutput
                i++;
            }
            else if(input.equals("p")){                                                 //jika input == p print parent dari param
                int idx = sc.nextInt();                                                           //input index param yang ingin dicari parentnya
                // System.out.println("parents of "+idx+" is "+ds.parents[idx]);
                arrayOutputs[i] = "parents of "+idx+" is "+ds.parents[idx];                       // masukkan hasil pencarian parent ke arrayOutput
                i++;
            }
            else if(input.equals("r")){                                                 //jika input == r print rank dari param
                int idx = sc.nextInt();                                                          //input index param yang ingin dicari ranknya
                // System.out.println("ranks of "+idx+" is "+ds.ranks[idx]);
                arrayOutputs[i] = "ranks of "+idx+" is "+ds.ranks[idx];                          //masukkan hasil pencarian rank ke arrayOutput
                i++;
            }
            
            input = sc.next();                                                                  //meminta output berikutnya
        }

        /**
         * oprasi dibawah dilakukan untuk memprint semua hasil output dari oprasi yang dilakukan diatas.
         */
        for(int k =0; k<arrayOutputs.length;k++){
            if(arrayOutputs[k]!=null){
                System.out.println(arrayOutputs[k]);
            }
            else{
                break;
            }
        }
        
        
    }
}