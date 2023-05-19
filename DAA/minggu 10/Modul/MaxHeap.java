import java.util.*;

public class MaxHeap{
    private int maxHeap[];
    private int heapSize;
    private int length;
    
    public MaxHeap(int length){
        this.heapSize = 0;
        this.length = length;
        this.maxHeap = new int[length+1];
    }

    public MaxHeap(int[] arr){
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
        for(int i = this.heapSize/2;i>=1;i--){
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
        this.maxHeap[1] = this.maxHeap[this.heapSize];
        this.heapSize = this.heapSize-1;
        maxHeapify(1);
        return max;
    }

    public int max(){
        return maxHeap[0];
    }

    public void heapSort(){
        buildMaxHeap();
        int panjangUtama = this.heapSize;
        for(int i = this.length; i>=2 ; i--){
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxHeap maxHeap = new MaxHeap(100000);
        while(sc.hasNext()){
            String input = sc.next();
            if(input.equals("insert")){
                int angka = sc.nextInt();
                maxHeap.insertKey(angka);
            }
            if(input.equals("extract")){
                if(maxHeap.max()!=0){
                    System.out.println(maxHeap.extractMax());
                }
                else{
                    System.out.println("-");
                }
            }
            if(input.equals("end")){
                maxHeap.heapSort();
                System.out.println(maxHeap.toString());
                break;
            }
        }

    }
}



