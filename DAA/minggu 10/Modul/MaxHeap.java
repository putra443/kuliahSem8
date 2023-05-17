import java.util.*;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;
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
        return maxHeap.toString();
    }
    private int getLeft(int i){
        return i<<1;
    }

    private int getRight(int i){
        return (i<<1) | 1;
    }

    private int getParent(int i){
        return i>>1;
    }

    public void maxHeapify(int i){
        int left = this.getLeft(i);
        int right = this.getRight(i);
        int largest = i;

        if(left<= this.heapSize && left > this.maxHeap[largest]){
            largest = left;
        }
        if(right <= this.heapSize && right > this.maxHeap[largest]){
            largest = right;
        }
        if(largest!=this.maxHeap[i]){
            int counter = this.maxHeap[i];
            this.maxHeap[i] = largest;
            largest = counter;
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap(){
        for(int i = this.heapSize/2;i>=1;i--){
            maxHeapify(i);
        }
    }

    public void insertKey(int key){
        this.heapSize = heapSize + 1;
        this.maxHeap[this.heapSize] = -Integer.MAX_VALUE;
        increaseKey(this.heapSize, key);
    }

    public boolean increaseKey(int i, int key){
        if(key<= this.maxHeap[i]){
            return false;
        }
        else{
            this.maxHeap[i] = key;
            while(i > 1 && this.maxHeap[this.getParent(i)]<this.maxHeap[i]){
                int counter = this.maxHeap[this.getParent(i)];
                this.maxHeap[this.getParent(i)]= this.maxHeap[i];
                this.maxHeap[i] = counter;
            }
            return true;
        }
    }

    public int extractMax(){
        int max = this.maxHeap[1];
        this.maxHeap[1] = this.maxHeap[this.heapSize];
        this.heapSize = heapSize-1;
        maxHeapify(1);
        return max;
    }

    public int max(){
        return maxHeap[0];
    }

    public void heapSort(){
        buildMaxHeap();
        for(int i = this.length; i>=1 ; i--){
            int counter = this.maxHeap[1];
            this.maxHeap[1] = this.maxHeap[i];
            this.maxHeap[i] = counter;
            maxHeapify(1);
        }
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
                System.out.println(maxHeap.toString());
            }
        }
    }
}



