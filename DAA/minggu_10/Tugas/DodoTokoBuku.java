// package DAA.minggu_10.Tugas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DodoTokoBuku {
    private int maxHeap[];
    private int heapSize;
    private int length;
    
    public DodoTokoBuku(int length){
        this.heapSize = 0;
        this.length = length;
        this.maxHeap = new int[length+1];
    }

    public DodoTokoBuku(int[] arr){
        this.heapSize = arr.length;
        this.length = arr.length;
        this.maxHeap = new int[length+1];
        for(int i =0; i<length;i++){
            this.maxHeap [i+1] =arr[i];
        }
    }

    public String toString(){
        int i =0;
        String res = "";
        while(i<this.heapSize){
            res += this.maxHeap[i]+ " ";
            i++;
        }
        return res;
    }
    private int getLeft(int i){
        return 2 * i;
    }

    private int getRight(int i){
        return (2 * i)+1;
    }

    private int getParent(int i){
        return i/2;
    }

    public void maxHeapify(int i){
        int left = this.getLeft(i);
        int right = this.getRight(i);
        int largest = i;

        if(left<= this.heapSize && this.maxHeap[left] > this.maxHeap[largest]){
            largest = left;
        }
        if(right <= this.heapSize && this.maxHeap[right] > this.maxHeap[largest]){
            largest = right;
        }
        if(largest!=i){
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap(){
        for(int i = this.heapSize/2; i>=1; i--){
            maxHeapify(i); 
        }
    }

    public void insertKey(int key){
        this.heapSize+=1;
        this.maxHeap[this.heapSize] = key;
        int curr = this.heapSize;
        while(curr > 0 && this.maxHeap[curr] > this.maxHeap[this.getParent(curr)]){
            swap(curr, this.getParent(curr));
            curr = this.getParent(curr);
        }
    }

    public boolean increaseKey(int i, int key){
        if(key<= this.maxHeap[i]){
            return false;
        }
        else{
            this.maxHeap[i] = key;
            while(i > 1 && this.maxHeap[this.getParent(i)]<this.maxHeap[i]){
                swap(i, this.getParent(i));
                i = this.getParent(i);
            }
            return true;
        }
    }

    public int extractMax(){
        int max = this.maxHeap[0];
        this.maxHeap[0] = this.maxHeap[this.heapSize];
        this.heapSize = this.heapSize-1;
        maxHeapify(0);
        return max;
    }

    public int max(){
        return maxHeap[0];
    }

    public void heapSort(){
        buildMaxHeap();
        int panjangUtama = this.heapSize;
        for(int i = this.length; i>=1 ; i--){
            swap(1, i);
            this.heapSize = this.heapSize-1;
            maxHeapify(1);
        }
        this.heapSize = panjangUtama;
    }

    private void swap(int i, int j) {
        int temp = this.maxHeap[i];
        this.maxHeap[i] = this.maxHeap[j];
        this.maxHeap[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        DodoTokoBuku maxHeap = new DodoTokoBuku(X);

        for (int i =0; i< maxHeap.length; i++){
            int pembelian = Integer.parseInt(br.readLine());
            maxHeap.insertKey(pembelian);
        }

        String[] kumpulan_output  = new String[n];
        for(int i =0; i<n; i++){
            int output = maxHeap.extractMax();
            kumpulan_output[i] = "Pemenang ke-"+(i+1)+": " +output;
        }

        for(int i = kumpulan_output.length-1; i>=0; i--){
            System.out.println(kumpulan_output[i]);
        }
    }
}
