package DAA.minggu_11.modul;
import java.util.*;
public class MinPrioQueue {
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
    private int size;

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
        System.out.println(this.length);

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinPrioQueue pq = new MinPrioQueue(5);
        pq.insert(1,4);
        pq.insert(2,1);
        pq.insert(3,5);
        pq.insert(0,4);                         //gagal id diluar range
        pq.insert(6,4);                         //gagal id diluar range
        pq.insert(3,7);                         //gagal id duplikat
        pq.insert(4,2);
        pq.print();

        int[] res = pq.extractMin();
        System.out.println("Min: " + res[0] + "," + res[1]);
        pq.print();

        res = pq.extractMin();
        System.out.println("Min: " + res[0] + "," + res[1]);
        pq.print();
    }

}
