package DAA.minggu_11.modul;
public class MinPrioQueueGPT{
    private class Data {
        private int id;
        private int key;

        public Data(int id, int key) {
            this.id = id;
            this.key = key;
        }
    }

    private Data[] heap;
    private int[] position;
    private int length;
    private int size;

    public MinPrioQueueGPT(int capacity) {
        length = capacity + 1; // Add 1 to account for unused index 0
        heap = new Data[length];
        position = new int[length];
        size = 0;
    }

    private int getLeft(int i){return i<<1;}
    private int getRight(int i){return (i<<1)|1;}
    private int parent(int i){return i>>1;}


    public boolean insert(int id, int key) {
        if (id <= 0 || id >= length) {
            // throw new IllegalArgumentException("ID is out of range.");
            return false;
        }

        if (position[id] != 0) {
            // throw new IllegalArgumentException("ID already exists in the priority queue.");
            return false;
        }

        if (size == length - 1) {
            // throw new IllegalStateException("Priority queue is full.");
            return false;
        }

        size++;
        heap[size] = new Data(id, key);
        position[id] = size;
        decreaseKey(size, key);
        return true;
    }

    public void decreaseKey(int id, int newKey) {
        if (id <= 0 || id >= length) {
            // throw new IllegalArgumentException("ID is out of range.");
            return;
        }

        int index = position[id];

        if (index == 0) {
            // throw new IllegalArgumentException("ID does not exist in the priority queue.");
            return;
        }

        if (newKey > heap[index].key) {
            // throw new IllegalArgumentException("New key is greater than the current key.");
            return;
        }

        heap[index].key = newKey;

        while (index > 1 && heap[parent(index)].key > heap[index].key) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int[] extractMin() {
        if (size == 0) {
            return null;
        }

        int[] minData = new int[2];
        minData[0] = heap[1].id;
        minData[1] = heap[1].key;

        position[heap[1].id] = 0; // Mark ID as no longer in the priority queue

        heap[1] = heap[size];
        position[heap[1].id] = 1; // Update position of the last element in the heap
        size--;

        heapify(1);

        return minData;
    }

    private void heapify(int index) {
        int smallest = index;
        int left = getLeft(index);
        int right = getRight(index);

        if (left <= size && heap[left].key < heap[smallest].key) {
            smallest = left;
        }

        if (right <= size && heap[right].key < heap[smallest].key) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

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

    public void print(){
        System.out.println("Heap");
        for(int i=1; i<this.size+1; i++){
            System.out.print("(" + this.heap[i].id + "," + this.heap[i].key + ")");
        }
        System.out.println();

        System.out.println("Position");
        for(int i=1 ; i<this.length; i++){
            System.out.print(this.position[i]+ " ");
        }
        System.out.println("");
        System.out.println(this.length);

    }

    public static void main(String[] args) {
        MinPrioQueueGPT pq = new MinPrioQueueGPT(5);
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