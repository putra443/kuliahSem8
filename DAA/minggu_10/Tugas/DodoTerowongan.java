// package DAA.minggu_11.Tugas;
import java.util.*;
public class DodoTerowongan {
    
    public static int minimumWeight(int[][] graph, int jumlahRumah, int jumlahTerowongan){
        int totalWeight=0;
        MinPrioQueue pq = new MinPrioQueue(jumlahRumah);
        pq.insert(1,0);
        boolean [] isVisited = new boolean[jumlahRumah];
        isVisited[0] = true;
        while(pq.size>0){
            int[] hasilExtract = pq.extractMin();
            int idExtract = hasilExtract[0];
            int keyExtract = hasilExtract[1];

            for(int i = 0; i<jumlahRumah; i++){
                for(int j = 0; j<jumlahRumah;j++){
                    if(isVisited)
                }
            }
        }
        return totalWeight;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlahRumah = sc.nextInt();
        int jumlahTerowongan = sc.nextInt();
        int[][] graph  = new int[jumlahRumah][jumlahRumah];
        for(int i=0; i<jumlahTerowongan; i++){
            int rumahA = sc.nextInt()-1;
            int rumahB = sc.nextInt()-1;
            int bobot = sc.nextInt();
            graph[rumahA][rumahB] = bobot;
            graph[rumahB][rumahA] = bobot;
        }
        System.out.println();
        for(int i =0; i<jumlahRumah;i++){
            for(int j = 0; j<jumlahRumah;j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        minimumWeight(graph,jumlahTerowongan,jumlahRumah);
    }   
}
class MinPrioQueue {
    private class Data{
        int id;
        int key;

        Data(int id, int key){
            this.id = id;
            this.key = key;
        }
    }

    private Data[] heap;
    private int position[];
    private int length;
    public int size;
    
    public MinPrioQueue(int length){
        this.length = length;
        this.size = 0;
        this.heap = new Data[length+1];
        this.position = new int[length+1];
    }

    private int getLeft(int i){return i<<1;}
    private int getRight(int i){return (i<<1) |1;}
    private int getParent(int i){return i>>1;}


    private void swap(int idx1, int idx2){
        //tukar isi heap
        Data temp = this.heap[idx1];
        this.heap[idx1] = this.heap[idx1] = this.heap[idx2];
        this.heap[idx2] = temp;
        
        //ambil id
        int id1 = this.heap[idx1].id;
        int id2 = this.heap[idx2].id;

        //tukar isi array position
        int temp2 = this.position[id1];
        this.position[id1] = this.position[id2];
        this.position[id2] = temp2;
    }

    public void minHeapify(int i){
        int smallest = i;
        int left = this.getLeft(i);
        int right = this.getRight(i);
        

        if(left <= this.size && this.heap[left].key < this.heap[smallest].key){
            smallest = left;
        }
        if(right <= this.size && this.heap[right].key < this.heap[smallest].key){
            smallest = right;
        }
        if(smallest!=i){
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    private void decreaseKey(int id, int newKey){
        int curr = this.position[id]; //mengambil index-nya
        if(curr==0){                  //tidak ada id tersebut
            return;
        }
        
        this.heap[curr].key = newKey;
        while(id > 1 && this.heap[this.getParent(id)].key > this.heap[id].key){
            swap(id, this.getParent(id));
            id = this.getParent(id);
        } 
        
    }

    public boolean insert(int id, int key){
        if(this.size == this.length){       //heap penuh
            return false;
        }
        else if(id<=0 || id>this.length){   //id diluar range
            return false;
        }
        else if(this.position[id]!=0){      //id duplikat
            return false;
        }
        else{
            this.size+=1;
            this.heap[this.size] = new Data(id, key);
            position[id] = size;
            decreaseKey(this.size, key);
            return true;
        }
    }

    public int[] extractMin(){
        if(this.size==0){               //heap kosong
            return null;
        }
        this.swap(1, this.size);    //tukar ke paling belakang sekalian memperbaiki posisi
        Data d = this.heap[this.size];
        this.position[d.id] = 0;            //tandai id tersebut sudah dihapus dari heap
        this.size--;                        //ukuran heap berkurang 1
        this.minHeapify(1);

        int[] result = new int[2];
        result[0] = d.id;
        result[1] = d.key;
        return result;
    }
    
    public void print(){
        System.out.println("Heap");
        for(int i=1; i<this.size+1; i++){
            System.out.print("(" + this.heap[i].id + "," + this.heap[i].key + ")");
        }
        System.out.println();

        System.out.println("Position");
        for(int i=1 ; i<this.heap.length; i++){
            System.out.print(this.position[i]+ " ");
        }
        System.out.println("");

    }
    
}
