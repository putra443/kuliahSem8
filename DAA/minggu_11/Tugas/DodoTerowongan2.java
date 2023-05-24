package DAA.minggu_11.Tugas;

import java.util.*;

class MinPrioQueue2 {
    private class Data {
        int id;
        int key;

        Data(int id, int key) {
            this.id = id;
            this.key = key;
        }
    }

    private Data[] heap;
    public int position[];
    private int length;
    public int size;

    public MinPrioQueue2(int length) {
        this.length = length;
        this.size = 0;
        this.heap = new Data[length + 1];
        this.position = new int[length + 1];
    }

    private int getLeft(int i) {
        return i << 1;
    }

    private int getRight(int i) {
        return (i << 1) | 1;
    }

    private int getParent(int i) {
        return i >> 1;
    }

    private void swap(int idx1, int idx2) {
        // Tukar isi heap
        Data temp = this.heap[idx1];
        this.heap[idx1] = this.heap[idx2];
        this.heap[idx2] = temp;

        // Ambil id
        int id1 = this.heap[idx1].id;
        int id2 = this.heap[idx2].id;

        // Tukar isi array position
        int temp2 = this.position[id1];
        this.position[id1] = this.position[id2];
        this.position[id2] = temp2;
    }

    public void minHeapify(int i) {
        int smallest = i;
        int left = this.getLeft(i);
        int right = this.getRight(i);

        if (left <= this.size && this.heap[left].key < this.heap[smallest].key) {
            smallest = left;
        }
        if (right <= this.size && this.heap[right].key < this.heap[smallest].key) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    private void decreaseKey(int id, int newKey) {
        int curr = this.position[id]; // Mengambil index-nya
        if (curr == 0) { // Tidak ada id tersebut
            return;
        }

        this.heap[curr].key = newKey;
        while (id > 1 && this.heap[this.getParent(id)].key > this.heap[id].key) {
            swap(id, this.getParent(id));
            id = this.getParent(id);
        }
    }

    public boolean insert(int id, int key) {
        if (this.size == this.length) { // Heap penuh
            return false;
        } else if (id <= 0 || id > this.length) { // Id diluar range
            return false;
        } else if (this.position[id] != 0) { // Id duplikat
            return false;
        } else {
            this.size += 1;
            this.heap[this.size] = new Data(id, key);
            position[id] = size;
            decreaseKey(this.size, key);
            return true;
        }
    }

    public int[] extractMin() {
        if (this.size == 0) { // Heap kosong
            return null;
        }
        this.swap(1, this.size); // Tukar ke paling belakang sekalian memperbaiki posisi
        Data d = this.heap[this.size];
        this.position[d.id] = 0; // Tandai id tersebut sudah dihapus dari heap
        this.size--; // Ukuran heap berkurang 1
        this.minHeapify(1);

        int[] result = new int[2];
        result[0] = d.id;
        result[1] = d.key;
        return result;
    }

    public void print() {
        System.out.println("Heap");
        for (int i = 1; i < this.size + 1; i++) {
            System.out.print("(" + this.heap[i].id + "," + this.heap[i].key + ")");
        }
        System.out.println();

        System.out.println("Position");
        for (int i = 1; i < this.heap.length; i++) {
            System.out.print(this.position[i] + " ");
        }
        System.out.println("");
    }
}

public class DodoTerowongan2 {
    private static int findMinimumEnergy(int n, int k, int[][] tunnels) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            int a = tunnels[i][0];
            int b = tunnels[i][1];
            int w = tunnels[i][2];
            graph[a][b] = w;
            graph[b][a] = w;
        }

        boolean[] visited = new boolean[n + 1];
        MinPrioQueue pq = new MinPrioQueue(n);
        pq.insert(1, 0);

        int totalEnergy = 0;
        while (pq.size > 0) {
            int[] min = pq.extractMin();
            int u = min[0];
            int energy = min[1];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            totalEnergy += energy;

            for (int v = 1; v <= n; v++) {
                if (graph[u][v] > 0 && !visited[v]) {
                    pq.insert(v, graph[u][v]);
                }
            }
        }

        return totalEnergy;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] tunnels = new int[k][3];
        for (int i = 0; i < k; i++) {
            tunnels[i][0] = scanner.nextInt();
            tunnels[i][1] = scanner.nextInt();
            tunnels[i][2] = scanner.nextInt();
        }
        scanner.close();

        int minimumEnergy = findMinimumEnergy(n, k, tunnels);
        System.out.println(minimumEnergy);
    }
}
